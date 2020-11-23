package com.niroshan.restapi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
       var button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
          val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
}