package com.example.nasa.search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nasa.R
import com.example.nasa.common.mvp.BaseFragmentMvp
import com.example.nasa.databinding.SearchRecyclerBinding
import com.example.nasa.search.model.SearchData
import com.example.nasa.search.ui.searchAdapter.SearchRecyclerAdapter
import org.koin.android.ext.android.inject


class SearchFragment :
    BaseFragmentMvp<SearchContract.View, SearchContract.Presenter>(R.layout.search_recycler),
    SearchContract.View {

    override val presenter: SearchPresenter by inject()

    private lateinit var binding: SearchRecyclerBinding

    private val searchAdapter: SearchRecyclerAdapter by lazy {
        SearchRecyclerAdapter(onSearchButtonClick = { showZoomedItem(it) })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        searchRecycler?.layoutManager = LinearLayoutManager(requireContext())
        searchRecycler?.adapter = searchAdapter
        presenter.getSearchData(1)

        searchRecycler.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = searchAdapter
            addOnScrollListener(SearchScrollListener(
                layoutManager as LinearLayoutManager,
                loadNextPage = { presenter.getSearchData(it) }
            ))
        }
    }

    private fun showZoomedItem(searchData: SearchData.ItemParsed) {
        val fragment = SearchZoomedItemFragment(R.layout.search_big_item)
        val bundle = Bundle()
        bundle.putParcelable("items", searchData)
        fragment.arguments = bundle
        changeFragment(fragment, R.id.contentContainer)
    }

    override fun showRefreshing(isRefreshing: Boolean) {
        TODO("Not yet implemented")
    }

    override fun showSearchData(data: List<SearchData.ItemParsed>?) {
        if (data == null) {
            Toast.makeText(context, "Bad query", Toast.LENGTH_LONG).show()
        } else {
            searchAdapter.setItems(data)
            binding.searchRecyclerProgressBar?.visibility = View.GONE
        }
    }

    override fun failure(t: Throwable) {
        TODO("Not yet implemented")
    }
}