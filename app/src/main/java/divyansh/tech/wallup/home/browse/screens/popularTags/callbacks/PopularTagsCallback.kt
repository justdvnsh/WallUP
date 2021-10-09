package divyansh.tech.wallup.home.browse.screens.popularTags.callbacks

import divyansh.tech.wallup.common.WallpaperCallbacks
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.home.browse.screens.popularTags.PopularTagsViewModel

class PopularTagsCallback(
    private val viewModel: PopularTagsViewModel
): WallpaperCallbacks {
    override fun onWallpaperClick(wallpaper: Wallpapers) {
        viewModel.getWallpaperDetails(wallpaper.wallpaperUrl)
    }
}