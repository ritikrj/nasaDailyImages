package com.rk.nasadailyimages.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.rk.nasadailyimages.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val tr = supportFragmentManager.beginTransaction()
        supportFragmentManager.findFragmentById(R.id.container)?.let { tr.remove(it) }
        tr.add(R.id.container,ImageOfDayFrag())
        tr.commit()

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
        tr.add(R.id.container,ImageOfTheDayFragment.newInstance())
        tr.commit()
    }

    fun showImageOfDayFragment(){
        val tr = supportFragmentManager.beginTransaction()
        supportFragmentManager.findFragmentById(R.id.container)?.let { tr.remove(it) }
        tr.add(R.id.container,ImageOfDayFrag())
        tr.commit()
    }


}