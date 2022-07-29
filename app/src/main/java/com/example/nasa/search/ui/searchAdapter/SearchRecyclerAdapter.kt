package com.example.nasa.search.ui.searchAdapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nasa.search.model.SearchData
import timber.log.Timber

class SearchRecyclerAdapter(
    val onSearchButtonClick: (SearchData.ItemParsed) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val searchData = mutableListOf<SearchData.ItemParsed>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SearchRecyclerViewHolder(parent, onSearchButtonClick)

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder, position: Int
    ) {
        when (holder) {
            is SearchRecyclerViewHolder -> {
                holder.bind(textData = searchData[position])
            }
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        when (holder) {
            is SearchRecyclerViewHolder -> holder.detach()
        }
    }

    override fun getItemCount() = searchData.size

    fun setItems(dataList: List<SearchData.ItemParsed>?) {
        searchData.clear()
        if (dataList != null) {
            searchData.addAll(dataList)
        }
        Timber.i("Data: $dataList ")
        notifyDataSetChanged()
    }
}
