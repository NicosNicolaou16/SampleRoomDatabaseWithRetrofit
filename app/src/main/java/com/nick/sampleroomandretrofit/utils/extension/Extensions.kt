package com.nick.sampleroomandretrofit.utils.extension

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.request.RequestOptions
import com.nick.sampleroomandretrofit.R

fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}

fun ImageView.loadImageBind(drawable: Int?, progressDrawable: CircularProgressDrawable) {
    val options = RequestOptions()
            .placeholder(progressDrawable)
            .error(R.mipmap.ic_launcher_round)
    Glide.with(context)
            .setDefaultRequestOptions(options)
            .load(drawable)
            .into(this)
}

@BindingAdapter("android:imageDrawable")
fun loadImageBinding(imageView: ImageView, drawable: Int) {
    imageView.loadImageBind(drawable, getProgressDrawable(imageView.context))
}