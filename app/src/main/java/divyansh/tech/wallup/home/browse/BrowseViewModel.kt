package divyansh.tech.wallup.home.browse

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.wallup.common.CommonViewModel
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.home.browse.source.BrowseDataSource
import divyansh.tech.wallup.utils.Result
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class BrowseViewModel @Inject constructor(
    private val repo: BrowseDataSource
): CommonViewModel() {

    private val _popularWallpapersLiveData: MutableLiveData<String> = MutableLiveData()
    val popularWallpapersLiveData get() = _popularWallpapersLiveData

    init {
        getPopularWallpapers()
    }

    private fun getPopularWallpapers() = viewModelScope.launch {
        Timber.e("INSIDE VIEWMODEL CALL")
        when(val response = repo.getPopularWallpapers()) {
            is Result.Success -> {
                _popularWallpapersLiveData.postValue(
                    response.data as String
                )
            }
            is Result.Error -> {}
            else -> {}
        }
    }
}