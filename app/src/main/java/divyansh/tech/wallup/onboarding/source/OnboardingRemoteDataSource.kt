package divyansh.tech.wallup.onboarding.source

import divyansh.tech.wallup.onboarding.datamodels.Topics
import divyansh.tech.wallup.utils.Result
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.*
import timber.log.Timber
import javax.inject.Inject

class OnboardingRemoteDataSource @Inject constructor(
    retrofit: Retrofit
) {

    private val service = retrofit.create(OnBoardingInterface::class.java)

    suspend fun getTopics(): Result<Topics> {
        Timber.e("REMOTE REPO -> INSIDE REMOTE REPO")
        return try {
            val response = service.gettopic()
            Timber.e("REMOTE REPO -> $response")
            if (response.isSuccessful && response.body() != null)
                Result.Success(response.body() as Topics)
            else Result.Error(Exception("Something went wrong"))
        } catch (e: Exception) {
            Timber.e("${e.localizedMessage}")
            Result.Error(Exception("SOEMTHIGN WENT WRONG"))
        }
    }

    interface OnBoardingInterface {
        @GET("topics/")
        suspend fun gettopic(
            @Query("client_id") id: String = "tuoo-XRYx3ZcmVM4nfYt6CclnmRO8jZBlyU2CCh6uWg"
        ): Response<Topics>
    }
}