package divyansh.tech.wallup.onboarding.datamodels


import com.google.gson.annotations.SerializedName

data class TopicSubmissions(
    @SerializedName("fashion")
    val fashion: Fashion
)