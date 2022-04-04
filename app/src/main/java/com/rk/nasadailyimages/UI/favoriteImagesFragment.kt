package com.rk.nasadailyimages.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rk.nasadailyimages.Data.DataBaseEntity
import com.rk.nasadailyimages.R
import com.rk.nasadailyimages.databinding.FragmentFavouriteImagesBinding


class ImageOfTheDayFragment : Fragment() {

    lateinit var binding: FragmentFavouriteImagesBinding
    val adapter: FavItemsAdapter by lazy { FavItemsAdapter(emptyList()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    val viewModel by lazy { ViewModelProvider(this).get(FavoriteImagesViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteImagesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadFavImageList()

        binding.favouriteRecyclerView.adapter = adapter
        binding.favouriteRecyclerView.layoutManager = LinearLayoutManager(context)
        viewModel._result.observe(viewLifecycleOwner,object :Observer<List<DataBaseEntity>>{
            override fun onChanged(t: List<DataBaseEntity>?) {
                adapter.favList = t!!
                adapter.notifyDataSetChanged()

            }

        })
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ImageOfTheDayFragment()}
}