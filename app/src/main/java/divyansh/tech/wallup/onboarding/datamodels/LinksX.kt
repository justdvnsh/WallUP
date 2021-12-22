package divyansh.tech.wallup.onboarding.datamodels


import com.google.gson.annotations.SerializedName

data class LinksX(
    @SerializedName("followers")
    val followers: String, // https://api.unsplash.com/users/mary_skr/followers
    @SerializedName("following")
    val following: String, // https://api.unsplash.com/users/mary_skr/following
    @SerializedName("html")
    val html: String, // https://unsplash.com/@mary_skr
    @SerializedName("likes")
    val likes: String, // https://api.unsplash.com/users/mary_skr/likes
    @SerializedName("photos")
    val photos: String, // https://api.unsplash.com/users/mary_skr/photos
    @SerializedName("portfolio")
    val portfolio: String, // https://api.unsplash.com/users/mary_skr/portfolio
    @SerializedName("self")
    val self: String // https://api.unsplash.com/users/mary_skr
)