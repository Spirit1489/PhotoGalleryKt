package ru.spiritblog.photogallery2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.spiritblog.photogallery2.API.FlickrFetchr
import ru.spiritblog.photogallery2.API.GalleryItem

class PhotoGalleryViewModel : ViewModel() {

    val galleryItemLiveData: LiveData<List<GalleryItem>>


    init {
        galleryItemLiveData = FlickrFetchr().fetchPhotos()
    }


}