package com.example.nasa.apod.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nasa.R
import com.example.nasa.apod.model.ApodListOfAllData
import com.example.nasa.apod.ui.apodListAdapter.ApodListRecyclerAdapter
import com.example.nasa.common.mvp.BaseFragmentMvp
import com.example.nasa.databinding.ApodRecyclerBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.MaterialDatePicker
import org.koin.android.ext.android.inject

class ApodListFragment :
    BaseFragmentMvp<ApodListContract.View, ApodListContract.Presenter>(R.layout.apod_recycler),
    ApodListContract.View {

    override val presenter: ApodListPresenter by inject()

    private lateinit var binding: ApodRecyclerBinding

    private val apodListRecyclerAdapter: ApodListRecyclerAdapter by lazy {
        ApodListRecyclerAdapter(onApodAllClick = { showBigItem(it) })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ApodRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        apodRecyclerView?.layoutManager = LinearLayoutManager(requireContext())
        apodRecyclerView?.adapter = ConcatAdapter(apodListRecyclerAdapter)
        presenter.getApodListData()
    }

    private fun showBigItem(apodData: ApodListOfAllData.ApodAllData) {
        val fragment = ApodZoomedFragment(R.layout.apod_big_item)
        val bundle = Bundle()
        bundle.putParcelable("", apodData)
        fragment.arguments = bundle
        changeFragment(fragment, R.id.contentContainer)
    }

    override fun showApodListData(apodAllData: List<ApodListOfAllData.ApodAllData>) {
        apodListRecyclerAdapter.setItems(apodAllData)
        with(binding) {
            apodRecyclerProgressBar?.visibility = View.GONE
        }
    }
}