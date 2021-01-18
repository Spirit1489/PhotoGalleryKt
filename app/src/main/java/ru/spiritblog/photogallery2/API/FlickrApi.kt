package ru.spiritblog.photogallery2.API

import retrofit2.Call
import retrofit2.http.GET

interface FlickrApi {

    @GET("/")
    fun fetchContents(): Call<String>

}