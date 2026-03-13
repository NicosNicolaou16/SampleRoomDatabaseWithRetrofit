package com.nick.sampleroomandretrofit.utils.binding;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ImageBindingAdapter {
    @BindingAdapter("imageUrl")
    public static void loadImageBinding(ImageView view, String url) {
        if (url != null && !url.isEmpty()) {
            Glide.with(view.getContext()).load(url).into(view);
        }
    }
}
