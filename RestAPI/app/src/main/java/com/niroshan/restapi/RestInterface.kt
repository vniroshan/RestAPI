package com.niroshan.restapi


import retrofit2.Call
import retrofit2.http.GET

interface RestInterface {
    @get:GET("posts")
    val posts : Call<List<PostItems?>?>?
    companion object{
        const val BaseUrl="https://jsonplaceholder.typicode.com"
    }
}