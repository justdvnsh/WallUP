package divyansh.tech.wallup.home.browse.screens.featuredCategories.utils

import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.utils.Constants
import divyansh.tech.wallup.utils.Result
import divyansh.tech.wallup.utils.customErrors.CouldNotParseException
import org.jsoup.Jsoup
import timber.log.Timber

class FeaturedCategoriesDeserializer {
    companion object {
        fun getWallpapers(response: String): Result<ArrayList<Wallpapers>> {
            return try {
                val jsoup = Jsoup.parse(response)
                val list = ArrayList<Wallpapers>()
                val item = jsoup.getElementById("maincontent").select("div")
                item.forEach {
                    if (it.hasAttr("data-download")) list.add(
                        Wallpapers(
                            Constants.WALL_ACCESS_BASE_URL + it.attr("data-download").trim(),
                            Constants.WALL_ACCESS_BASE_URL + it.attr("data-download").trim()
                        )
                    )
                }
                Result.Success(list)
            } catch (e: Exception) {
                Result.Error(CouldNotParseException("Somethign went wrong"))
            }
        }
    }
}