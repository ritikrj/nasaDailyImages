package com.rk.nasadailyimages.UI.screens.FavImagesScreen

import androidx.recyclerview.widget.RecyclerView
import com.rk.nasadailyimages.Data.DB.DataBaseEntity
import com.rk.nasadailyimages.UI.ImageUtils
import com.rk.nasadailyimages.databinding.FavItemBinding

class FavViewHolder(val binding:  FavItemBinding):RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: DataBaseEntity){
        ImageUtils.loadImageInView(binding.root.context, item.url, binding.favImage)
        binding.favImageTitle.text = item.title
        binding.date.text = item.date
    }
}