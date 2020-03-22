package com.check.coupon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import io.paperdb.Paper


class MainActivity : AppCompatActivity() {

    private lateinit var navHost: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        // start the Paper database for the local cache
        Paper.init(this)
        navHost = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
    }

    override fun onSupportNavigateUp(): Boolean {
        return navHost.navController.navigateUp() || super.onSupportNavigateUp()
    }

    // disable back navigation
    override fun onBackPressed() {
        val navigationController = navHost.findNavController()
        if ((navigationController.currentDestination?.id == R.id.offerFragment)) {
            super.onBackPressed()
        }
    }
}