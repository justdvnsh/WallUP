package divyansh.tech.wallup.onboarding.datamodels


import com.google.gson.annotations.SerializedName

data class TopicsItem(
    @SerializedName("cover_photo")
    val coverPhoto: CoverPhoto,
    @SerializedName("description")
    val description: String, // From street-style shots to editorial photography — find the latest trends in beauty and fashion.
    @SerializedName("featured")
    val featured: Boolean, // true
    @SerializedName("id")
    val id: String, // S4MKLAsBB74
    @SerializedName("links")
    val links: LinksXX,
    @SerializedName("preview_photos")
    val previewPhotos: List<PreviewPhoto>,
    @SerializedName("slug")
    val slug: String, // fashion
    @SerializedName("title")
    val title: String, // Fashion
    @SerializedName("total_photos")
    val totalPhotos: Int, // 6820
)