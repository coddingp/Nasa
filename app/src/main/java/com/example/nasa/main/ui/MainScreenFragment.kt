package com.example.nasa.main.ui

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.icu.util.ULocale
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.example.nasa.R
import com.example.nasa.apod.ui.ApodListFragment
import com.example.nasa.common.mvp.BaseFragment
import com.example.nasa.databinding.MainScreenBinding
import com.example.nasa.earth.EarthFragment
import com.example.nasa.main.model.ApodData
import com.example.nasa.radio.RadioFragment
import com.example.nasa.rover.ui.RoverFragment
import com.example.nasa.search.ui.SearchFragment
import com.example.nasa.utils.Utils.endDate
import com.example.nasa.utils.Utils.startDate
import com.example.nasa.utils.Utils.userRequest
import org.koin.android.ext.android.inject
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class MainScreenFragment : BaseFragment(R.layout.main_screen), MainContract, MainContract.View {

    private lateinit var binding: MainScreenBinding

    val presenter: MainPresenter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this@MainScreenFragment)

        with(binding) {
            curiosityMainImageView?.setOnClickListener {
                changeFragment(RoverFragment(), R.id.contentContainer)
            }

            nasaMainImageView?.setOnClickListener {
                changeFragment(RadioFragment(), R.id.contentContainer)
            }
            youtubeImageButton1?.setOnClickListener {
                changeFragment(RadioFragment(), R.id.contentContainer)
            }

            earthMainImageView?.setOnClickListener {
                changeFragment(EarthFragment(), R.id.contentContainer)
            }

            youtubeImageButton2?.setOnClickListener {
                changeFragment(EarthFragment(), R.id.contentContainer)
            }

            apodMainImageView?.setOnClickListener {
                changeFragment(ApodListFragment(), R.id.contentContainer)
            }

            userQueryEditText?.setOnClickListener {
                userQueryEditText.hint = ""
            }
            searchButton?.setOnClickListener {
                if (userQueryEditText?.text?.isNotEmpty()!! && userQueryEditText.text.length > 1) {
                    userRequest = userQueryEditText.text.toString()
                    changeFragment(SearchFragment(), R.id.contentContainer)
                    userQueryEditText.text.clear()
                } else Toast.makeText(context, "Bad request", Toast.LENGTH_SHORT).show()
            }

            startDateButton?.text = StringBuilder()
                .append("< ")
                .append(LocalDate.now().plusDays(-30).toString())
                .append(" \uD83D\uDDD3 >")
            startDate = LocalDate.now().plusDays(-30).toString()
            endDateButton?.text = StringBuilder()
                .append("< ")
                .append(LocalDate.now().plusDays(-1).toString())
                .append(" \uD83D\uDDD3 >")
            endDate = LocalDate.now().plusDays(-1).toString()

//            presenter.deleteData()
            presenter.insertApodData()
            presenter.collectFlowApodData()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun updateStartLable(calendar: Calendar) {
        val myFormat = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        startDate = sdf.format((calendar.time))
        binding.startDateButton?.text = "< " + sdf.format((calendar.time)) + " \uD83D\uDDD3 >"
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun updateEndLable(calendar: Calendar) {
        val myFormat = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        endDate = sdf.format((calendar.time))
        binding.endDateButton?.text = "< " + sdf.format((calendar.time)) + " \uD83D\uDDD3 >"
    }

    override fun showRefreshing(isRefreshing: Boolean) {

    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun showApodData(apodData: ApodData) {

        val calendar: Calendar = Calendar.getInstance(ULocale("en_US@calendar=civil"))
        val startDatePickerDialog =
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateStartLable(calendar)
            }

        val endDatePickerDialog =
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateEndLable(calendar)
            }

        binding.startDateButton?.setOnClickListener {
            context?.let { it1 ->
                DatePickerDialog(
                    it1,
                    startDatePickerDialog,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
        }

        binding.endDateButton?.setOnClickListener {
            context?.let { it1 ->
                DatePickerDialog(
                    it1,
                    endDatePickerDialog,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
        }

        with(binding) {
            if (apodData.copyright != null) {
                apodMainTextView?.text = StringBuilder()
                    .append("Made by : ")
                    .append(apodData.copyright.toString())
            } else {
                apodMainTextView?.text = "Made by : Unknown photographer"
            }
            Glide.with(apodMainImageView).asBitmap().load(apodData.url)
                .placeholder(R.drawable.landscape_placeholder).into(apodMainImageView)
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                mainApodProgressBar?.visibility = View.GONE
            }, 300)
        }
    }

    override fun failure(t: Throwable) {
    }
}