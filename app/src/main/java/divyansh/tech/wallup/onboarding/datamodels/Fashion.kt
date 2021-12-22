package divyansh.tech.wallup.onboarding.datamodels


import com.google.gson.annotations.SerializedName

data class Fashion(
    @SerializedName("approved_on")
    val approvedOn: String, // 2021-12-21T15:45:50-05:00
    @SerializedName("status")
    val status: String // approved
)