package com.example.nasa.rover.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.example.nasa.R
import com.example.nasa.common.mvp.BaseFragment
import com.example.nasa.databinding.RoverBigItemBinding
import com.example.nasa.rover.model.RoverData
import timber.log.Timber


class RoverDetailedFragment(
    @LayoutRes layoutRes: Int
) : BaseFragment(layoutRes) {

    private lateinit var binding: RoverBigItemBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        try {
            binding = RoverBigItemBinding.inflate(inflater, container, false)
            return binding.root
        } catch (e: Exception) {
            Timber.e("Fragment exception: $e")
        }
        binding = RoverBigItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data =
            arguments?.getParcelable<RoverData.CuriosityPhoto>("photos")
        if (data != null) {
            context?.let {
                try {
                    Glide.with(it).asBitmap().load(data.imgSrc)
                        .placeholder(R.drawable.landscape_placeholder)
                        .into(binding.roverBigImageView)
                } catch (e: Exception) {
                    Timber.e("Bad Glide input $e")
                }
            }
        }
    }
}