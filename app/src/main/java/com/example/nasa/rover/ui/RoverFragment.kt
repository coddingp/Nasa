package com.example.nasa.rover.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nasa.R
import com.example.nasa.common.mvp.BaseFragmentMvp
import com.example.nasa.databinding.RoverRecyclerBinding
import com.example.nasa.rover.model.RoverData
import com.example.nasa.rover.ui.roverAdapter.RoverRecyclerAdapter
import org.koin.android.ext.android.inject
import timber.log.Timber

class RoverFragment :
    BaseFragmentMvp<RoverContract.View, RoverContract.Presenter>(R.layout.rover_recycler),
    RoverContract.View {

    override val presenter: RoverPresenter by inject()

    private lateinit var binding: RoverRecyclerBinding

    private val roverRecyclerAdapter: RoverRecyclerAdapter by lazy {
        RoverRecyclerAdapter(onClick = { showZoomedItem(it) })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RoverRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        roverRecycler.layoutManager = LinearLayoutManager(requireContext())
        roverRecycler.adapter = ConcatAdapter(roverRecyclerAdapter)
        presenter.insertRoverDataToDb(1)
        presenter.collectFlowPhotoList()
//        swipeRefresh.setOnRefreshListener {
//            presenter.refresh()
//        }
        roverRecycler.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = roverRecyclerAdapter
            addOnScrollListener(RoverScrollListener(
                layoutManager as LinearLayoutManager,
                loadNextPage = { presenter.insertRoverDataToDb(it) }
            ))
        }
    }

    private fun showZoomedItem(photos: RoverData.CuriosityPhoto) {
        val fragment = RoverDetailedFragment(R.layout.rover_big_item)
        val bundle = Bundle()
        bundle.putParcelable("photos", photos)
        fragment.arguments = bundle
        changeFragment(fragment, R.id.contentContainer)
    }

    override fun showRefreshing(isRefreshing: Boolean) {
//        binding.swipeRefresh.isRefreshing = isRefreshing
    }

    @RequiresApi(Build.VERSION_CODES.N)
    //changed RoverData.CuriosityPhoto to CuriosityPhotoEntityDat
    override fun showRoverPhotosList(data: List<RoverData.CuriosityPhoto>) {
        roverRecyclerAdapter.setItems(data)
        Timber.i("RoverFragment showRoverPhotosList $data")
        with(binding) {
            roverRecyclerProgressBar.visibility = View.GONE
        }
    }

    override fun failure(t: Throwable) {
        Timber.e(t.message)
    }
}