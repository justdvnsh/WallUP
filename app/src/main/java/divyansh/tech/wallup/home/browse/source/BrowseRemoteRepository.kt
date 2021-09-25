package divyansh.tech.wallup.home.browse.source

import divyansh.tech.wallup.home.browse.datamodel.BrowseResponseModel
import divyansh.tech.wallup.home.browse.utils.BrowseFragmentDeserializer
import divyansh.tech.wallup.utils.Result
import divyansh.tech.wallup.utils.customErrors.CouldNotParseException
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.http.GET
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

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

    interface BrowseWallpapersInterface {
        @GET("/")
        suspend fun getPopularWallpapers(): ResponseBody
    }
}