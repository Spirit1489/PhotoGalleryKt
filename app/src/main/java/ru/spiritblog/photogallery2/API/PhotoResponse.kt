package ru.spiritblog.photogallery2.API

import com.google.gson.annotations.SerializedName


class PhotoResponse {
    @SerializedName("photo")
    lateinit var galleryItems: List<GalleryItem>
}