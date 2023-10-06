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
import androidx.lifecycle.ViewModelProvider
import com.example.practiceapplicatiion.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyActivity : AppCompatActivity() {
    private lateinit var viewModel: MyViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textview)
        val btn = findViewById<Button>(R.id.btn)

        val apiService = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        viewModel = ViewModelProvider(this, MyViewModelFactory(apiService))
            .get(MyViewModel::class.java)

        viewModel.postLiveData.observe(this) { post ->
            // Update UI with the fetched data
            textView.text = post?.title
        }

        btn.setOnClickListener {
            viewModel.fetchPost()
        }
    }
}
