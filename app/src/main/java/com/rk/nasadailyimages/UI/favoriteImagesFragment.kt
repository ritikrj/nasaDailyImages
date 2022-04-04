package com.rk.nasadailyimages.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rk.nasadailyimages.R
import com.rk.nasadailyimages.databinding.FragmentFavouriteImagesBinding


class ImageOfTheDayFragment : Fragment() {

    lateinit var binding: FragmentFavouriteImagesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteImagesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.favouriteRecyclerView.adapter = FavItemsAdapter(emptyList())
        binding.favouriteRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ImageOfTheDayFragment()}
}