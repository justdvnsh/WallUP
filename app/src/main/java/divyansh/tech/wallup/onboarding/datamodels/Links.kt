package divyansh.tech.wallup.onboarding.datamodels


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("download")
    val download: String, // https://unsplash.com/photos/uluH5a0sRdw/download
    @SerializedName("download_location")
    val downloadLocation: String, // https://api.unsplash.com/photos/uluH5a0sRdw/download
    @SerializedName("html")
    val html: String, // https://unsplash.com/photos/uluH5a0sRdw
    @SerializedName("self")
    val self: String // https://api.unsplash.com/photos/uluH5a0sRdw
)