package com.example.manage_study.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.manage_study.MainActivity
import com.example.manage_study.MyApplication
import com.example.manage_study.R
import com.example.manage_study.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
//        dashboardViewModel =
//            ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
//        dashboardViewModel.cities.observe(viewLifecycleOwner, Observer {
//            val cities: List<City> = it
//            val listView: ListView = root.findViewById(R.id.listview)
//            val adapter = ArrayAdapter<City>(this, android.R.layout.simple_list_item_1,cities)
//            listView.adapter = adapter
//            listView.setOnItemClickListener { _, _, position, _ ->
//                val cityCode = cities[position].city_code
//                val intent = Intent(this, MainActivity2::class.java)
//                intent.putExtra("city_code", cityCode)
//                startActivity(intent)
//            }
//        })


        return root
    }


}