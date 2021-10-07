package divyansh.tech.wallup.home.browse.epoxy

import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import divyansh.tech.wallup.home.browse.BrowseViewModel
import divyansh.tech.wallup.common.BrowseCallbacks
import divyansh.tech.wallup.home.browse.datamodel.*
import timber.log.Timber

class EpoxyBrowseController(
    private val callback: BrowseCallbacks
): TypedEpoxyController<ArrayList<BrowseResponseModel>>() {
    override fun buildModels(data: ArrayList<BrowseResponseModel>?) {
        data?.let {
            Timber.e("BROWSE RESPONSE MODEL -> $it")
            it.forEach {
                when(it.type) {
                    BrowseViewModel.HOME_TYPES.POPULAR_WALLPAPERS -> buildWallpapers(it)
                    BrowseViewModel.HOME_TYPES.CATEGORIES -> buildCategories(it)
                    BrowseViewModel.HOME_TYPES.RECOMMENDED -> buildRecommended(it)
                    BrowseViewModel.HOME_TYPES.COLORS -> {}
                }
            }
        }
    }

    private fun buildWallpapers(model: BrowseResponseModel) {
        (model.items as ArrayList<Wallpapers>).forEach {
            epoxyWallpapers {
                id(it.imageUrl)
                wallpaper(it)
                callback(callback)
                spanSizeOverride { totalSpanCount, _, _ -> totalSpanCount/2 }
            }
        }
    }

    private fun buildCategories(model: BrowseResponseModel) {
        epoxyBrowseView {
            id(model.hashCode())
            heading(model.heading)
            spanSizeOverride { totalSpanCount, _, _ ->  totalSpanCount}
        }
        val list = ArrayList<EpoxyRecyclerCategory_>()
        (model.items as ArrayList<Categories>).forEach {
            val item = EpoxyRecyclerCategory_()
                .id(it.hashCode())
                .imageUrl(it.asset)
                .heading(it.name)
            list.add(item)
        }

        carousel {
            id(model.hashCode())
            models(list)
            padding(Carousel.Padding.dp(16, 8, 16, 8, 16))
            spanSizeOverride { totalSpanCount, _, _ ->  totalSpanCount}
        }
    }

    private fun buildRecommended(model: BrowseResponseModel) {
        epoxyBrowseView {
            id(model.hashCode())
            heading(model.heading)
            spanSizeOverride { totalSpanCount, _, _-> totalSpanCount}
        }
        (model.items as ArrayList<Categories>).forEach {
            epoxyRecommendedCategory {
                id(it.hashCode())
                imageUrl(it.asset)
                heading(it.name)
                spanSizeOverride { totalSpanCount, _, _-> totalSpanCount / 2 }
            }
        }
    }
}