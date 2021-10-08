package divyansh.tech.wallup.home.wallpaperDetail.epoxy

import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.airbnb.epoxy.group
import divyansh.tech.wallup.R
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.home.browse.epoxy.EpoxyWallpapers_
import divyansh.tech.wallup.home.wallpaperDetail.callbacks.WallpaperDetailCallbacks
import divyansh.tech.wallup.home.wallpaperDetail.dataModels.Tags
import divyansh.tech.wallup.home.wallpaperDetail.dataModels.WallpaperDetailScreenModel

class EpoxyWallpaperDetailController(
    private val wallpaperClickCallback: WallpaperDetailCallbacks
): TypedEpoxyController<WallpaperDetailScreenModel>() {
    override fun buildModels(data: WallpaperDetailScreenModel?) {
        data?.let {
//            epoxyHeadingItem {
//                id(it.hashCode())
//                heading("Tags")
//                spanSizeOverride { totalSpanCount, _,_ ->  totalSpanCount}
//            }
//            val tagList = ArrayList<EpoxyTagItemModel_>()
//            it.Tags.forEach {
//                tagList.add(
//                    EpoxyTagItemModel_()
//                        .id(it.hashCode())
//                        .tag(it)
//                )
//            }
//
//            group {
//                id("tags_group")
//                layout(R.layout.recycler_category_background)
//                add(
//                    CategoryBackgroundModel_()
//                        .id(it.hashCode())
//                        .models(tagList)
//                        .padding(Carousel.Padding.dp(16, 18, 16, 0, 8))
//                )
//            }
//
//            epoxyHeadingItem {
//                id(" ${it.hashCode()} + RESOLUTION")
//                heading("Resolutions Available")
//                spanSizeOverride { totalSpanCount, _,_ ->  totalSpanCount}
//            }
//
//            val resList = ArrayList<EpoxyResolutionItemModel_>()
//            it.res.forEach {
//                resList.add(
//                    EpoxyResolutionItemModel_()
//                        .id(it.hashCode())
//                        .resolution(it)
//                        .spanSizeOverride { totalSpanCount, _,_ ->  totalSpanCount/3}
//                )
//            }
//
//            group {
//                id("resolution_group")
//                layout(R.layout.recycler_category_background)
//                add(
//                    CategoryBackgroundModel_()
//                        .id(it.hashCode())
//                        .models(resList)
//                        .padding(Carousel.Padding.dp(16, 18, 16, 0, 8))
//                )
//            }
//
//            epoxyHeadingItem {
//                id(" ${it.hashCode()} + Wallpapers")
//                heading("Related Wallpapers")
//                spanSizeOverride { totalSpanCount, _,_ ->  totalSpanCount}
//            }
//
//            val wallList = ArrayList<EpoxyWallpapers_>()
//            it.relatedWallpapers.forEach {
//                wallList.add(
//                    EpoxyWallpapers_()
//                        .id(it.hashCode())
//                        .wallpaper(it)
//                        .callback(wallpaperClickCallback)
//                        .spanSizeOverride { totalSpanCount, _, _ ->  totalSpanCount/3}
//                )
//            }
//
//            carousel {
//                id(it.hashCode())
//                models(wallList)
//                padding(Carousel.Padding.dp(16, 8, 16, 8, 16))
//                spanSizeOverride { totalSpanCount, _, _ ->  totalSpanCount}
//            }
//        }
        }

    }}