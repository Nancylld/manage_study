package com.example.manage_study.ui.notifications

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.manage_study.MyApplication
import com.example.manage_study.R
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel




    lateinit var db: SQLiteDatabase

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
//        val add: Button= root.findViewById(R.id.add)
//        val todoname: EditText=root.findViewById(R.id.todoname)
//
//        val openSqLiteHelper = SqLiteHelper(requireActivity(),1)
//        db = openSqLiteHelper.writableDatabase
//        add.setOnClickListener {
//            val name = todoname.text.toString()
//            if(name != null){
//                val contentValues = ContentValues().apply {
//                    put("name",name)
//                }
//                db.insert(TABLE_NAME,null,contentValues)
//            }else {
//                val contentValues = ContentValues().apply {
//                    put("name","Nancylld")
//                }
//                db.insert(TABLE_NAME,null,contentValues)
//            }
//
//        }



        return root
    }

}