package com.rk.nasadailyimages.UI

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.rk.nasadailyimages.R

class ImageUtils {
    companion object{
        fun loadImageInView(context: Context, url:String, imageView:ImageView){
            Glide.with(context)
                .load(url)
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.error)
                .override(200, 200)
                .into(imageView)
        }
    }
}