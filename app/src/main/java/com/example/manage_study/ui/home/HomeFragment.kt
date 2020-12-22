package com.example.manage_study.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.manage_study.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlin.math.min

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.textView)
        val start:Button = root.findViewById(R.id.start)
        val stop:Button = root.findViewById(R.id.stop)
        val restart:Button = root.findViewById(R.id.restart)

        homeViewModel.seconds.observe(viewLifecycleOwner, Observer {
            val hours = it/3600
            val minutes = (it%3600)/60
            val secs = it % 60
            textView.text= String.format("%02d:%02d:%02d",hours, minutes,secs)
        })
        start.setOnClickListener { homeViewModel.start() }
        stop.setOnClickListener { homeViewModel.stop() }
        restart.setOnClickListener { homeViewModel.restart() }
        return root
    }
}