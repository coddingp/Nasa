package com.example.nasa.apod.ui.apodListAdapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nasa.apod.model.ApodListOfAllData
import timber.log.Timber

class ApodListRecyclerAdapter(
    val onApodAllClick: (ApodListOfAllData.ApodAllData) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val apodData = mutableListOf<ApodListOfAllData.ApodAllData?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ApodListRecyclerViewHolder(parent, onApodAllClick)

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder, position: Int
    ) {
        when (holder) {
            is ApodListRecyclerViewHolder -> {
                apodData[position]?.let { holder.bind(apodAllData = it) }
            }
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        when (holder) {
            is ApodListRecyclerViewHolder -> holder.detach()
        }
    }

    override fun getItemCount() = apodData.size

    fun setItems(list: List<ApodListOfAllData.ApodAllData?>) {
        apodData.clear()
        if (list != null) {
            apodData.addAll(list)
        }
        Timber.i("Data: $apodData ")
        notifyDataSetChanged()
    }
}
