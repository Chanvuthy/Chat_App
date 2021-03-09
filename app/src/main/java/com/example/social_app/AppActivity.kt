package com.example.social_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_app.*

class AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        val navController = findNavController(R.id.fragment7)
//        val appBarConfiguration = AppBarConfiguration(setOf(R.id.firstFragment,R.id.secondFragment,R.id.thirdFragment))
//        setupActionBarWithNavController(navController,appBarConfiguration)
//
//        bottomNavigationView.setupWithNavController(navController)
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        makeCurrentFragment(firstFragment)


//        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
//            when{
//                menuItem.itemId == R.id.firstFragment ->{
//                    setFragment(FirstFragment())
//                    return@setOnNavigationItemSelectedListener true
//                }
//                menuItem.itemId == R.id.secondFragment ->{
//                    setFragment(SecondFragment())
//                    return@setOnNavigationItemSelectedListener true
//                }
//                else ->{
//                    return@setOnNavigationItemSelectedListener false
//                }
//            }
//        }

        bottomNavigationView.setOnNavigationItemSelectedListener {item ->
            when(item.itemId){
                R.id.firstFragment -> setFragment(firstFragment)
                R.id.secondFragment -> makeCurrentFragment(secondFragment)
                R.id.thirdFragment -> makeCurrentFragment(thirdFragment)
            }
            true
        }
    }
    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_Fragment,fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }
    private fun setFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().also { fragmentTransaction ->
            fragmentTransaction.replace(R.id.fl_Fragment,fragment)
            fragmentTransaction.commit()
        }
    }
}