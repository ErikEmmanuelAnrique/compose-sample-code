package com.example.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.example.myapplication.databinding.MainActivityBinding
import com.example.myapplication.model.room.PostDatabase
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : AppCompatActivity() {
    lateinit var binding: MainActivityBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = (supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment).navController
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.profileFragment,
                R.id.itemListFragment,
                R.id.newItemFragment
            )
        )
        navController.apply {
            binding.bottomNavigationView.setupWithNavController(this)
            setupActionBarWithNavController(this, appBarConfiguration)
            enableOnBackPressed(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return super.onSupportNavigateUp()
    }

    companion object {
        lateinit var database: PostDatabase
    }
}