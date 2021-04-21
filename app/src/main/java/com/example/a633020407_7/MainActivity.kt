package com.example.a633020407_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    var btnExit: Button? = null
    var btnCal: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        btnCal!!.setOnClickListener {
            var intent = Intent(this,CalActivity::class.java)
            startActivity(intent)
        }
        btnExit!!.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)

            dialogBuilder.setMessage("Close this app?")
                .setCancelable(false)

                .setPositiveButton("Yes") { _, _ -> finish() }

                .setNegativeButton("No") { dialog, _ -> dialog.cancel() }

            val alert = dialogBuilder.create()
            alert.setTitle("633020407-7")
            alert.show()
        }
    }
    fun init(){
        btnCal = findViewById(R.id.btnCal) as Button
        btnExit = findViewById(R.id.btnExit) as Button
    }
}