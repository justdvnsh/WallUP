package divyansh.tech.wallup.common

import divyansh.tech.wallup.home.browse.BrowseFragmentDirections
import divyansh.tech.wallup.home.browse.BrowseViewModel
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers

class BrowseCallbacks(
    private val viewModel: BrowseViewModel
): WallpaperCallbacks {

    override fun onWallpaperClick(wallpaper: Wallpapers) {
        viewModel.getWallpaperDetails(wallpaper.wallpaperUrl)
    }
}