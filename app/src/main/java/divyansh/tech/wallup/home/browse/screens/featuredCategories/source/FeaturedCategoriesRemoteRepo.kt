package divyansh.tech.wallup.home.browse.screens.featuredCategories.source

import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.home.browse.screens.featuredCategories.utils.FeaturedCategoriesDeserializer
import divyansh.tech.wallup.utils.Constants
import divyansh.tech.wallup.utils.Result
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Url
import javax.inject.Inject

class FeaturedCategoriesRemoteRepo @Inject constructor(
    retrofit: Retrofit
){

    private val service = retrofit.create(FeaturedCategoriesWallpaperInterface::class.java)

    suspend fun getWallpapers(url: String): Result<ArrayList<Wallpapers>> {
        val response = service.getWallpaper(Constants.WALL_ACCESS_BASE_URL + url)
        return FeaturedCategoriesDeserializer.getWallpapers(response.string())
    }

    interface FeaturedCategoriesWallpaperInterface {
        @GET
        suspend fun getWallpaper(
            @Url url: String
        ): ResponseBody
    }
}