package com.example.nasa.search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.example.nasa.R
import com.example.nasa.common.mvp.BaseFragment
import com.example.nasa.databinding.SearchBigItemBinding
import com.example.nasa.search.model.SearchData
import timber.log.Timber

class SearchZoomedItemFragment(
    @LayoutRes layoutRes: Int
) : BaseFragment(layoutRes) {

    private lateinit var binding: SearchBigItemBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        try {
            binding = SearchBigItemBinding.inflate(inflater, container, false)
            return binding.root
        } catch (e: Exception) {
            Timber.e("Fragment exception: $e")
        }
        binding = SearchBigItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data =
            arguments?.getParcelable<SearchData.ItemParsed>("items")
        context?.let {
            try {
                Glide.with(it).asBitmap().load(data?.link?.get(0)?.href)
                    .placeholder(R.drawable.landscape_placeholder)
                    .into(binding.searchBigImageView)
            } catch (e: Exception) {
                Timber.e("Bad Glide input $e")
            }
        }
    }
}