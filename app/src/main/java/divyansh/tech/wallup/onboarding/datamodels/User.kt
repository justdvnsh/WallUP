package divyansh.tech.wallup.onboarding.datamodels


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("accepted_tos")
    val acceptedTos: Boolean, // true
    @SerializedName("bio")
    val bio: Any, // null
    @SerializedName("first_name")
    val firstName: String, // Mary Skrynnikova
    @SerializedName("for_hire")
    val forHire: Boolean, // false
    @SerializedName("id")
    val id: String, // dTF4_V_Bnvc
    @SerializedName("instagram_username")
    val instagramUsername: String, // skrynnikova_mary
    @SerializedName("last_name")
    val lastName: Any, // null
    @SerializedName("links")
    val links: LinksX,
    @SerializedName("location")
    val location: String, // Dublin, Ireland
    @SerializedName("name")
    val name: String, // Mary Skrynnikova
    @SerializedName("portfolio_url")
    val portfolioUrl: Any, // null
    @SerializedName("profile_image")
    val profileImage: ProfileImage,
    @SerializedName("social")
    val social: Social,
    @SerializedName("total_collections")
    val totalCollections: Int, // 0
    @SerializedName("total_likes")
    val totalLikes: Int, // 22
    @SerializedName("total_photos")
    val totalPhotos: Int, // 91
    @SerializedName("twitter_username")
    val twitterUsername: Any, // null
    @SerializedName("updated_at")
    val updatedAt: String, // 2021-12-22T09:03:44-05:00
    @SerializedName("username")
    val username: String // mary_skr
)