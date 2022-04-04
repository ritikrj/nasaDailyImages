package com.rk.nasadailyimages.UI.screens.FavImagesScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rk.nasadailyimages.Data.DataBaseEntity
import com.rk.nasadailyimages.databinding.FavItemBinding

class FavItemsAdapter(var favList: List<DataBaseEntity>):RecyclerView.Adapter<FavViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
      return FavViewHolder(FavItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
       holder.onBind(favList.get(position))
    }

    override fun getItemCount(): Int {
       return  favList.size
    }


}