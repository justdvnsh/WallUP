package divyansh.tech.wallup.onboarding.datamodels


import com.google.gson.annotations.SerializedName

data class PreviewPhoto(
    @SerializedName("blur_hash")
    val blurHash: String, // L87-NG~ptRV@IVoL%2xuNHWXozxt
    @SerializedName("created_at")
    val createdAt: String, // 2021-11-30T15:17:53-05:00
    @SerializedName("id")
    val id: String, // uluH5a0sRdw
    @SerializedName("updated_at")
    val updatedAt: String, // 2021-12-22T04:21:51-05:00
    @SerializedName("urls")
    val urls: UrlsX
)