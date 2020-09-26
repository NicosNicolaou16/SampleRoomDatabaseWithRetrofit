package com.nick.sampleroomandretrofit.extension

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nick.sampleroomandretrofit.R

fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}

fun ImageView.loadImageBind(url: String?, progressDrawable: CircularProgressDrawable) {
    val options = RequestOptions()
            .placeholder(progressDrawable)
            .error(R.mipmap.ic_launcher_round)
    Glide.with(context)
            .setDefaultRequestOptions(options)
            .load(url)
            .into(this)
}

@BindingAdapter("android:loadImage")
fun loadImageBinding(imageView: ImageView, url: String) {
    imageView.loadImageBind(url, getProgressDrawable(imageView.context))
}