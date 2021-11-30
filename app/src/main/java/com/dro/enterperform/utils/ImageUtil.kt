package com.dro.enterperform.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImageUtil {

    private const val TAG = "ImageUtil"

    @JvmStatic
    @BindingAdapter("cover")
    fun loadPicture(imageView: ImageView, url: String?) {
        Glide.with(imageView.context).load(url).into(imageView)
    }


}