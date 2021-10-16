package divyansh.tech.wallup.home.browse.screens.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.wallup.common.CommonViewModel
import divyansh.tech.wallup.home.browse.screens.search.dataModel.SearchScreenModel
import divyansh.tech.wallup.home.browse.screens.search.source.SearchDataSource
import divyansh.tech.wallup.home.browse.source.BrowseDataSource
import divyansh.tech.wallup.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repo: SearchDataSource,
    private val browseRepo: BrowseDataSource
) : CommonViewModel() {

    private val _searchResultLiveData = MutableLiveData<SearchScreenModel?>()
    val searchResultLiveData get() = _searchResultLiveData

    fun search(query: String) = viewModelScope.launch(Dispatchers.IO) {
        val response = repo.searchWallpapers(query)
        response.collect {
            if (it is Result.Success) _searchResultLiveData.postValue(it.data)
            else _searchResultLiveData.postValue(null)
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
                        SearchFragmentDirections.actionSearchFragmentToWallpaperDetailFragment(it.data)
                    changeNavigation(action)
                }
            } else Timber.e("ERROR -> $it")
        }
    }
}