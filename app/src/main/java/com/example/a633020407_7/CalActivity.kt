package com.example.a633020407_7

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class CalActivity : AppCompatActivity()  {
    var btnCal:Button? = null
    var btnMenu:Button? = null
    var txtDiscount:TextView? = null
    var txtSum:TextView? = null
    var editTotal:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cal_main)
        init()
        btnMenu!!.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java);
            startActivity(intent)
        }
        btnCal!!.setOnClickListener {
            var totalStr = editTotal!!.getText().toString()

            if (totalStr.isEmpty()){
                Toast.makeText(this,"Input your Number!",Toast.LENGTH_LONG).show()
                editTotal!!.requestFocus()
            }
            else if (totalStr != null) {
                var total = 0.0
                total = totalStr.toDouble()
                var disc = 0.0
                var mindis = 0.0
                var sum = 0.0
                if (total <= 0){
                    editTotal!!.setText("")
                    txtDiscount!!.setText("")
                    txtSum!!.setText("")
                }else{
                    if (total >= 3000 && total <=4999){
                        disc = 50.0
                        sum = total-50
                        txtDiscount!!.setText(disc.toString()+" บาท")
                    }else if(total >= 5000 && total <=10000){
                        disc = 7.0

                        sum = total - (total*(disc/100))
                        var totalDis = disc*100;
                        totalDis.toInt()
                        txtDiscount!!.setText(disc.toString()+" %")
                    }else if(total >= 10001 && total <=15000){
                        disc = 7*2.0
                        sum = total - (total*(disc/100))
                        var totalDis = disc*100;
                        txtDiscount!!.setText(disc.toString()+" %")
                    }else if(total >= 15000){
                        disc = (7*7)*2.0
                        sum = total - (total*(disc/100))
                        var totalDis = disc*100;
                        txtDiscount!!.setText(disc.toString()+" %")
                    }
            }



                txtSum!!.setText(sum.toString()+"บาท")
            }
        }
    }
    fun init(){
        btnCal = findViewById(R.id.btnRealCal) as Button
        btnMenu = findViewById(R.id.btnBackCal) as Button
        txtDiscount = findViewById(R.id.txtDiscount) as TextView
        txtSum = findViewById(R.id.txtSum) as TextView
        editTotal = findViewById(R.id.editTotal) as EditText
    }
}