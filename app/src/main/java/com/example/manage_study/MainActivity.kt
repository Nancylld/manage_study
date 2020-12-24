package com.example.manage_study

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.manage_study.ui.dashboard.City
import com.example.manage_study.ui.dashboard.DashboardViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import com.example.manage_study.ui.home.HomeViewModel
import com.example.manage_study.ui.notifications.SqLiteHelper
import com.example.manage_study.ui.notifications.TABLE_NAME
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_notifications.*

class MainActivity : AppCompatActivity() {

    private lateinit var dashboardViewModel: DashboardViewModel
    lateinit var db: SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        dashboardViewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory(application)
            ).get(DashboardViewModel::class.java)

        dashboardViewModel.cities.observe(this, Observer {
            val cities: List<City> = it
            val adapter = ArrayAdapter<City>(this, android.R.layout.simple_list_item_1,cities)
            listview.adapter=adapter
            listview.setOnItemClickListener { _, _, position, _ ->
                val cityCode = cities[position].city_code
                val intent = Intent(this,MainActivity2::class.java)
                intent.putExtra("city_code",cityCode)
                startActivity(intent)
            }
        })












    }
}