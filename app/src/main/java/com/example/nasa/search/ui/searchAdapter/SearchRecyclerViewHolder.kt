package com.example.nasa.search.ui.searchAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nasa.R
import com.example.nasa.databinding.SearchItemBinding
import com.example.nasa.search.model.SearchData

class SearchRecyclerViewHolder(
    val binding: SearchItemBinding,
    private val onSearchButtonClick: (SearchData.ItemParsed) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    constructor(
        parent: ViewGroup,
        onSearchButtonClick: (SearchData.ItemParsed) -> Unit
    ) : this(
        SearchItemBinding.inflate(
            LayoutInflater.from(
                parent.context
            ), parent, false
        ), onSearchButtonClick
    )

    fun bind(textData: SearchData.ItemParsed) {
        with(binding) {
            if (textData.link?.get(0)?.href != null && textData.link.get(0)?.href != "" && textData.data?.get(
                    0
                )?.description != null && textData.data?.get(0)?.description != ""
            ) {
                searchImageView?.context?.let {
                    Glide.with(it).asBitmap().load(textData.link.get(0).href)
                        .placeholder(R.drawable.landscape_placeholder).into(searchImageView)
                }
                searchTextView?.text = textData.data.get(0)?.description.toString()
                searchImageView?.setOnClickListener {
                    onSearchButtonClick.invoke(textData)
                }
            } else {
                searchImageView?.context?.let {
                    Glide.with(it).asBitmap().load(R.drawable.landscape_placeholder)
                        .placeholder(R.drawable.landscape_placeholder).into(searchImageView)
                }
                searchTextView?.text =
                    "You have bad query input.\nGo back and change your query \uD83D\uDE43"
            }
        }
    }

    fun detach() {
        binding.searchImageView?.let { Glide.with(itemView).clear(it) }
    }
}
