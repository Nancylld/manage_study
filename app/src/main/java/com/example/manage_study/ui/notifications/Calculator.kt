package com.example.manage_study.ui.notifications
import java.lang.Math.pow
class Calculator {
    companion object {
        // 计算栈
        fun cal(s: String): String {
            var str = s
            var n1: Double
            var n2: Double
            var tn = 0.0
            var lastPriority = 0
            var priority: Int
            var op: Char
            var numS = ArrayList<Double>()
            var opS = ArrayList<Char>()
            var result: Double = 0.0
            var tempNumStr: String = ""
            var i: Int = 0

            try{
                // 左闭右开
                while (i < s.length) {
                    // 数字
                    if (str[i] in '0'..'9') {
                        tempNumStr = ""
                        while (i < s.length && (str[i] in '0'..'9' || str[i] == '.')) {
                            tempNumStr += str[i]
                            i++
                        }
                        tn = string2float(tempNumStr)
                    } else if (str[i] == ' ') {
                        i++
                        continue
                    } else {
                        numS.add(tn)
                        priority = getPriority(str[i])
                        if (priority <= lastPriority) { // 优先级一样或者低于上一个操作符
                            while (opS.size != 0) {
                                op = opS.last()
                                lastPriority = getPriority(op)

                                if (lastPriority >= priority) {
                                    opS.removeAt(opS.size - 1)
                                    n2 = numS.last()
                                    numS.removeAt(numS.size - 1)
                                    n1 = numS.last()
                                    numS.removeAt(numS.size - 1)
                                    n1 = calOne(n1, op, n2)
                                    numS.add(n1)
                                } else {
                                    break
                                }
                            }
                            opS.add(str[i])
                        } else { // 优先级高于上一个
                            opS.add(str[i])
                        }
                        tn = 0.0
                        lastPriority = priority
                    }
                    i++
                }
                //把最后一个操作数也加上
                numS.add(tn);

                while (opS.size != 0){
                    op = opS.last()
                    opS.removeAt(opS.size - 1)
                    n2 = numS.last()
                    numS.removeAt(numS.size - 1)
                    n1 = numS.last()
                    numS.removeAt(numS.size - 1)
                    result = calOne(n1, op, n2)
                    numS.add(result)
                }}catch(e: MyException){
                throw MyException("分母不能为零!!! from cal")
            }
            return beautify(result.toString())
        }

        private fun getPriority(op: Char): Int {
            // -1 代表没有找到对应运算符
            var priority: Int = -1
            if (op == '+' || op == '-')
                priority = 1
            else if (op == '*' || op == '/')
                priority = 2
            else if (op == '^')
                priority = 3
            return priority
        }

        private fun calOne(n1: Double, op: Char, n2: Double): Double {
            var result: Double = 0.0
            if(op == '+'){
                result = n1 + n2
            } else if (op == '-') {
                result = n1 - n2
            } else if (op == '*') {
                result = n1 * n2
            } else if (op == '/') {
                if (n2 > -0.000001 && n2 < 0.000001)
                    throw MyException("分母为零!!! from cal_one")
                result = n1 / n2
            }
            return result
        }

        private fun beautify(s: String): String{
            // 去掉小数点后多于的 0
            var str = s
            var flag: Boolean = true  // 是否可以计算小数点后0的个数
            var zeroNum: Int = 0
            for (i in str.length - 1 downTo 0){
                if (str[i] == '.') {
                    str = str.substring(0, str.length - zeroNum)
                    break
                }
                if (str[i] >= '1' && str[i] <= '9'){
                    flag = false
                }
                if (str[i] == '0' && flag) {
                    zeroNum++
                }
            }
            // 去除输入为 1.0这样子的数的小数点
            if (str.last() == '.')
                str = str.substring(0, str.length - 1)
            return str
        }

        private fun string2float(s: String): Double
        {
            var n: Double = 0.0
            var isXiaoShu: Boolean = false // 判断当前的数字是不是小数部分
            var xiaoShuLength: Int = 0;  // 记录小数部分的长度
            for (i in 0 until s.length){
                if (s[i] in '0'..'9'){
                    n = n * 10 + (s[i] - '0').toDouble()
                    if (isXiaoShu)
                        xiaoShuLength++
                }
                else if (s[i] == '.'){
                    isXiaoShu = true //开始进入小数部分
                }
            }
            return n * 1.0 / pow(10.0, xiaoShuLength.toDouble())
        }
    }
}

public class MyException(override val message: String) : Throwable(){

}