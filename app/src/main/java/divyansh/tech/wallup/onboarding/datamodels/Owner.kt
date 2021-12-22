package divyansh.tech.wallup.onboarding.datamodels


import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("accepted_tos")
    val acceptedTos: Boolean, // true
    @SerializedName("bio")
    val bio: String, // Behind the scenes of the team building the internet’s open library of freely useable visuals.
    @SerializedName("first_name")
    val firstName: String, // Unsplash
    @SerializedName("for_hire")
    val forHire: Boolean, // false
    @SerializedName("id")
    val id: String, // QV5S1rtoUJ0
    @SerializedName("instagram_username")
    val instagramUsername: String, // unsplash
    @SerializedName("last_name")
    val lastName: Any, // null
    @SerializedName("links")
    val links: LinksXXX,
    @SerializedName("location")
    val location: String, // Montreal, Canada
    @SerializedName("name")
    val name: String, // Unsplash
    @SerializedName("portfolio_url")
    val portfolioUrl: String, // https://unsplash.com
    @SerializedName("profile_image")
    val profileImage: ProfileImageX,
    @SerializedName("social")
    val social: SocialX,
    @SerializedName("total_collections")
    val totalCollections: Int, // 7
    @SerializedName("total_likes")
    val totalLikes: Int, // 16218
    @SerializedName("total_photos")
    val totalPhotos: Int, // 29
    @SerializedName("twitter_username")
    val twitterUsername: String, // unsplash
    @SerializedName("updated_at")
    val updatedAt: String, // 2021-12-22T09:13:44-05:00
    @SerializedName("username")
    val username: String // unsplash
)