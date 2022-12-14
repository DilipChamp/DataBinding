package com.dileep.databinding

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.dileep.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.submitButton.setOnClickListener()
        {
            displayMessage()
        }
        // progress bar example
        binding.startProgress.setOnClickListener()
        {
            progressBarUpdate()
        }
        // student data
        binding.student= getStudent()
    }
    @SuppressLint("SetTextI18n")
    private fun displayMessage()
    {
        binding.apply {
            greetingMessage.text = "Hello!.." + nameMessage.text
        }
    }
    // progressbar visibility

    private fun progressBarUpdate()
    {
        binding.apply {
            if (progressBar.visibility == View.GONE) {
                progressBar.visibility = View.VISIBLE
                startProgress.text = "Stop"
            } else {
                progressBar.visibility = View.GONE
                startProgress.text = "Start"
            }
        }
    }

    // student data
    private fun getStudent() :Student
    {
        return Student(1,"Alex","Alex@gmail.com")
    }
}