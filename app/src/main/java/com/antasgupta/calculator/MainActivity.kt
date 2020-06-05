package com.antasgupta.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btadd: Button
    lateinit var btsubtract: Button
    lateinit var btmultiply: Button
    lateinit var btdivide: Button

    lateinit var etFirstNum: EditText
    lateinit var etSecondNum: EditText

    lateinit var txtResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btadd = findViewById(R.id.btadd)
        btsubtract = findViewById(R.id.btsubtract)
        btmultiply = findViewById(R.id.btmultiply)
        btdivide = findViewById(R.id.btdivide)


        etFirstNum = findViewById(R.id.etFirstNum)
        etSecondNum = findViewById(R.id.etSecondNum)

        txtResult = findViewById(R.id.txtResult)

        // Set the listener to the buttons

        btadd.setOnClickListener(this)
        btsubtract.setOnClickListener(this)
        btmultiply.setOnClickListener(this)
        btdivide.setOnClickListener(this)


    }

    override fun onClick(v: View?) {

        if (TextUtils.isEmpty(etFirstNum.text.toString()) && TextUtils.isEmpty(etSecondNum.text.toString())) {

            Toast.makeText(this, "Please Fill The Values", Toast.LENGTH_SHORT).show()
        }

        else if (TextUtils.isEmpty(etFirstNum.text.toString())) {

            Toast.makeText(this, "Please Fill The First Value", Toast.LENGTH_SHORT).show()
        }

        else if (TextUtils.isEmpty(etSecondNum.text.toString())) {

            Toast.makeText(this, "Please Fill The Second Value", Toast.LENGTH_SHORT).show()
        }


        else {

            val num1 = etFirstNum.text.toString().trim().toBigDecimal()
            val num2 = etSecondNum.text.toString().trim().toBigDecimal()

            if (v != null) {
                when (v.id) {
                    R.id.btadd -> {
                        val ResultA = num1 + num2
                        txtResult.text = ResultA.toString()

                    }

                    R.id.btsubtract -> {
                        val ResultS = num1 - num2
                        txtResult.text = ResultS.toString()

                    }

                    R.id.btmultiply -> {
                        val ResultM = num1 * num2
                        txtResult.text = ResultM.toString()

                    }

                    R.id.btdivide -> {
                        if(num2.compareTo(BigDecimal.ZERO)  == 0){
                            etSecondNum.error = "Invalid Input"
                        }
                        else{
                            val ResultD = num1.divide(num2,8,RoundingMode.HALF_UP)
                            txtResult.text = ResultD.toString()
                        }
                    }





                }
            }
        }
    }

}