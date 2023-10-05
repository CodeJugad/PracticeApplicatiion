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

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)

        /*The run function takes an object as its receiver and
        executes a block of code on that object. It returns the result
         of the last expression in the block. This is useful when you want
         to perform a series of operations on an object.
        *  */
        textView.run {
            text = "Hello, Kotlin"
            textSize = 20.0f
            setTextColor(Color.BLACK)
        }

// textView now has properties set as specified in the run block

        /*   The apply function is similar to run, but it returns the object
             itself, allowing you to chain multiple operations on the same object.
             It's particularly useful when
            you want to configure an object and return it in a single expression.
          */
        val button = Button(this).apply {
            text = "Click me"
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            setOnClickListener {
                // Handle button click
            }
        }

// button is configured and ready to be added to a layout

        val container = findViewById<ConstraintLayout>(R.id.container)
        container.addView(button)

        /*The let function is used to perform an operation on a
        non-null object and then return the result of that operation.
        It is often used for data transformation or validation.
         If the object is null, the block is not executed.
        * */

        val result = textView?.let { nonNullValue ->
            // Perform operations on nonNullValue
            "Result: $nonNullValue"
        } ?: "Default Value" // Default value in case someNullableValue is null

        /*The also function is used when you want to perform some additional actions
        on an object and return the same object. It is often used for side effects,
         such as logging or debugging, without changing the object itself.
        * */
        val list = mutableListOf(1, 2, 3)
        list.also {
            println("List before modification: $it")
        }.add(4)
        println("List after modification: $list")

        /*The with function is not an extension function like the others, but it
         allows you to work with an object within a specific scope without having
         to repeat the object's name. It can be useful for
        configuring or operating on an object without the need for the dot notation.
        * */
//        val person = Person()
//        with(person) {
//            name = "John"
//            age = 30
//            // Other properties and operations on the 'person' object
//        }


    }
}