package divyansh.tech.wallup.home.wallpaperDetail.epoxy

import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.home.browse.epoxy.EpoxyWallpapers_
import divyansh.tech.wallup.home.wallpaperDetail.dataModels.WallpaperDetailScreenModel

class EpoxyWallpaperDetailController(): TypedEpoxyController<WallpaperDetailScreenModel>() {
    override fun buildModels(data: WallpaperDetailScreenModel?) {
        data?.let {
            epoxyHeadingItem {
                id(it.hashCode())
                heading("Tags")
                spanSizeOverride { totalSpanCount, _,_ ->  totalSpanCount}
            }
            it.Tags.forEach {
                epoxyTagItem {
                    id(it.hashCode())
                    tag(it)
                    spanSizeOverride { totalSpanCount, _,_ ->  totalSpanCount/3}
                }
            }

            epoxyHeadingItem {
                id(" ${it.hashCode()} + RESOLUTION")
                heading("Resolutions Available")
                spanSizeOverride { totalSpanCount, _,_ ->  totalSpanCount}
            }

            val resList = ArrayList<EpoxyResolutionItemModel_>()
            it.res.forEach {
                resList.add(
                    EpoxyResolutionItemModel_()
                        .id(it.hashCode())
                        .resolution(it)
                        .spanSizeOverride { totalSpanCount, _,_ ->  totalSpanCount/3}
                )
            }

            carousel {
                id(it.hashCode())
                models(resList)
                padding(Carousel.Padding.dp(16, 8, 16, 8, 16))
                spanSizeOverride { totalSpanCount, _, _ ->  totalSpanCount}
            }

            epoxyHeadingItem {
                id(" ${it.hashCode()} + Wallpapers")
                heading("Related Wallpapers")
                spanSizeOverride { totalSpanCount, _,_ ->  totalSpanCount}
            }

            val wallList = ArrayList<EpoxyWallpapers_>()
            it.relatedWallpapers.forEach {
                wallList.add(
                    EpoxyWallpapers_()
                        .id(it.hashCode())
                        .wallpaper(it)
                        .spanSizeOverride { totalSpanCount, _, _ ->  totalSpanCount/3}
                )
            }

            carousel {
                id(it.hashCode())
                models(wallList)
                padding(Carousel.Padding.dp(16, 8, 16, 8, 16))
                spanSizeOverride { totalSpanCount, _, _ ->  totalSpanCount}
            }
        }
    }
}