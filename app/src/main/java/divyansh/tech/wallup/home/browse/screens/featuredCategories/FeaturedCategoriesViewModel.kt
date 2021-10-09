package divyansh.tech.wallup.home.browse.screens.featuredCategories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.wallup.common.CommonViewModel
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.home.browse.screens.featuredCategories.source.FeaturedCategoriesDataSource
import divyansh.tech.wallup.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeaturedCategoriesViewModel @Inject constructor(
    private val repo: FeaturedCategoriesDataSource
): CommonViewModel(){

    private val _featuredCatWallpapers = MutableLiveData<ArrayList<Wallpapers>>()
    val featuredCatWallpapers get() = _featuredCatWallpapers

    fun getWallpapers(url: String) = viewModelScope.launch(Dispatchers.IO) {
        val response = repo.getWallpapers(url)
        response.collect {
            if (it is Result.Success) it.data.let { _featuredCatWallpapers.postValue(it) }
            else _featuredCatWallpapers.postValue(arrayListOf())
        }
    }
}