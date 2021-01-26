package ru.spiritblog.photogallery2

import android.app.Application
import androidx.lifecycle.*
import ru.spiritblog.photogallery2.API.FlickrFetchr
import ru.spiritblog.photogallery2.API.GalleryItem

class PhotoGalleryViewModel(private val app: Application) : AndroidViewModel(app) {

    val galleryItemLiveData: LiveData<List<GalleryItem>>


    private val flickrFetchr = FlickrFetchr()
    private val mutableSearchTerm = MutableLiveData<String>()


    val searchTerm: String
    get() = mutableSearchTerm.value ?: ""



    init {

        mutableSearchTerm.value = QueryPreferences.getStoredQuery(app)


        galleryItemLiveData = Transformations.switchMap(mutableSearchTerm) { searchTerm ->
            if (searchTerm.isBlank()) {
                flickrFetchr.fetchPhotos()
            } else {
                flickrFetchr.searchPhotos(searchTerm)
            }
        }
    }


    fun fetchPhotos(query: String = "") {
        mutableSearchTerm.value = query
        QueryPreferences.setStoredQuery(app, query)
    }


}