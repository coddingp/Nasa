package com.example.nasa.apod.ui.apodListAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nasa.R
import com.example.nasa.databinding.ApodItemBinding
import com.example.nasa.apod.model.ApodListOfAllData

class ApodListRecyclerViewHolder(
    val binding: ApodItemBinding,
    val onClick: (ApodListOfAllData.ApodAllData) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    constructor(
        parent: ViewGroup,
        onClick: (ApodListOfAllData.ApodAllData) -> Unit
    ) : this(
        ApodItemBinding.inflate(
            LayoutInflater.from(
                parent.context
            ), parent, false
        ), onClick
    )

    fun bind(apodAllData: ApodListOfAllData.ApodAllData) {
        with(binding) {
            if (apodAllData.url != null && apodAllData.url != "") {
                if (apodImageView != null) {
                    Glide.with(apodImageView.context).load(apodAllData.url)
                        .placeholder(R.drawable.landscape_placeholder).into(apodImageView)
                }
                apodTextView?.text = apodAllData.explanation.toString()
                apodImageView?.setOnClickListener {
                  onClick.invoke(apodAllData)
                }
            }
        }
    }

    fun detach() {
        binding.apodImageView?.let { Glide.with(itemView).clear(it) }
    }
}
