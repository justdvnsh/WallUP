package divyansh.tech.wallup.home.browse.source

import divyansh.tech.wallup.home.browse.datamodel.BrowseResponseModel
import divyansh.tech.wallup.utils.Constants
import divyansh.tech.wallup.utils.Result
import divyansh.tech.wallup.utils.customErrors.CouldNotParseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class BrowseDefaultRepository @Inject constructor(
    private val remoteRepo: BrowseRemoteRepository,
): BrowseDataSource {
    override suspend fun getFeaturedWallpaperAndHomePageData(): Flow<Result<*>> {
        return flow {
            emit(remoteRepo.getFeaturedWallpaperAndHomePageData())
        }
    }


    override suspend fun getPopularWallpapers(): Flow<Result<*>> {
        return flow {
            emit(remoteRepo.getPopularWallpapers())
        }
    }

    override suspend fun getPopularCategories(): Flow<Result<*>> {
        return flow {
            emit(remoteRepo.getPopularCategories())
        }
    }

    override suspend fun getWallpaperDetails(url: String): Flow<Result<String>> {
        return flow {
            val response = remoteRepo.getWallpaperDetail(Constants.BASE_URL + url)
            if (response is Result.Success) {
                val url = remoteRepo.getWallpaperDownloadUrl(response.data)
                Timber.e("URL FROM DEFAULT -> $url")
                if (url is Result.Success) {
                    emit(Result.Success(url.data.link))
                } else emit(Result.Error(CouldNotParseException("Something went wrong")))
            } else emit(Result.Error(CouldNotParseException("Something went wrong")))
        }
    }
}