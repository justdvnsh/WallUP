package divyansh.tech.wallup.home.browse.screens.popularTags.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.home.browse.epoxy.epoxyWallpapers
import divyansh.tech.wallup.home.browse.screens.popularTags.callbacks.PopularTagsCallback

class EpoxyPopularTagsController(
    private val callbacks: PopularTagsCallback
): TypedEpoxyController<ArrayList<Wallpapers>>() {
    override fun buildModels(data: ArrayList<Wallpapers>?) {
        data?.let {
            it.forEach {
                epoxyWallpapers {
                    id(it.imageUrl)
                    wallpaper(it)
                    callback(callbacks)
                }
            }
        }
    }
}