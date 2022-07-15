package com.example.nasa.apod.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.example.nasa.R
import com.example.nasa.apod.model.ApodListOfAllData
import com.example.nasa.common.mvp.BaseFragment
import com.example.nasa.databinding.ApodBigItemBinding
import timber.log.Timber

class ApodZoomedFragment(
    @LayoutRes layoutRes: Int
) : BaseFragment(layoutRes) {

    private lateinit var binding: ApodBigItemBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        try {
            binding = ApodBigItemBinding.inflate(inflater, container, false)
            return binding.root
        } catch (e: Exception) {
            Timber.e("Fragment exception: $e")
        }
        binding = ApodBigItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data =
            arguments?.getParcelable<ApodListOfAllData.ApodAllData>("")
        context?.let {
            try {
                Glide.with(it).asBitmap().load(data?.hdurl)
                    .placeholder(R.drawable.landscape_placeholder)
                    .into(binding.apodBigImageView)
            } catch (e: Exception) {
                Timber.e("Bad Glide input $e")
            }
        }
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            binding.apodBigProgressBar?.visibility = View.GONE
        }, 500)
    }
}