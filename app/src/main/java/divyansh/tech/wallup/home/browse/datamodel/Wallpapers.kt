package divyansh.tech.wallup.home.browse.datamodel

import androidx.room.Entity
import androidx.room.PrimaryKey
import divyansh.tech.wallup.home.browse.BrowseViewModel
import java.io.Serializable

data class Wallpapers(
    val wallpaperUrl: String,
    val imageUrl: String
): Serializable

@Entity(tableName = "wallpapers")
data class OfflineWallpapers(
    @PrimaryKey(autoGenerate = false)
    val url: String
)

data class Categories(
    val name: String,
    val imageUrl: String,
    val categoryUrl: String,
    val noOfWallpapers: String
): Serializable

data class PopularTags(
    val name: String,
    val url: String,
    val noOfWallpapers: String
): Serializable

data class Colors(
    val color: Int
)

data class BrowseResponseModel(
    val heading: String,
    val type: BrowseViewModel.HOME_TYPES,
    val items: ArrayList<*>
)
