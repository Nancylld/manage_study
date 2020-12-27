package com.example.manage_study.ui.notifications


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.manage_study.MyApplication
import com.example.manage_study.R
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private var str = "0"
    private var processStr = "0"
    private var canDot = true
    // 最近用的是运算符,这一步实现运算符更改
    private var useOperational = false
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {



        // 能不能用小数点

        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val btn_0:Button = root.findViewById(R.id.btn_0)
        val btn_1:Button = root.findViewById(R.id.btn_1)
        val btn_2:Button = root.findViewById(R.id.btn_2)
        val btn_3:Button = root.findViewById(R.id.btn_3)
        val btn_4:Button = root.findViewById(R.id.btn_4)
        val btn_5:Button = root.findViewById(R.id.btn_5)
        val btn_6:Button = root.findViewById(R.id.btn_6)
        val btn_7:Button = root.findViewById(R.id.btn_7)
        val btn_8:Button = root.findViewById(R.id.btn_8)
        val btn_9:Button = root.findViewById(R.id.btn_9)
        val et_input:EditText = root.findViewById(R.id.et_input)
        val btn_plus:Button = root.findViewById(R.id.btn_plus)
        val btn_minus:Button = root.findViewById(R.id.btn_minus)
        val btn_multipy:Button = root.findViewById(R.id.btn_multipy)
        val btn_divide:Button = root.findViewById(R.id.btn_divide)
        val btn_result:Button = root.findViewById(R.id.btn_result)
        val btn_clear:Button = root.findViewById(R.id.btn_clear)
        val btn_del:Button = root.findViewById(R.id.btn_del)
        val btn_dot:Button = root.findViewById(R.id.btn_dot)
        val btn_process:Button=root.findViewById(R.id.btn_process)


        btn_clear.setOnClickListener {
            str = "0"
            processStr = "0"
            canDot = true
            useOperational = false
            et_input.setText(str)
        }
        // 数字
        btn_0.setOnClickListener {
            if(str != "0"){
                str += "0"
            }
            useOperational = false
            et_input.setText(str)
        }
        btn_1.setOnClickListener {
            if(str == "0"){
                str = "1"
            } else {
                str += "1"
            }
            useOperational = false
            et_input.setText(str)
        }
        btn_2.setOnClickListener {
            if(str == "0"){
                str = "2"
            } else {
                str += "2"
            }
            useOperational = false
            et_input.setText(str)
        }
        btn_3.setOnClickListener {
            if(str == "0"){
                str = "3"
            } else {
                str += "3"
            }
            useOperational = false
            et_input.setText(str)
        }
        btn_4.setOnClickListener {
            if(str == "0"){
                str = "4"
            } else {
                str += "4"
            }
            useOperational = false
            et_input.setText(str)
        }
        btn_5.setOnClickListener {
            if(str == "0"){
                str = "5"
            } else {
                str += "5"
            }
            useOperational = false
            et_input.setText(str)
        }
        btn_6.setOnClickListener {
            if(str == "0"){
                str = "6"
            } else {
                str += "6"
            }
            useOperational = false
            et_input.setText(str)
        }
        btn_7.setOnClickListener {
            if(str == "0"){
                str = "7"
            } else {
                str += "7"
            }
            useOperational = false
            et_input.setText(str)
        }
        btn_8.setOnClickListener {
            if(str == "0"){
                str = "8"
            } else {
                str += "8"
            }
            useOperational = false
            et_input.setText(str)
        }
        btn_9.setOnClickListener {
            if(str == "0"){
                str = "9"
            } else {
                str += "9"
            }
            useOperational = false
            et_input.setText(str)
        }

        // 小数点
        btn_dot.setOnClickListener {
            if (canDot && !useOperational){
                str += "."
                canDot = false
                et_input.setText(str)
            }
        }

        // 四则运算
        btn_plus.setOnClickListener {
            // 判断最近有没有用过运算符
            if (str.length >= 3 && (str[str.length - 2] == '+' || str[str.length - 2] == '-' ||
                        str[str.length - 2] == '*' || str[str.length - 2] == '/')){
                str = str.substring(0, str.length - 3)
                useOperational = true
            }
            if (str.last() == '.')
                str = str.substring(0, str.length - 1)
            str += " + "
            canDot = true
            et_input.setText(str)
        }
        btn_minus.setOnClickListener {
            // 判断最近有没有用过运算符
            if (str.length >= 3 && (str[str.length - 2] == '+' || str[str.length - 2] == '-' ||
                        str[str.length - 2] == '*' || str[str.length - 2] == '/')){
                str = str.substring(0, str.length - 3)
                useOperational = true
            }
            if (str.last() == '.')
                str = str.substring(0, str.length - 1)
            str += " - "
            canDot = true
            et_input.setText(str)
        }
        btn_multipy.setOnClickListener {
            // 判断最近有没有用过运算符
            if (str.length >= 3 && (str[str.length - 2] == '+' || str[str.length - 2] == '-' ||
                        str[str.length - 2] == '*' || str[str.length - 2] == '/')){
                str = str.substring(0, str.length - 3)
                useOperational = true
            }
            if (str.last() == '.')
                str = str.substring(0, str.length - 1)
            str += " * "
            canDot = true
            et_input.setText(str)
        }
        btn_divide.setOnClickListener {
            // 判断最近有没有用过运算符
            if (str.length >= 3 && (str[str.length - 2] == '+' || str[str.length - 2] == '-' ||
                        str[str.length - 2] == '*' || str[str.length - 2] == '/')){
                str = str.substring(0, str.length - 3)
                useOperational = true
            }
            if (str.last() == '.')
                str = str.substring(0, str.length - 1)
            str += " / "
            canDot = true
            et_input.setText(str)
        }

        btn_del.setOnClickListener {
            // 空格也要取消掉
            if (str.last() == ' '){
                str = str.substring(0, str.length - 1)
            }
            str = if (str.length >= 2)
                str.substring(0, str.length - 1)
            else
                "0"
            // 空格也要取消掉
            if (str.last() == ' ' && str[str.length - 2] != '+'  && str[str.length - 2] != '-'
                && str[str.length - 2] != '*' && str[str.length - 2] != '/'){
                str = str.substring(0, str.length - 1)
            }

            if (str.length == 1) {
                if (str == "-"){
                    str = "0"
                }
                canDot = true
                useOperational = false
            }
            et_input.setText(str)
        }

        // 结果
        btn_result.setOnClickListener {
            // 判断最近有没有用过运算符
            if (useOperational){
                str = str.substring(0, str.length - 3)
                useOperational = false
            }
            if (str.last() == '.')
                str = str.substring(0, str.length - 1)

            try{
                var result = Calculator.cal("$str + 0")
                processStr = str
                str = result
                et_input.setText(str)
                canDot = true
                useOperational = false
            } catch (e: MyException) {

            }
        }

        btn_process.setOnClickListener {
            if (processStr != "0") {
                str = processStr
                processStr = "0"
                et_input.setText(str)
            }
        }








        return root
    }

}