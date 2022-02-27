package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var newOp = true
    var oldNumber = ""
    var operator = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        setContentView(R.layout.activity_main)

    }

    fun numberEvent(view: View) {
        if (newOp) {
            textView2.setText("")
        }
        newOp = false
        var buttonClick = textView2.text.toString()
        var isComma = buttonClick.indexOf('.')
        var buttonSelect = view as Button
        when (buttonSelect.id) {
            button1.id-> {buttonClick += "1"}
            button2.id-> {buttonClick += "2"}
            button3.id-> {buttonClick += "3"}
            button4.id-> {buttonClick += "4"}
            button5.id-> {buttonClick += "5"}
            button6.id-> {buttonClick += "6"}
            button7.id-> {buttonClick += "7"}
            button8.id-> {buttonClick += "8"}
            button9.id-> {buttonClick += "9"}
            button0.id-> {buttonClick += "0"}
            buttonComma.id-> {
                if (buttonClick.isEmpty()) {
                    buttonClick += "0."
                }
                else {
                    if (isComma == -1) {
                        buttonClick += "."
                    }
                }
            }
        }
        textView2.setText(buttonClick)
    }

    fun operatorEvent(view: View) {
        newOp = true
        oldNumber = textView2.text.toString()
        var buttonSelect = view as Button
        when (buttonSelect.id) {
            buttonMulti.id-> {operator = "*"}
            buttonPlus.id-> {operator = "+"}
            buttonMinus.id->{operator = "-"}
            buttonDivide.id -> {operator = "/"}
        }
    }

    fun equalsEvent(view: View) {
        var newNumber = textView2.text.toString()
        var result = 0.0
        var flag = 0
        when (operator) {
            "+"-> {result = oldNumber.toDouble() + newNumber.toDouble()}
            "*"-> {result = oldNumber.toDouble() * newNumber.toDouble()}
            "-"-> {result = oldNumber.toDouble() - newNumber.toDouble()}
            "/"-> {
                if (newNumber == "0") {
                    textView2.setText("ERROR")
                    flag = 1
                }
                else {
                    result = oldNumber.toDouble() / newNumber.toDouble()
                }
            }
        }
        if (flag == 0) {
            var longResult = result.toLong()
            if (result == longResult.toDouble()) {
                textView2.setText(longResult.toString())
                newOp = true
            }
            else {
                textView2.setText(result.toString())
                newOp = true
            }
        }
    }

    fun acEvent(view: View) {
        textView2.setText("0")
        newOp = true
    }

    fun percentEvent(view: View) {
        var number = textView2.text.toString().toDouble()/100
        textView2.setText(number.toString())
        newOp = true
    }

    fun plusMinus(view: View) {
        if (textView2.text[0] == '-') {
            textView2.setText(textView2.text.substring(1, textView2.text.length))
        }
        else {
            var txt = textView2.text
            textView2.setText("-$txt")
        }
        newOp = false
    }


}