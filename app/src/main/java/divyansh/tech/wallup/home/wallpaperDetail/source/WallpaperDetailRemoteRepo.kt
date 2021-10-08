package divyansh.tech.wallup.home.wallpaperDetail.source

import divyansh.tech.wallup.home.wallpaperDetail.dataModels.Resolution
import divyansh.tech.wallup.home.wallpaperDetail.utils.WallpaperDetailDeserializer
import divyansh.tech.wallup.utils.Result
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Url
import java.lang.Exception
import javax.inject.Inject

class WallpaperDetailRemoteRepo @Inject constructor(
    retrofit: Retrofit
) {

    private val service = retrofit.create(WallpaperDetailInterface::class.java)

    suspend fun getWallpaperResolutions(url: String): Result<*> {
        return try {
            WallpaperDetailDeserializer.getAllResolutions(
                service.getWallpaperResolutions(url).string()
            )
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

//    suspend fun getWallpaperImage(url: String): Result<*> {
//        return try {
//            WallpaperDetailDeserializer.getWallpaper(
//                url
//            )
//        } catch (e: Exception) {
//            Result.Error(e)
//        }
//    }

    interface WallpaperDetailInterface {
        @GET
        suspend fun getWallpaperResolutions(
            @Url url: String
        ): ResponseBody
    }
}