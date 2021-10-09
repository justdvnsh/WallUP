package divyansh.tech.wallup.home.browse.screens.featuredCategories.callbacks

import divyansh.tech.wallup.common.WallpaperCallbacks
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.home.browse.screens.featuredCategories.FeaturedCategoriesFragment
import divyansh.tech.wallup.home.browse.screens.featuredCategories.FeaturedCategoriesFragmentDirections
import divyansh.tech.wallup.home.browse.screens.featuredCategories.FeaturedCategoriesViewModel

class FeaturedCategoryCallbacks(
    private val viewModel: FeaturedCategoriesViewModel
): WallpaperCallbacks {
    override fun onWallpaperClick(wallpaper: Wallpapers) {
        val action = FeaturedCategoriesFragmentDirections.actionFeaturedCategoriesFragmentToWallpaperDetailFragment(wallpaper.imageUrl)
        viewModel.changeNavigation(action)
    }
}