package divyansh.tech.wallup.onboarding.datamodels


import com.google.gson.annotations.SerializedName

data class ProfileImageX(
    @SerializedName("large")
    val large: String, // https://images.unsplash.com/profile-1544707963613-16baf868f301?ixlib=rb-1.2.1&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128
    @SerializedName("medium")
    val medium: String, // https://images.unsplash.com/profile-1544707963613-16baf868f301?ixlib=rb-1.2.1&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64
    @SerializedName("small")
    val small: String // https://images.unsplash.com/profile-1544707963613-16baf868f301?ixlib=rb-1.2.1&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32
)