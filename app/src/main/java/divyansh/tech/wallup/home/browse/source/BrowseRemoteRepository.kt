package divyansh.tech.wallup.home.browse.source

import divyansh.tech.wallup.home.browse.utils.BrowseFragmentDeserializer
import divyansh.tech.wallup.utils.Result
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject

class BrowseRemoteRepository @Inject constructor(
    retrofit: Retrofit
) {

    private val service = retrofit.create(BrowseWallpapersInterface::class.java)

    suspend fun getPopularWallpapers(): Result<*> {
        val response = service.getPopularWallpapers()
        return BrowseFragmentDeserializer.getWallpapers(response.string())
    }

    interface BrowseWallpapersInterface {
        @GET("/")
        suspend fun getPopularWallpapers(): ResponseBody
    }
}