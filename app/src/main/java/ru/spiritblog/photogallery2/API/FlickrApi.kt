package ru.spiritblog.photogallery2.API

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface FlickrApi {

    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
                "&api_key=5afd258f4d1ee01c9dc8239105054078" +
                "&format=json" +
                "&nojsoncallback=1" +
                "&extras=url_s"


    )
    fun fetchPhotos(): Call<FlickrResponse>


    @GET
    fun fetchUrlBytes(@Url url: String): Call<ResponseBody>


}