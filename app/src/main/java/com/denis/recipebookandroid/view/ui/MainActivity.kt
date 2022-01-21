package com.denis.recipebookandroid.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.denis.recipebookandroid.R
import com.denis.recipebookandroid.view.ui.favorites.FavoriteFragment
import com.denis.recipebookandroid.view.ui.search.SearchFragment
import com.denis.recipebookandroid.view.ui.user_main.UserMainFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottomNavigationView)

    }

    private val navClickListener = NavigationBarView.OnItemSelectedListener { item: MenuItem ->
        when (item.itemId) {
            R.id.Nav_Home -> showMainFragment()
            R.id.Nav_Fav -> showFavoritesFragment()
            R.id.Nav_User -> showSearchFragment()
        }
        true
    }

     fun showMainFragment() {
        showFragment(UserMainFragment::class.java)
    }

     fun showSearchFragment() {
        showFragment(SearchFragment::class.java)
    }

     fun showFavoritesFragment() {
        showFragment(FavoriteFragment::class.java)
    }

    fun showFragment(fragmentClass: Class<out Fragment>) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, fragmentClass, null)
            .addToBackStack(null)
            .commit()
    }

}