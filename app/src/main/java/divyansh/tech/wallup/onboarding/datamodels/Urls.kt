package divyansh.tech.wallup.onboarding.datamodels


import com.google.gson.annotations.SerializedName

data class Urls(
    @SerializedName("full")
    val full: String, // https://images.unsplash.com/photo-1638303322580-5e6aacd59c0d?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb
    @SerializedName("raw")
    val raw: String, // https://images.unsplash.com/photo-1638303322580-5e6aacd59c0d?ixlib=rb-1.2.1
    @SerializedName("regular")
    val regular: String, // https://images.unsplash.com/photo-1638303322580-5e6aacd59c0d?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max
    @SerializedName("small")
    val small: String, // https://images.unsplash.com/photo-1638303322580-5e6aacd59c0d?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max
    @SerializedName("thumb")
    val thumb: String // https://images.unsplash.com/photo-1638303322580-5e6aacd59c0d?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max
)