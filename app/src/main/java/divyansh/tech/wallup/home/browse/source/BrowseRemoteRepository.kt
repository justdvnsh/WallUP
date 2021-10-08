package divyansh.tech.wallup.home.browse.source

import divyansh.tech.wallup.home.browse.datamodel.BrowseResponseModel
import divyansh.tech.wallup.home.browse.datamodel.WallpaperDetailResponseBody
import divyansh.tech.wallup.home.browse.datamodel.WallpaperUrlRequestBody
import divyansh.tech.wallup.home.browse.utils.BrowseFragmentDeserializer
import divyansh.tech.wallup.utils.Constants
import divyansh.tech.wallup.utils.Result
import divyansh.tech.wallup.utils.customErrors.CouldNotParseException
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url
import timber.log.Timber
import javax.inject.Inject
import kotlin.Exception

class BrowseRemoteRepository @Inject constructor(
    retrofit: Retrofit
) {

    private val service = retrofit.create(BrowseWallpapersInterface::class.java)

    suspend fun getPopularWallpapers(): Result<*> {
        return try {
            val response = service.getPopularWallpapers()
            BrowseFragmentDeserializer.getWallpapers(response.string())
        } catch (e: Exception) {
            Timber.e("Error is -> ${e.localizedMessage}")
            Result.Error(CouldNotParseException("Something went wrong"))
        }
    }

    suspend fun getFeaturedWallpaperAndHomePageData(): Result<*> {
        return try {
            val response = service.getHomePageData()
            BrowseFragmentDeserializer.getHomePageData(response.string())
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    suspend fun getPopularCategories(): Result<*> {
        return try {
            val response = service.getPopularCategories()
            BrowseFragmentDeserializer.getPopularCategories(response.string())
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    suspend fun getWallpaperDetail(url: String): Result<WallpaperUrlRequestBody> {
        return try {
            val response = service.getWallpaperDetail(url)
            BrowseFragmentDeserializer.getWallpaperDetails(response.string())
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    suspend fun getWallpaperDownloadUrl(body: WallpaperUrlRequestBody): Result<WallpaperDetailResponseBody> {
        return try {
            Result.Success(service.getWallpaperUrl(body))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    interface BrowseWallpapersInterface {
        @GET("/")
        suspend fun getHomePageData(): ResponseBody

        @GET("/featured.php")
        suspend fun getPopularWallpapers(): ResponseBody

        @GET
        suspend fun getWallpaperDetail(
            @Url url: String
        ): ResponseBody

        @POST(Constants.DOWNLOAD_URL)
        suspend fun getWallpaperUrl(
            @Body body: WallpaperUrlRequestBody
        ): WallpaperDetailResponseBody

        @GET
        suspend fun getPopularCategories(
            @Url url: String = Constants.WALL_ACCESS_BASE_URL
        ): ResponseBody
    }
}