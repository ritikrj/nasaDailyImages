package com.rk.nasadailyimages.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.RadioGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rk.nasadailyimages.DI.AppComponent
import com.rk.nasadailyimages.Data.DataBaseEntity
import com.rk.nasadailyimages.R
import com.rk.nasadailyimages.databinding.FragmentImageOfTheDayBinding


class ImageOfDayFrag : Fragment() {
    lateinit var  appComponent: AppComponent

    lateinit var binding: FragmentImageOfTheDayBinding

   val viewModel by lazy { ViewModelProvider(this).get(ImageOfDayFragViewModel::class.java) }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageOfTheDayBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //viewModel.requestImageOfDay()
        viewModel._result.observe(viewLifecycleOwner
        ) {
            with(binding){
                ImageUtils.loadImageInView(requireContext(), it.url, imageView)
                title.text = it.title
                displayDate.text = it.date
                explanation.text = it.explanation
                getImageOfDayButton.setOnClickListener {
                    viewModel.requestImageOfDay(editTextDate.text.toString())
                }
                checkBox.setOnCheckedChangeListener(object :
                    CompoundButton.OnCheckedChangeListener {
                    override fun onCheckedChanged(p0: CompoundButton?, isChecked: Boolean) {
                        if(isChecked){
                          viewModel
                        }
                    }

                })
            }

        }

    }

}