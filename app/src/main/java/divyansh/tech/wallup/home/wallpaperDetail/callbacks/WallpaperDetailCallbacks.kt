package divyansh.tech.wallup.home.wallpaperDetail.callbacks

import divyansh.tech.wallup.common.WallpaperCallbacks
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.home.wallpaperDetail.WallpaperDetailFragment
import divyansh.tech.wallup.home.wallpaperDetail.WallpaperDetailFragmentDirections
import divyansh.tech.wallup.home.wallpaperDetail.WallpaperDetailViewModel

class WallpaperDetailCallbacks(
    private val viewModel: WallpaperDetailViewModel
): WallpaperCallbacks {

    override fun onWallpaperClick(wallpaper: Wallpapers) {
        val action = WallpaperDetailFragmentDirections.actionWallpaperDetailFragmentSelf(wallpaper.imageUrl)
        viewModel.changeNavigation(action)
    }

}