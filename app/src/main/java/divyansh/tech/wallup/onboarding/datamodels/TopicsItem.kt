package divyansh.tech.wallup.onboarding.datamodels


import com.google.gson.annotations.SerializedName

data class TopicsItem(
    @SerializedName("cover_photo")
    val coverPhoto: CoverPhoto,
    @SerializedName("current_user_contributions")
    val currentUserContributions: List<Any>,
    @SerializedName("description")
    val description: String, // From street-style shots to editorial photography — find the latest trends in beauty and fashion.
    @SerializedName("ends_at")
    val endsAt: String, // 2022-02-08T23:59:59Z
    @SerializedName("featured")
    val featured: Boolean, // true
    @SerializedName("id")
    val id: String, // S4MKLAsBB74
    @SerializedName("links")
    val links: LinksXX,
    @SerializedName("only_submissions_after")
    val onlySubmissionsAfter: Any, // null
    @SerializedName("owners")
    val owners: List<Owner>,
    @SerializedName("preview_photos")
    val previewPhotos: List<PreviewPhoto>,
    @SerializedName("published_at")
    val publishedAt: String, // 2020-04-06T10:20:18-04:00
    @SerializedName("slug")
    val slug: String, // fashion
    @SerializedName("starts_at")
    val startsAt: String, // 2020-04-15T00:00:00Z
    @SerializedName("status")
    val status: String, // open
    @SerializedName("title")
    val title: String, // Fashion
    @SerializedName("total_current_user_submissions")
    val totalCurrentUserSubmissions: Any, // null
    @SerializedName("total_photos")
    val totalPhotos: Int, // 6820
    @SerializedName("updated_at")
    val updatedAt: String // 2021-12-21T15:45:53-05:00
)