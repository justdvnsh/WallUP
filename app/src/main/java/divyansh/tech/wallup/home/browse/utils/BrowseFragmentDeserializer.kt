package divyansh.tech.wallup.home.browse.utils

import divyansh.tech.wallup.home.browse.BrowseViewModel
import divyansh.tech.wallup.home.browse.datamodel.BrowseResponseModel
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.utils.Result
import divyansh.tech.wallup.utils.customErrors.CouldNotParseException
import org.jsoup.Jsoup
import timber.log.Timber

class BrowseFragmentDeserializer {
    companion object {
        fun getWallpapers(response: String): Result<BrowseResponseModel> {
            Timber.e("RESPONSE -> $response")
            return try {
                val list = ArrayList<Wallpapers>();
                val jsoup = Jsoup.parse(response)
                val wallpapers = jsoup?.getElementById("flow")?.select("ul")?.first()?.select("li")
                wallpapers?.forEach {
                    val wallpaper = Wallpapers(
                        wallpaperUrl = it.select("a")?.first()?.attr("href").toString(),
                        imageUrl = it.select("img")?.first()?.attr("data-src").toString(),
                    )
                    list.add(wallpaper)
                }
                Timber.e("Wallpapers -> $list")
                val browseResponseModel = BrowseResponseModel(
                    heading = "Wallpapers",
                    type = BrowseViewModel.HOME_TYPES.POPULAR_WALLPAPERS,
                    items = list
                )
                Result.Success(browseResponseModel)
            } catch (e: Exception) {
                Result.Error(CouldNotParseException("Something went wrong on our side."))
            }
        }
    }
}