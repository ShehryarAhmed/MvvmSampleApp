package com.example.mvvmsample.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mvvmsample.R
import com.example.mvvmsample.viewmodel.LoginViewModel

import androidx.databinding.DataBindingUtil
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.example.mvvmsample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.setViewModel(LoginViewModel())
        activityMainBinding.executePendingBindings()
    }

    @BindingAdapter("toastMessage")
    fun runMe(view: View, message: String?) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show()
    }

}
