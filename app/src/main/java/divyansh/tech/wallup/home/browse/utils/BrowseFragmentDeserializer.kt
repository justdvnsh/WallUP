package divyansh.tech.wallup.home.browse.utils

import divyansh.tech.wallup.home.browse.BrowseViewModel
import divyansh.tech.wallup.home.browse.datamodel.*
import divyansh.tech.wallup.utils.Result
import divyansh.tech.wallup.utils.customErrors.CouldNotParseException
import org.jsoup.Jsoup
import timber.log.Timber

class BrowseFragmentDeserializer {
    companion object {
        fun getWallpapers(response: String): Result<BrowseResponseModel> {
            return try {
                val list = ArrayList<Wallpapers>();
                val jsoup = Jsoup.parse(response)
                val wallpapers = jsoup?.getElementsByClass("boxgrid")
                wallpapers?.forEach {
                    val wallpaper = Wallpapers(
                        wallpaperUrl = it.select("a").first().attr("href"),
                        imageUrl = it.select("img")?.first()?.attr("src").toString(),
                    )
                    list.add(wallpaper)
                }
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

        fun getHomePageData(response: String): Result<ArrayList<BrowseResponseModel>> {
            return try {
//                Timber.e("HOME PAGE -> $response")
                val list = ArrayList<BrowseResponseModel>()
                val jsoup = Jsoup.parse(response)
                val featuredWallpaper = jsoup.getElementById("featured_container").select("a").first()
                val item = featuredWallpaper.attr("href").split("/")
                val model = Wallpapers(
                    wallpaperUrl = item[item.lastIndex],
                    imageUrl = featuredWallpaper.select("img").attr("src")
                )
                Timber.e("FEATURED WALL -> $featuredWallpaper")
                list.add(
                    BrowseResponseModel(
                    heading = "Wallpaper of the Day",
                    type = BrowseViewModel.HOME_TYPES.FEATURED_WALLPAPER,
                    items = arrayListOf(model)
                ))
                val populartags = jsoup.getElementsByClass("popular-content-container").first().getElementsByClass("popular-container")
                val collectionList = arrayListOf<PopularTags>()
                val characterList = arrayListOf<PopularTags>()
                val peopleList = arrayListOf<PopularTags>()
                populartags[0].select("a").forEach {
                    collectionList.add(
                        PopularTags(
                        name = it.getElementsByClass("popular-name").text(),
                        url = it.attr("href"),
                        noOfWallpapers = it.getElementsByClass("badge").text()
                    ))
                }
                populartags[1].select("a").forEach {
                    characterList.add(
                        PopularTags(
                            name = it.getElementsByClass("popular-name").text(),
                            url = it.attr("href"),
                            noOfWallpapers = it.getElementsByClass("badge").text()
                        )
                    )
                }
                populartags[2].select("a").forEach {
                    peopleList.add(   PopularTags(
                        name = it.getElementsByClass("popular-name").text(),
                        url = it.attr("href"),
                        noOfWallpapers = it.getElementsByClass("badge").text()
                    ))
                }
                list.add(BrowseResponseModel(
                    heading = "Popular Collections",
                    type = BrowseViewModel.HOME_TYPES.POPULAR_COLLECTIONS,
                    items = collectionList
                ))
                list.add(BrowseResponseModel(
                    heading = "Popular Characters",
                    type = BrowseViewModel.HOME_TYPES.POPULAR_CHARACTERS,
                    items = characterList
                ))
                list.add(BrowseResponseModel(
                    heading = "Popular People",
                    type = BrowseViewModel.HOME_TYPES.POPULAR_PEOPLE,
                    items = peopleList
                ))
                Result.Success(list)
            } catch (e: Exception) {
                Result.Error(CouldNotParseException("Something went wrong"))
            }
        }

        fun getPopularCategories(response: String): Result<BrowseResponseModel> {
            return try {
                val jsoup = Jsoup.parse(response)
                val categories = jsoup.getElementsByClass("column collection_thumb")
                val categoryList = arrayListOf<Categories>()
                categories.forEach {
                    categoryList.add(
                        Categories(
                            name = it.select("a").first().attr("title"),
                            categoryUrl = it.select("a").first().attr("href"),
                            imageUrl = it.select("a").first().select("img").attr("src"),
                            noOfWallpapers = it.getElementsByClass("image icon").text()
                        )
                    )
                }
                val model = BrowseResponseModel(
                    heading = "Top categories for you",
                    type = BrowseViewModel.HOME_TYPES.FEATURED_CATEGORIES,
                    items = categoryList
                )
                Result.Success(model)
            } catch (e: Exception) {
                Result.Error(CouldNotParseException("Something Went wrong"))
            }
        }

        fun getWallpaperDetails(response: String): Result<WallpaperUrlRequestBody> {
            return try {
                val jsoup = Jsoup.parse(response)
                val downloadLink = jsoup.getElementsByClass("btn btn-success btn-custom download-button")
                val link = WallpaperUrlRequestBody(
                    content_id = downloadLink.attr("data-id").toInt(),
                    file_type = downloadLink.attr("data-type"),
                    image_server = downloadLink.attr("data-server")
                )
                Timber.e("URL REQUEST BODY -> $link")
                Result.Success(link)
            } catch (e: Exception) {
                Result.Error(CouldNotParseException("Something Went Wrong"))
            }
        }
    }
}