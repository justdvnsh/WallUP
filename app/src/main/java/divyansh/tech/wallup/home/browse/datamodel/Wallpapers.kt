package divyansh.tech.wallup.home.browse.datamodel

import divyansh.tech.wallup.home.browse.BrowseViewModel

data class Wallpapers(
    val wallpaperUrl: String,
    val imageUrl: String,
    val dataSet: String
)

data class Categories(
    val name: String,
    val asset: Int
)

data class Colors(
    val color: Int
)

data class BrowseResponseModel(
    val heading: String,
    val type: BrowseViewModel.HOME_TYPES,
    val items: ArrayList<*>
)
