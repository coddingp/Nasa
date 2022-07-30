package com.example.nasa.rover.ui.roverAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nasa.R
import com.example.nasa.databinding.RoverItemBinding
import com.example.nasa.rover.model.RoverData
import timber.log.Timber

class RoverRecyclerViewHolder(
    val binding: RoverItemBinding,
    val onClick: (RoverData.CuriosityPhoto) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    constructor(
        parent: ViewGroup,
        onClick: (RoverData.CuriosityPhoto) -> Unit
    ) : this(
        RoverItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ), onClick
    )

    fun bind(item: RoverData.CuriosityPhoto) {
        with(binding) {
            Glide.with(itemView.context).asBitmap().override(600, 600).load(item.imgSrc)
                .placeholder(R.drawable.landscape_placeholder).into(roverImageView1)
            roverTextView1.text = item.camera.fullName
            Timber.i("Data: $item")
            itemView.setOnClickListener {
                onClick.invoke(item)
            }
        }
    }

    fun detach() {
        Glide.with(itemView).clear(binding.roverImageView1)
    }
}
