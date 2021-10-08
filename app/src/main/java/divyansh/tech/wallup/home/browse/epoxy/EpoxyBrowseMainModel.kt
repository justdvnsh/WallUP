package divyansh.tech.wallup.home.browse.epoxy

import android.annotation.SuppressLint
import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import divyansh.tech.wallup.BR

import divyansh.tech.wallup.R
import divyansh.tech.wallup.common.BrowseCallbacks
import divyansh.tech.wallup.common.WallpaperCallbacks
import divyansh.tech.wallup.home.browse.datamodel.Categories
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.recycler_popular_wallpaper_item)
abstract class EpoxyWallpapers(): DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var wallpaper: Wallpapers

    @EpoxyAttribute
    lateinit var callback: WallpaperCallbacks

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(BR.wallpaper, wallpaper)
        binding.setVariable(BR.callback, callback)
    }
}

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.recycler_browse_view)
abstract class EpoxyBrowseView(): DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var heading: String

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(BR.heading, heading)
    }
}

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.recycler_category_item)
abstract class EpoxyRecyclerCategory(): DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var category: Categories

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(BR.category, category)
    }
}

@EpoxyModelClass(layout = R.layout.recycler_item_featured_wallpaper)
abstract class EpoxyFeaturedWallpaper(): DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var featuredWallpaper: Wallpapers

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(BR.featuredWallpaper, featuredWallpaper)
    }
}

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.recycler_recommended_item)
abstract class EpoxyRecommendedCategory(): DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var imageUrl: Integer

    @EpoxyAttribute
    lateinit var heading: String

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(BR.imageUrl, imageUrl)
        binding.setVariable(BR.heading, heading)
    }
}