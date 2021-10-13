package divyansh.tech.wallup.home.browse.screens.search.callbacks

import divyansh.tech.wallup.common.WallpaperCallbacks
import divyansh.tech.wallup.home.browse.BrowseFragmentDirections
import divyansh.tech.wallup.home.browse.datamodel.Categories
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.home.browse.screens.search.SearchFragment
import divyansh.tech.wallup.home.browse.screens.search.SearchFragmentDirections
import divyansh.tech.wallup.home.browse.screens.search.SearchViewModel

class SearchCallbacks(
    private val viewModel: SearchViewModel
): WallpaperCallbacks{
    override fun onWallpaperClick(wallpaper: Wallpapers) {
        viewModel.getWallpaperDetails(wallpaper.wallpaperUrl)
    }

    override fun onFeaturedCategoriesClick(cat: Categories) {
        val action = SearchFragmentDirections.actionSearchFragmentToFeaturedCategoriesFragment(cat)
        viewModel.changeNavigation(action)
    }
}