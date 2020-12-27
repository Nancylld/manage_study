package com.example.manage_study

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.*
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
import com.example.manage_study.ui.notifications.Calculator
import com.example.manage_study.ui.notifications.MyException

import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_notifications.*

class MainActivity : AppCompatActivity() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var homeViewModel: HomeViewModel
    private var str = "0"
    private var processStr = "0"
    private var canDot = true
    // 最近用的是运算符,这一步实现运算符更改
    private var useOperational = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
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



//        btn_clear.setOnClickListener {
//            str = "0"
//            processStr = "0"
//            canDot = true
//            useOperational = false
//            et_input.setText(str)
//        }
//        // 数字
//        btn_0.setOnClickListener {
//            if(str != "0"){
//                str += "0"
//            }
//            useOperational = false
//            et_input.setText(str)
//        }
//        btn_1.setOnClickListener {
//            if(str == "0"){
//                str = "1"
//            } else {
//                str += "1"
//            }
//            useOperational = false
//            et_input.setText(str)
//        }
//        btn_2.setOnClickListener {
//            if(str == "0"){
//                str = "2"
//            } else {
//                str += "2"
//            }
//            useOperational = false
//            et_input.setText(str)
//        }
//        btn_3.setOnClickListener {
//            if(str == "0"){
//                str = "3"
//            } else {
//                str += "3"
//            }
//            useOperational = false
//            et_input.setText(str)
//        }
//        btn_4.setOnClickListener {
//            if(str == "0"){
//                str = "4"
//            } else {
//                str += "4"
//            }
//            useOperational = false
//            et_input.setText(str)
//        }
//        btn_5.setOnClickListener {
//            if(str == "0"){
//                str = "5"
//            } else {
//                str += "5"
//            }
//            useOperational = false
//            et_input.setText(str)
//        }
//        btn_6.setOnClickListener {
//            if(str == "0"){
//                str = "6"
//            } else {
//                str += "6"
//            }
//            useOperational = false
//            et_input.setText(str)
//        }
//        btn_7.setOnClickListener {
//            if(str == "0"){
//                str = "7"
//            } else {
//                str += "7"
//            }
//            useOperational = false
//            et_input.setText(str)
//        }
//        btn_8.setOnClickListener {
//            if(str == "0"){
//                str = "8"
//            } else {
//                str += "8"
//            }
//            useOperational = false
//            et_input.setText(str)
//        }
//        btn_9.setOnClickListener {
//            if(str == "0"){
//                str = "9"
//            } else {
//                str += "9"
//            }
//            useOperational = false
//            et_input.setText(str)
//        }
//
//        // 小数点
//        btn_dot.setOnClickListener {
//            if (canDot && !useOperational){
//                str += "."
//                canDot = false
//                et_input.setText(str)
//            }
//        }
//
//        // 四则运算
//        btn_plus.setOnClickListener {
//            // 判断最近有没有用过运算符
//            if (str.length >= 3 && (str[str.length - 2] == '+' || str[str.length - 2] == '-' ||
//                        str[str.length - 2] == '*' || str[str.length - 2] == '/')){
//                str = str.substring(0, str.length - 3)
//                useOperational = true
//            }
//            if (str.last() == '.')
//                str = str.substring(0, str.length - 1)
//            str += " + "
//            canDot = true
//            et_input.setText(str)
//        }
//        btn_minus.setOnClickListener {
//            // 判断最近有没有用过运算符
//            if (str.length >= 3 && (str[str.length - 2] == '+' || str[str.length - 2] == '-' ||
//                        str[str.length - 2] == '*' || str[str.length - 2] == '/')){
//                str = str.substring(0, str.length - 3)
//                useOperational = true
//            }
//            if (str.last() == '.')
//                str = str.substring(0, str.length - 1)
//            str += " - "
//            canDot = true
//            et_input.setText(str)
//        }
//        btn_multipy.setOnClickListener {
//            // 判断最近有没有用过运算符
//            if (str.length >= 3 && (str[str.length - 2] == '+' || str[str.length - 2] == '-' ||
//                        str[str.length - 2] == '*' || str[str.length - 2] == '/')){
//                str = str.substring(0, str.length - 3)
//                useOperational = true
//            }
//            if (str.last() == '.')
//                str = str.substring(0, str.length - 1)
//            str += " * "
//            canDot = true
//            et_input.setText(str)
//        }
//        btn_divide.setOnClickListener {
//            // 判断最近有没有用过运算符
//            if (str.length >= 3 && (str[str.length - 2] == '+' || str[str.length - 2] == '-' ||
//                        str[str.length - 2] == '*' || str[str.length - 2] == '/')){
//                str = str.substring(0, str.length - 3)
//                useOperational = true
//            }
//            if (str.last() == '.')
//                str = str.substring(0, str.length - 1)
//            str += " / "
//            canDot = true
//            et_input.setText(str)
//        }
//
//        btn_del.setOnClickListener {
//            // 空格也要取消掉
//            if (str.last() == ' '){
//                str = str.substring(0, str.length - 1)
//            }
//            str = if (str.length >= 2)
//                str.substring(0, str.length - 1)
//            else
//                "0"
//            // 空格也要取消掉
//            if (str.last() == ' ' && str[str.length - 2] != '+'  && str[str.length - 2] != '-'
//                && str[str.length - 2] != '*' && str[str.length - 2] != '/'){
//                str = str.substring(0, str.length - 1)
//            }
//
//            if (str.length == 1) {
//                if (str == "-"){
//                    str = "0"
//                }
//                canDot = true
//                useOperational = false
//            }
//            et_input.setText(str)
//        }
//
//        // 结果
//        btn_result.setOnClickListener {
//            // 判断最近有没有用过运算符
//            if (useOperational){
//                str = str.substring(0, str.length - 3)
//                useOperational = false
//            }
//            if (str.last() == '.')
//                str = str.substring(0, str.length - 1)
//
//            try{
//                var result = Calculator.cal("$str + 0")
//                processStr = str
//                str = result
//                et_input.setText(str)
//                canDot = true
//                useOperational = false
//            } catch (e: MyException) {
//
//            }
//        }












    }
}