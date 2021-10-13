package divyansh.tech.wallup.home.browse.screens.search.dataModel

import divyansh.tech.wallup.home.browse.datamodel.Categories
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers

data class SearchScreenModel(
    val categories: ArrayList<Categories>,
    val wallpapers: ArrayList<Wallpapers>
)