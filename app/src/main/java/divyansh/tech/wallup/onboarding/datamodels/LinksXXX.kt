package divyansh.tech.wallup.onboarding.datamodels


import com.google.gson.annotations.SerializedName

data class LinksXXX(
    @SerializedName("followers")
    val followers: String, // https://api.unsplash.com/users/unsplash/followers
    @SerializedName("following")
    val following: String, // https://api.unsplash.com/users/unsplash/following
    @SerializedName("html")
    val html: String, // https://unsplash.com/@unsplash
    @SerializedName("likes")
    val likes: String, // https://api.unsplash.com/users/unsplash/likes
    @SerializedName("photos")
    val photos: String, // https://api.unsplash.com/users/unsplash/photos
    @SerializedName("portfolio")
    val portfolio: String, // https://api.unsplash.com/users/unsplash/portfolio
    @SerializedName("self")
    val self: String // https://api.unsplash.com/users/unsplash
)