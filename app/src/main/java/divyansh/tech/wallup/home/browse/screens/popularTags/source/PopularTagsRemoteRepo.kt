package divyansh.tech.wallup.home.browse.screens.popularTags.source

import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.home.browse.utils.BrowseFragmentDeserializer
import divyansh.tech.wallup.utils.Result
import divyansh.tech.wallup.utils.customErrors.CouldNotParseException
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Url
import timber.log.Timber
import javax.inject.Inject

class PopularTagsRemoteRepo @Inject constructor(
    retrofit: Retrofit
) {

    private val service = retrofit.create(PopularTagsInterface::class.java)

    suspend fun getWallpapers(url: String): Result<ArrayList<Wallpapers>> {
        val response = service.getWallpapers(url)
        val result = BrowseFragmentDeserializer.getWallpapers(response.string())
        Timber.e("POPULAR DATA -> $result")
        if (result is Result.Success) return Result.Success(result.data.items as ArrayList<Wallpapers>)
        else return Result.Error(CouldNotParseException("Something went wrong"))
    }

    interface PopularTagsInterface {
        @GET
        suspend fun getWallpapers(
            @Url url: String
        ): ResponseBody
    }
}