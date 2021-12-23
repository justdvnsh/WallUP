package divyansh.tech.wallup.onboarding.datamodels


import com.google.gson.annotations.SerializedName

data class CoverPhoto(
    @SerializedName("categories")
    val categories: List<Any>,
    @SerializedName("color")
    val color: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("likes")
    val likes: Int, // 82
    @SerializedName("links")
    val links: Links
)