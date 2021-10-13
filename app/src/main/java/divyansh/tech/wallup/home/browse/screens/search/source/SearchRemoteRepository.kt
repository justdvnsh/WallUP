package divyansh.tech.wallup.home.browse.screens.search.source

import divyansh.tech.wallup.home.browse.datamodel.Categories
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.home.browse.screens.featuredCategories.utils.FeaturedCategoriesDeserializer
import divyansh.tech.wallup.home.browse.utils.BrowseFragmentDeserializer
import divyansh.tech.wallup.utils.Constants
import divyansh.tech.wallup.utils.Result
import divyansh.tech.wallup.utils.customErrors.CouldNotParseException
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import javax.inject.Inject

class SearchRemoteRepository @Inject constructor(
    retrofit: Retrofit
) {

    private val service = retrofit.create(SearchInterface::class.java)

    suspend fun getWallpapersFromSourceOne(query: String): Result<ArrayList<Wallpapers>> {
        val response = service.getWallpapersFromSourceOne(query)
        val result = BrowseFragmentDeserializer.getWallpapers(response.string())
        if (result is Result.Success) return Result.Success(result.data.items as ArrayList<Wallpapers>)
        else return Result.Error(CouldNotParseException("Something went wrong"))
    }

    suspend fun getWallpapersFromSourceTwo(query: String): Result<ArrayList<Categories>> {
        val response = service.getWallpapersFromSourceTwo(
            Constants.WALL_ACCESS_BASE_URL + "search?q=$query"
        )
        val result = BrowseFragmentDeserializer.getPopularCategories(response.string())
        if (result is Result.Success) return Result.Success(result.data.items as ArrayList<Categories>)
        else return Result.Error(CouldNotParseException("Something went wrong"))
    }

    interface SearchInterface {
        @GET("/search.php")
        suspend fun getWallpapersFromSourceOne(
            @Query("search") search: String
        ): ResponseBody

        @GET
        suspend fun getWallpapersFromSourceTwo(
            @Url url: String
        ): ResponseBody
    }
}