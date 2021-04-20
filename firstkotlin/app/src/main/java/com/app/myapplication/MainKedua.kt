package com.app.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_button.*

/**
 * Created by SUPRIYANTO on 1/22/2020
 */

class MainKedua : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        second.text = "Selamat datang" + intent.getStringExtra("name")

    }

}