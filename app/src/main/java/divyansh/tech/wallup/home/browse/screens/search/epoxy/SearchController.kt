package divyansh.tech.wallup.home.browse.screens.search.epoxy

import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import divyansh.tech.wallup.home.browse.datamodel.Categories
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.home.browse.epoxy.EpoxyRecyclerCategory_
import divyansh.tech.wallup.home.browse.epoxy.epoxyBrowseView
import divyansh.tech.wallup.home.browse.epoxy.epoxyWallpapers
import divyansh.tech.wallup.home.browse.screens.search.callbacks.SearchCallbacks
import divyansh.tech.wallup.home.browse.screens.search.dataModel.SearchScreenModel

class SearchController(
    private val callback:SearchCallbacks
): TypedEpoxyController<SearchScreenModel>() {
    override fun buildModels(data: SearchScreenModel?) {
        data?.let {
            epoxyBrowseView {
                id("Categories")
                heading("Categories")
                spanSizeOverride { totalSpanCount, _, _ ->  totalSpanCount}
            }

            val catList = ArrayList<EpoxyRecyclerCategory_>()
            it.categories.forEach {
                catList.add(
                    EpoxyRecyclerCategory_()
                        .id(it.categoryUrl)
                        .category(it)
                        .callback(callback)
                )
            }

            carousel {
                id(it.hashCode())
                models(catList)
                padding(Carousel.Padding.dp(16, 8, 16, 8, 16))
                spanSizeOverride { totalSpanCount, _, _ ->  totalSpanCount}
            }

            epoxyBrowseView {
                id("WALLPAPERS")
                heading("Wallpapers")
                spanSizeOverride { totalSpanCount, _, _ ->  totalSpanCount}
            }

            it.wallpapers.forEach {
                epoxyWallpapers {
                    id(it.imageUrl)
                    wallpaper(it)
                    callback(callback)
                    spanSizeOverride { totalSpanCount, _, _ -> totalSpanCount / 2 }
                }
            }
        }
    }
}