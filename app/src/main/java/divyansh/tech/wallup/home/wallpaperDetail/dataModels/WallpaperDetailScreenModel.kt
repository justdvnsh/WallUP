package divyansh.tech.wallup.home.wallpaperDetail.dataModels

import divyansh.tech.wallup.home.browse.datamodel.Wallpapers

data class WallpaperDetailScreenModel(
    val res: ArrayList<Resolution>,
    val relatedWallpapers: ArrayList<Wallpapers>,
    val Tags: ArrayList<Tags>
)