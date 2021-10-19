package divyansh.tech.wallup.home.wallpaperDetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.wallup.common.CommonViewModel
import divyansh.tech.wallup.common.database.WallpaperDao
import divyansh.tech.wallup.home.browse.datamodel.OfflineWallpapers
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.utils.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class WallpaperDetailViewModel @Inject constructor(
    private val wallpaperDao: WallpaperDao
): CommonViewModel() {

    private val _favoriteLiveData = MutableLiveData<Event<Boolean>>()
    val favoriteLiveData get() = _favoriteLiveData

    fun saveWallpaper(url: String) = viewModelScope.launch(Dispatchers.IO) {
        Timber.e("OFFLINE -> ${wallpaperDao.getAllWallpapers()}")
        wallpaperDao.insertNewWallpaper(OfflineWallpapers(url))
        _favoriteLiveData.postValue(Event(true))
    }
}