package divyansh.tech.wallup.common

import divyansh.tech.wallup.home.browse.BrowseFragmentDirections
import divyansh.tech.wallup.home.browse.BrowseViewModel
import divyansh.tech.wallup.home.browse.datamodel.Categories
import divyansh.tech.wallup.home.browse.datamodel.PopularTags
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers

class BrowseCallbacks(
    private val viewModel: BrowseViewModel
): WallpaperCallbacks {

    override fun onWallpaperClick(wallpaper: Wallpapers) {
        viewModel.getWallpaperDetails(wallpaper.wallpaperUrl)
    }

    fun onFeaturedCategoriesClick(cat: Categories) {
        val action = BrowseFragmentDirections.actionBrowseFragment2ToFeaturedCategoriesFragment(cat)
        viewModel.changeNavigation(action)
    }

    fun onPopularTagsClicked(tag: PopularTags) {
        val action = BrowseFragmentDirections.actionBrowseFragment2ToPopularTagsFragment(tag)
        viewModel.changeNavigation(action)
    }
}