package com.rk.nasadailyimages.UI

import android.view.View
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.rk.nasadailyimages.Data.DataBaseEntity
import com.rk.nasadailyimages.databinding.FavItemBinding

class FavViewHolder(val binding:  FavItemBinding):RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: DataBaseEntity){
        ImageUtils.loadImageInView(binding.root.context, item.url, binding.favImage)
    }
}