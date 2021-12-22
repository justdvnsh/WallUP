package divyansh.tech.wallup.onboarding.datamodels


import com.google.gson.annotations.SerializedName

data class Social(
    @SerializedName("instagram_username")
    val instagramUsername: String, // skrynnikova_mary
    @SerializedName("paypal_email")
    val paypalEmail: Any, // null
    @SerializedName("portfolio_url")
    val portfolioUrl: Any, // null
    @SerializedName("twitter_username")
    val twitterUsername: Any // null
)