package divyansh.tech.wallup.common

import divyansh.tech.wallup.home.browse.datamodel.Wallpapers

interface WallpaperCallbacks {
    fun onWallpaperClick(wallpaper: Wallpapers)
}