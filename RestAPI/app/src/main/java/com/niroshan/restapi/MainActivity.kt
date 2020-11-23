package com.niroshan.restapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var rs=Retrofit.Builder()
                 .baseUrl(RestInterface.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build()
        var API=rs.create(RestInterface::class.java)
        var call =API.posts

        call?.enqueue(object: Callback<List<PostItems?>?> {
            override fun onResponse(call: Call<List<PostItems?>?>, response: Response<List<PostItems?>?>) {
                var postlist : List<PostItems>? = response.body() as List<PostItems>
                var post = arrayOfNulls<String>(postlist!!.size)

                for(i in postlist!!.indices )
                    post[i]=postlist!![i]!!.title

                var adapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_dropdown_item_1line,post)

                findViewById<ListView>(R.id.listView).adapter=adapter



            }

            override fun onFailure(call: Call<List<PostItems?>?>, t: Throwable) {



            }

        } )

    }
}