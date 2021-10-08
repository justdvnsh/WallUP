package divyansh.tech.wallup.home.wallpaperDetail

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.wallup.common.CommonViewModel
import divyansh.tech.wallup.home.wallpaperDetail.dataModels.WallpaperDetailScreenModel
import divyansh.tech.wallup.home.wallpaperDetail.source.WallpaperDetailDataSource
import divyansh.tech.wallup.home.wallpaperDetail.utils.WallpaperDetailDeserializer
import divyansh.tech.wallup.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class WallpaperDetailViewModel @Inject constructor(
    private val repo: WallpaperDetailDataSource
): CommonViewModel() {

    private val _wallpaperDetailLiveData = MutableLiveData<WallpaperDetailScreenModel>()
    val wallpaperDetailLiveData get() = _wallpaperDetailLiveData

    private val _wallpaperImageLiveData = MutableLiveData<Bitmap>()
    val wallpaperImageLiveData get() = _wallpaperImageLiveData

    fun getWallpaperData(url: String) = viewModelScope.launch(Dispatchers.IO) {
        val response = repo.getWallpaperResolutionList(url)
        response.collect {
            if (it is Result.Success) {
                val item = it.data as WallpaperDetailScreenModel
                _wallpaperDetailLiveData.postValue(item)
            } else Timber.e("ERROR IS -> $it")
        }
    }

    fun getWallpaperImage(html: String) =
        viewModelScope.launch(Dispatchers.IO){
            val wallpaperResponse = WallpaperDetailDeserializer.getWallpaper(html)
            if (wallpaperResponse is Result.Success)
                _wallpaperImageLiveData.postValue(wallpaperResponse.data as Bitmap)
    }
}