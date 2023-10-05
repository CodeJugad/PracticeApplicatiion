package com.example.practiceapplicatiion

import android.annotation.SuppressLint
import android.app.Person
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.example.practiceapplicatiion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Create a ViewModel instance and set it to the binding
        val viewModel = MyViewModel()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this // For LiveData updates to work

//        binding.btn.setOnClickListener   -- if you want to apply

        // Now, your UI elements are automatically bound to the ViewModel's properties and methods.

        /*Data binding is a powerful library in Android that allows you to connect UI components
        in your layout XML files directly to data sources in your app's code, such as ViewModel
        objects. It simplifies the process of updating UI elements
         and handling user interactions by automatically syncing the UI with the underlying data.
        * */
    }
}