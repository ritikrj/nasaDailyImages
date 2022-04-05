package com.rk.nasadailyimages.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.rk.nasadailyimages.Common.Constants
import com.rk.nasadailyimages.R
import com.rk.nasadailyimages.UI.screens.ImageOfDayScreen.ImageOfDayFrag

class HomeActivity : AppCompatActivity() {
    var currFragment = favouriteImagesFragment::class.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
         currFragment = savedInstanceState?.getString(Constants.CURR_FRAG_KEY)
       if(currFragment == favouriteImagesFragment::class.simpleName){
           showFavFragment()
       }else{
           showImageOfDayFragment()
       }
//        val tr = supportFragmentManager.beginTransaction()
//        supportFragmentManager.findFragmentById(R.id.container)?.let { tr.remove(it) }
//        tr.add(R.id.container, ImageOfDayFrag())
//        tr.commit()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.ImageOfDayFrag -> showImageOfDayFragment()
            R.id.favImageFrag -> showFavFragment()
        }
         return super.onOptionsItemSelected(item)

    }

    fun showFavFragment(){
        val tr = supportFragmentManager.beginTransaction()
        supportFragmentManager.findFragmentById(R.id.container)?.let { tr.remove(it) }
        tr.add(R.id.container,favouriteImagesFragment.newInstance())
        tr.commit()
        currFragment = favouriteImagesFragment::class.simpleName
    }

    fun showImageOfDayFragment(){
        val tr = supportFragmentManager.beginTransaction()
        supportFragmentManager.findFragmentById(R.id.container)?.let { tr.remove(it) }
        tr.add(R.id.container, ImageOfDayFrag())
        tr.commit()
        currFragment = ImageOfDayFrag::class.simpleName
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(Constants.CURR_FRAG_KEY, currFragment)
    }


}