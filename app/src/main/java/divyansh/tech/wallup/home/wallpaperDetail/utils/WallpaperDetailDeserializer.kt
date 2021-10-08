package divyansh.tech.wallup.home.wallpaperDetail.utils

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Base64
import android.webkit.JavascriptInterface
import android.webkit.WebView
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.home.wallpaperDetail.dataModels.Resolution
import divyansh.tech.wallup.home.wallpaperDetail.dataModels.WallpaperDetailScreenModel
import divyansh.tech.wallup.home.wallpaperDetail.dataModels.Tags
import divyansh.tech.wallup.utils.Result
import org.jsoup.Connection
import org.jsoup.Jsoup
import timber.log.Timber
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class WallpaperDetailDeserializer {
    companion object {
        fun getAllResolutions(response: String): Result<*> {
            return try {
                val jsoup = Jsoup.parse(response)
                val tagList = ArrayList<Tags>()
                val wallpaperList = ArrayList<Wallpapers>()
                val resList = ArrayList<Resolution>()
                val tags = jsoup.getElementsByClass("tag").select("li")
                tags.forEach {
                    tagList.add(
                        Tags(
                        url = it.select("a").attr("href"),
                        name = it.select("a").text()
                    ))
                }
                val resolutions = jsoup.getElementsByClass("res_resize res_zone").select("li")
                resolutions.forEach {
                    resList.add(
                        Resolution(
                        url = it.select("a").attr("href"),
                        res = it.select("a").text()
                    ))
                }
                val wallpapers = jsoup.getElementsByClass("related_list").select("figure")
                wallpapers.forEach {
                    wallpaperList.add(
                        Wallpapers(
                        wallpaperUrl = it.select("a").attr("href"),
                        imageUrl = it.select("a")?.first()?.select("img")?.attr("data-src").toString()
                    ))
                }
                val model = WallpaperDetailScreenModel(
                    Tags = tagList,
                    res = resList,
                    relatedWallpapers = wallpaperList
                )
                Result.Success(model)
            } catch (e: Exception) {
                Result.Error(e)
            }
        }

        fun getWallpaper(response: String):Result<*> {
            return try {
                val jsoup = Jsoup.parse(response)
                val imageUrl = jsoup.getElementById("show_img").attr("src")
                val url = Base64.decode(imageUrl, Base64.DEFAULT)
                val decodedImage = BitmapFactory.decodeByteArray(url, 0, url.size)
                Timber.e("DATA - SRC -> $decodedImage")
                Result.Success(decodedImage)
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
    }
}