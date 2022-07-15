package com.example.nasa.rover.ui.roverAdapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nasa.rover.model.RoverData
import timber.log.Timber

class RoverRecyclerAdapter(
    val onClick: (RoverData.CuriosityPhoto) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = mutableListOf<RoverData.CuriosityPhoto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RoverRecyclerViewHolder(parent, onClick)

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder, position: Int
    ) {
        when (holder) {
            is RoverRecyclerViewHolder -> {
                holder.bind(item = data[position])
            }
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        when (holder) {
            is RoverRecyclerViewHolder -> holder.detach()
        }
    }

    override fun getItemCount() = data.size

    fun setItems(list: List<RoverData.CuriosityPhoto>) {
        data.clear()
        data.addAll(list)
        Timber.i("Data: $data ")
        notifyDataSetChanged()
    }
}
