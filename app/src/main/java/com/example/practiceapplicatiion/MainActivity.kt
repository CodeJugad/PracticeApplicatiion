package com.example.practiceapplicatiion

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomAppBar = findViewById<BottomAppBar>(R.id.bottom_app_bar)
        setSupportActionBar(bottomAppBar)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { // Handle FAB click event
            Toast.makeText(this@MainActivity, "FAB Clicked", Toast.LENGTH_SHORT).show()
        }

    }
}



