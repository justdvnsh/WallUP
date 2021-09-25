package divyansh.tech.wallup.home.browse.source

import android.graphics.Color
import divyansh.tech.wallup.R
import divyansh.tech.wallup.home.browse.BrowseViewModel
import divyansh.tech.wallup.home.browse.datamodel.*
import divyansh.tech.wallup.home.browse.utils.BrowseFragmentDeserializer
import divyansh.tech.wallup.utils.Result
import javax.inject.Inject

class BrowseLocalRepository @Inject constructor() {

    suspend fun getAllCategories(): Result<BrowseResponseModel> {
        val categoryList = arrayListOf<Categories>(
            Categories("Business", R.drawable.business),
            Categories("Beach", R.drawable.beach),
            Categories("Love", R.drawable.love),
            Categories("Flowers", R.drawable.flowers),
            Categories("Nature", R.drawable.nature),
            Categories("Women", R.drawable.women),
            Categories("Cars", R.drawable.cars),
            Categories("Dogs", R.drawable.dogs),
            Categories("Travel", R.drawable.travel),
            Categories("Food", R.drawable.food)
        )
        val browseResponseModel = BrowseResponseModel(
            heading = "Categories",
            type = BrowseViewModel.HOME_TYPES.CATEGORIES,
            items = categoryList
        )
        return Result.Success(browseResponseModel)
    }

    suspend fun getAllRecommended(): Result<BrowseResponseModel> {
        val recommendedList = arrayListOf<Categories>(
            Categories("Abstract", R.drawable.abs),
            Categories("Anime", R.drawable.anime),
            Categories("Books", R.drawable.books),
            Categories("Computers", R.drawable.computers),
            Categories("Illustrations", R.drawable.illustrations),
            Categories("Music", R.drawable.music),
        )
        val browseResponseModel = BrowseResponseModel(
            heading = "Recommended",
            type = BrowseViewModel.HOME_TYPES.RECOMMENDED,
            items = recommendedList
        )
        return Result.Success(browseResponseModel)
    }
}