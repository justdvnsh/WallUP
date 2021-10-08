package divyansh.tech.wallup.home.browse

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.wallup.common.CommonViewModel
import divyansh.tech.wallup.home.browse.datamodel.BrowseResponseModel
import divyansh.tech.wallup.home.browse.source.BrowseDataSource
import divyansh.tech.wallup.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class BrowseViewModel @Inject constructor(
    private val repo: BrowseDataSource
): CommonViewModel() {

    private val _popularWallpapersLiveData: MutableLiveData<ArrayList<BrowseResponseModel>> = MutableLiveData()
    val popularWallpapersLiveData get() = _popularWallpapersLiveData

    private val _list: ArrayList<BrowseResponseModel> = arrayListOf()

    init {
        getPopularWallpapers()
    }

    private fun getPopularWallpapers() = viewModelScope.launch(Dispatchers.IO) {
        Timber.e("INSIDE VIEWMODEL CALL")
        repo.getPopularCategories().collect {
            if (it is Result.Success) _list.add(it.data as BrowseResponseModel)
            _popularWallpapersLiveData.postValue(_list)
        }
        repo.getFeaturedWallpaperAndHomePageData().collect {
            if (it is Result.Success) _list.addAll(it.data as ArrayList<BrowseResponseModel>)
            _popularWallpapersLiveData.postValue(_list)
        }
        repo.getPopularWallpapers().collect {
            if (it is Result.Success) {
                _list.add(it.data as BrowseResponseModel)
                _popularWallpapersLiveData.postValue(_list)
            }
            else _popularWallpapersLiveData.postValue(_list)
            }
        }

    enum class HOME_TYPES {
        FEATURED_WALLPAPER,
        POPULAR_WALLPAPERS,
        FEATURED_CATEGORIES,
        POPULAR_PEOPLE,
        POPULAR_CHARACTERS,
        POPULAR_COLLECTIONS
    }
}