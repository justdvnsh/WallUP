package divyansh.tech.wallup.home.browse.epoxy

import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.airbnb.epoxy.group
import divyansh.tech.wallup.R
import divyansh.tech.wallup.home.browse.BrowseViewModel
import divyansh.tech.wallup.common.BrowseCallbacks
import divyansh.tech.wallup.home.browse.datamodel.*
import divyansh.tech.wallup.home.wallpaperDetail.epoxy.CategoryBackgroundModel_
import divyansh.tech.wallup.home.wallpaperDetail.epoxy.EpoxyTagItemModel_
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
                    BrowseViewModel.HOME_TYPES.POPULAR_PEOPLE -> buildPeople(it)
                    BrowseViewModel.HOME_TYPES.POPULAR_CHARACTERS -> buildCharacters(it)
                    BrowseViewModel.HOME_TYPES.POPULAR_COLLECTIONS -> buildCollections(it)
                    BrowseViewModel.HOME_TYPES.FEATURED_WALLPAPER -> buildFeaturedWallpaper(it)
                    BrowseViewModel.HOME_TYPES.FEATURED_CATEGORIES -> buildFeaturedCategories(it)
                }
            }
        }
    }

    private fun buildWallpapers(model: BrowseResponseModel) {
        epoxyBrowseView {
            id("${model.hashCode()} WALLPAPERS")
            heading(model.heading)
            spanSizeOverride { totalSpanCount, _, _ ->  totalSpanCount}
        }
        (model.items as ArrayList<Wallpapers>).forEach {
            epoxyWallpapers {
                id(it.imageUrl)
                wallpaper(it)
                callback(callback)
                spanSizeOverride { totalSpanCount, _, _ -> totalSpanCount / 2 }
            }
        }
    }

    private fun buildCharacters(model: BrowseResponseModel) {
        epoxyBrowseView {
            id("${model.hashCode()} CHARACTERS")
            heading(model.heading)
            spanSizeOverride { totalSpanCount, _, _ ->  totalSpanCount}
        }
        val characterList = ArrayList<EpoxyTagItemModel_>()
        (model.items as ArrayList<PopularTags>).forEach {
            characterList.add(
                EpoxyTagItemModel_()
                    .id(it.hashCode())
                    .tag(it)
            )
        }

        group {
            id("character_group")
            layout(R.layout.recycler_category_background)
            add(
                CategoryBackgroundModel_()
                    .id(characterList.hashCode())
                    .models(characterList)
                    .padding(Carousel.Padding.dp(16, 18, 16, 0, 8))
            )
        }
    }

    private fun buildCollections(model: BrowseResponseModel) {
        epoxyBrowseView {
            id("${model.hashCode()} COLLECTIONS")
            heading(model.heading)
            spanSizeOverride { totalSpanCount, _, _ ->  totalSpanCount}
        }
        val characterList = ArrayList<EpoxyTagItemModel_>()
        (model.items as ArrayList<PopularTags>).forEach {
            characterList.add(
                EpoxyTagItemModel_()
                    .id(it.hashCode())
                    .tag(it)
            )
        }

        group {
            id("character_group")
            layout(R.layout.recycler_category_background)
            add(
                CategoryBackgroundModel_()
                    .id(characterList.hashCode())
                    .models(characterList)
                    .padding(Carousel.Padding.dp(16, 18, 16, 0, 8))
            )
        }
    }

    private fun buildPeople(model: BrowseResponseModel) {
        epoxyBrowseView {
            id("${model.hashCode()} PEOPLE")
            heading(model.heading)
            spanSizeOverride { totalSpanCount, _, _ ->  totalSpanCount}
        }
        val characterList = ArrayList<EpoxyTagItemModel_>()
        (model.items as ArrayList<PopularTags>).forEach {
            characterList.add(
                EpoxyTagItemModel_()
                    .id(it.hashCode())
                    .tag(it)
            )
        }

        group {
            id("character_group")
            layout(R.layout.recycler_category_background)
            add(
                CategoryBackgroundModel_()
                    .id(characterList.hashCode())
                    .models(characterList)
                    .padding(Carousel.Padding.dp(16, 18, 16, 0, 8))
            )
        }
    }

    private fun buildFeaturedCategories(model: BrowseResponseModel) {
        epoxyBrowseView {
            id("${model.hashCode()} Categories")
            heading(model.heading)
            spanSizeOverride { totalSpanCount, _, _ ->  totalSpanCount}
        }

        val catList = ArrayList<EpoxyRecyclerCategory_>()
        (model.items as ArrayList<Categories>).forEach {
            catList.add(
                EpoxyRecyclerCategory_()
                    .id(it.categoryUrl)
                    .category(it)
            )
        }

        carousel {
            id(model.hashCode())
            models(catList)
            padding(Carousel.Padding.dp(16, 8, 16, 8, 16))
            spanSizeOverride { totalSpanCount, _, _ ->  totalSpanCount}
        }
    }

    private fun buildFeaturedWallpaper(model: BrowseResponseModel) {
        epoxyBrowseView {
            id(model.heading.hashCode())
            heading(model.heading)
            spanSizeOverride { totalSpanCount, _, _ ->  totalSpanCount}
        }
        (model.items as ArrayList<Wallpapers>).forEach {
            Timber.e("WALLPAPER URL -> ${it.imageUrl}")
            epoxyFeaturedWallpaper {
                id(it.imageUrl)
                featuredWallpaper(it)
                spanSizeOverride { totalSpanCount, _, _ ->  totalSpanCount}
            }
        }
    }
}