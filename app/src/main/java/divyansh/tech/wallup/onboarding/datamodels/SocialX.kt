package divyansh.tech.wallup.onboarding.datamodels


import com.google.gson.annotations.SerializedName

data class SocialX(
    @SerializedName("instagram_username")
    val instagramUsername: String, // unsplash
    @SerializedName("paypal_email")
    val paypalEmail: Any, // null
    @SerializedName("portfolio_url")
    val portfolioUrl: String, // https://unsplash.com
    @SerializedName("twitter_username")
    val twitterUsername: String // unsplash
)