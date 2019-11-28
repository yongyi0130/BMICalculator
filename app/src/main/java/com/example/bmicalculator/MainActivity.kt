package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            btnCalculate.setOnClickListener(){
                try{
                    val weight:Double = txtWeight.text.toString().toDouble()
                    val height:Double = txtHeight.text.toString().toDouble()/100
                    var result:Double = calBMI(weight,height)

                    if (result < 18.5) {
                        imageView.setImageResource(R.drawable.under)
                        txtStatus.text = "BMI : " + "%.2f".format(result) + " Underweight"
                    } else if (result >= 18.5 && result <= 24.9) {
                        imageView.setImageResource(R.drawable.normal)
                        txtStatus.text = "BMI : " + "%.2f".format(result) + " Normal"
                    } else if (result > 25) {
                        imageView.setImageResource(R.drawable.over)
                        txtStatus.text = "BMI : " + "%.2f".format(result) + " Overweight"
                    }
                }catch(ex:java.lang.Exception){
                    Toast.makeText(applicationContext,"Please enter Weight and Height",Toast.LENGTH_LONG).show()
                    txtWeight.requestFocus()
                }
            }

            btnReset.setOnClickListener() {
                imageView.setImageResource(R.drawable.empty)
                txtStatus.text = ""
                txtHeight.text.clear()
                txtWeight.text.clear()
                txtWeight.requestFocus()
            }
    }

    private fun calBMI(weight:Double,height:Double):Double {
        var result: Double = 0.0

        result = weight / (height * height)

        return result
    }
}
