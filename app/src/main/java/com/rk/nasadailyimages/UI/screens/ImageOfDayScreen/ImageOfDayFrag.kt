package com.rk.nasadailyimages.UI.screens.ImageOfDayScreen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.CompoundButton
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rk.nasadailyimages.DI.AppComponent
import com.rk.nasadailyimages.UI.ImageUtils
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
                checkBox.isChecked = it.isFavourite
                checkBox.setOnCheckedChangeListener(object :
                    CompoundButton.OnCheckedChangeListener {
                    override fun onCheckedChanged(p0: CompoundButton?, isChecked: Boolean) {
                       viewModel.updateImageOfDayItem(isChecked)
                        val view: View = binding.editTextDate
                        if (view != null) {
                            val im: InputMethodManager? =
                                context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
                            im?.hideSoftInputFromWindow(view.windowToken, 0)
                        }
                    }

                })
            }
            viewModel.showToast.observe(viewLifecycleOwner,{
                if(it) Toast.makeText(context, " Please enter a valid date in YYYY-MM-DD format",Toast.LENGTH_SHORT).show()
                viewModel.resetToastFlag()

            })

        }



    }

}