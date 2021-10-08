package divyansh.tech.wallup.home.browse.datamodel

data class WallpaperUrlRequestBody(
    val content_id: Int,
    val content_type: String = "wallpaper",
    val file_type: String,
    val image_server: String
)