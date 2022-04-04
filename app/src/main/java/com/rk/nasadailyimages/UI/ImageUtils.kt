package com.rk.nasadailyimages.UI

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.rk.nasadailyimages.R

class ImageUtils {
    companion object{
        fun loadImageInView(context: Context, url:String, imageView:ImageView){
            Glide.with(context)
                .load(url) // image url
                .placeholder(R.drawable.placeholder_image) // any placeholder to load at start
                .error(R.drawable.error)  // any image in case of error
                .override(200, 200) // resizing
                .into(imageView)
        }
    }
}