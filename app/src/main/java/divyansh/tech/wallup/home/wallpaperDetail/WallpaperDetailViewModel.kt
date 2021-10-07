package divyansh.tech.wallup.home.wallpaperDetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.wallup.common.CommonViewModel
import divyansh.tech.wallup.home.wallpaperDetail.dataModels.WallpaperDetailScreenModel
import divyansh.tech.wallup.home.wallpaperDetail.source.WallpaperDetailDataSource
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

    fun getWallpaperData(url: String) = viewModelScope.launch(Dispatchers.IO) {
        val response = repo.getWallpaperResolutionList(url)
        response.collect {
            if (it is Result.Success) {
                _wallpaperDetailLiveData.postValue(it.data as WallpaperDetailScreenModel)
            } else Timber.e("ERROR IS -> $it")
        }
    }
}