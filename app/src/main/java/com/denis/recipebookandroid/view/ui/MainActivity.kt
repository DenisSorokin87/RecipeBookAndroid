package com.denis.recipebookandroid.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import com.denis.recipebookandroid.R
import com.denis.recipebookandroid.databinding.ActivityMainBinding
import com.denis.recipebookandroid.view.ui.favorites.FavoriteFragment
import com.denis.recipebookandroid.view.ui.login.LoginFragment
import com.denis.recipebookandroid.view.ui.search.SearchFragment
import com.denis.recipebookandroid.view.ui.user_main.UserMainFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView
//    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)


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
        showBottomFragment(UserMainFragment::class.java)
    }

     fun showSearchFragment() {
        showBottomFragment(SearchFragment::class.java)
    }

     fun showFavoritesFragment() {
        showBottomFragment(FavoriteFragment::class.java)
    }

    fun showBottomFragment(fragmentClass: Class<out Fragment>) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.bottom_fragment_container, fragmentClass, null)
            .addToBackStack(null)
            .commit()
//        (supportFragmentManager.findFragmentByTag("Tag") as UserMainFragment)
    }
    fun showUpperFragment(fragmentClass: Class<out Fragment>) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.upper_fragment_container, UserMainFragment(), "Tag")
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .addToBackStack(null)
            .commit()
    }

    fun hideUpperFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .hide(fragment)
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .commit()
    }



}