package divyansh.tech.wallup.home.browse.screens.popularTags

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.wallup.common.CommonViewModel
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.home.browse.screens.popularTags.source.PopularTagsDataSource
import divyansh.tech.wallup.home.browse.source.BrowseDataSource
import divyansh.tech.wallup.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PopularTagsViewModel @Inject constructor(
    private val repo: PopularTagsDataSource,
    private val browseRepo: BrowseDataSource
) : CommonViewModel() {

    private val _popularTagsWallpapersLiveData = MutableLiveData<ArrayList<Wallpapers>>()
    val popularTagsWallpaperLiveData get() = _popularTagsWallpapersLiveData

    fun getWallpapers(url: String) = viewModelScope.launch(Dispatchers.IO) {
        val response = repo.getWallpapers(url)
        response.collect {
            if (it is Result.Success) {
                Timber.e("POPULAR DATA -> ${it.data}")
                it.data.let { _popularTagsWallpapersLiveData.postValue(it) }
            } else _popularTagsWallpapersLiveData.postValue(arrayListOf())
        }
    }

    fun getWallpaperDetails(url: String) = viewModelScope.launch(Dispatchers.IO) {
        showLoading()
        val response = browseRepo.getWallpaperDetails(url)
        response.collect {
            if (it is Result.Success) {
                Timber.e("URL IS HERE -> ${it.data}")
                // launching in UI thread since event data cannot be set from background thread
                hideLoading()
                GlobalScope.launch(Dispatchers.Main) {
                    val action =
                        PopularTagsFragmentDirections.actionPopularTagsFragmentToWallpaperDetailFragment(
                            it.data
                        )
                    changeNavigation(action)
                }
            } else Timber.e("ERROR -> $it")
        }
    }
}