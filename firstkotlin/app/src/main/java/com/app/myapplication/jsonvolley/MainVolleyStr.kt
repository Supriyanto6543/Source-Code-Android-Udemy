package com.app.myapplication.jsonvolley

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.app.myapplication.R
import kotlinx.android.synthetic.main.activity_volley.*

/**
 * Created by SUPRIYANTO on 1/23/2020
 */

class MainVolleyStr : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volley)

        var url:String = "http://192.168.1.15/mykotlinstore/volleystring.php"

        var request:RequestQueue = Volley.newRequestQueue(this)
        var sr = StringRequest(Request.Method.GET, url, Response.Listener { response ->

            tvv.text = response

        }, Response.ErrorListener { error ->

            tvv.text = error.message

        })

        request.add(sr)


        // JSON OBJECT
        /*tampilkan.setOnClickListener {
            var obj_url:String = "http://192.168.1.15/mykotlinstore/json_obj_use_produst.php?id=" + edt.text.toString()
            var req:RequestQueue = Volley.newRequestQueue(this)
            var json = JsonObjectRequest(Request.Method.GET, obj_url,null, Response.Listener { response ->

                tvv.text = response.getString("name")
                tvvv.text = response.getString("price")

            }, Response.ErrorListener { error ->

                tvv.text = error.message

            })

            req.add(json)
        }*/

        // JSON ARRAY
        tampilkan.setOnClickListener {
            var arr_url:String = "http://192.168.1.15/mykotlinstore/json_array_use_product.php"
            var arrayList = ArrayList<String>()
            var showing:String = ""

            var req:RequestQueue = Volley.newRequestQueue(this)
            var res = JsonArrayRequest(Request.Method.GET, arr_url, null, Response.Listener { response ->

                for (x in 0 .. response.length()-1) {

                    showing += ("Name: " + response.getJSONObject(x).getString("name") + " - " + "Price: " + response.getJSONObject(x).optString("price") + "\n")

                }

                tvv.text = showing

            }, Response.ErrorListener { error ->

                tvv.text = error.message

            })

            req.add(res)
        }

    }

}