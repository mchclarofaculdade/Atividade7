package com.example.atividade7

import android.os.Bundle
import android.widget.ArrayAdapter

import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lista = findViewById<ListView>(R.id.lista)
        var url = "https://jsonplaceholder.typicode.com/users/"
        var item: ArrayList<String> = ArrayList<String>();
        item.add(url)

        var adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)
        lista.adapter = adapter

        var jsonRequest = JsonArrayRequest(
            Request.Method.GET,url,null,
            Response.Listener { response ->
                item.add("Response is: ${response.toString()}")
                adapter!!.notifyDataSetChanged()
            },
            Response.ErrorListener { error ->
                print("That didn't work!")
            })

          MapsActivity.getInstance(this).addToRequestQueue(jsonRequest)

    }
}