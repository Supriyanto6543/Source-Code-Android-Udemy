   package com.app.myapplication

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_button.*
import kotlinx.android.synthetic.main.activity_intent.*
import kotlinx.android.synthetic.main.activity_intent.edt
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_shared.*

   class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared)

        // TOAST ANDROID
        /*button.setOnClickListener {

            var username:Int  = username.text.toString().toInt()
            var name: Int = name.text.toString().toInt()
            var z:Int = name+username

            Toast.makeText(applicationContext, "Hasilnya adalah:" + z, Toast.LENGTH_LONG).show()
        }*/


        // BUTTON CLICK
        /*one.setOnClickListener {
            tampilan.setBackgroundColor(Color.parseColor("#ff9900"))
        }
        dua.setOnClickListener {
            tampilan.setBackgroundColor(Color.parseColor("#ff1290"))
        }
        tiga.setOnClickListener {
            tampilan.setBackgroundColor(Color.parseColor("#ff3412"))
        }*/

        // INTENT
        /*pergi.setOnClickListener {

            var pergi = Intent(this,MainKedua::class.java)
            var x:String = edt.text.toString()
            pergi.putExtra("name", edt.text.toString())
            startActivity(pergi)

        }*/

        // SHARED PREFERENCES
        save.setOnClickListener {
            var sp = getSharedPreferences("data", Context.MODE_PRIVATE)
            var editor = sp.edit()

            editor.putString("name", edt.text.toString())
            editor.commit()


        }

        load.setOnClickListener {
            var spp = getSharedPreferences("data", Context.MODE_PRIVATE)
            tv.text = spp.getString("name", "")
        }


    }
}
