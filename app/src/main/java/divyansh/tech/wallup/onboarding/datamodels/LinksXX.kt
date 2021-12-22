package divyansh.tech.wallup.onboarding.datamodels


import com.google.gson.annotations.SerializedName

data class LinksXX(
    @SerializedName("html")
    val html: String, // https://unsplash.com/t/fashion
    @SerializedName("photos")
    val photos: String, // https://api.unsplash.com/topics/fashion/photos
    @SerializedName("self")
    val self: String // https://api.unsplash.com/topics/fashion
)