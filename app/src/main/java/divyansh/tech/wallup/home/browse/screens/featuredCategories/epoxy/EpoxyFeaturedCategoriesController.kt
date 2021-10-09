package divyansh.tech.wallup.home.browse.screens.featuredCategories.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.home.browse.epoxy.epoxyWallpapers
import divyansh.tech.wallup.home.browse.screens.featuredCategories.callbacks.FeaturedCategoryCallbacks

class EpoxyFeaturedCategoriesController(
    private val callback: FeaturedCategoryCallbacks
): TypedEpoxyController<ArrayList<Wallpapers>>(){
    override fun buildModels(data: ArrayList<Wallpapers>?) {
        data?.let {
            it.forEach {
                epoxyWallpapers {
                    id(it.imageUrl)
                    wallpaper(it)
                    callback(callback)
                }
            }
        }
    }
}