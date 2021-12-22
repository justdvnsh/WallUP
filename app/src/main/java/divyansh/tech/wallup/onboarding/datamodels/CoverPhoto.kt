package divyansh.tech.wallup.onboarding.datamodels


import com.google.gson.annotations.SerializedName

data class CoverPhoto(
    @SerializedName("alt_description")
    val altDescription: Any, // null
    @SerializedName("blur_hash")
    val blurHash: String, // L87-NG~ptRV@IVoL%2xuNHWXozxt
    @SerializedName("categories")
    val categories: List<Any>,
    @SerializedName("color")
    val color: String, // #260c0c
    @SerializedName("created_at")
    val createdAt: String, // 2021-11-30T15:17:53-05:00
    @SerializedName("current_user_collections")
    val currentUserCollections: List<Any>,
    @SerializedName("description")
    val description: Any, // null
    @SerializedName("height")
    val height: Int, // 3541
    @SerializedName("id")
    val id: String, // uluH5a0sRdw
    @SerializedName("liked_by_user")
    val likedByUser: Boolean, // false
    @SerializedName("likes")
    val likes: Int, // 82
    @SerializedName("links")
    val links: Links,
    @SerializedName("promoted_at")
    val promotedAt: String, // 2021-12-01T05:08:01-05:00
    @SerializedName("sponsorship")
    val sponsorship: Any, // 2021-12-22T04:21:51-05:00
    @SerializedName("width")
    val width: Int // 2656
)