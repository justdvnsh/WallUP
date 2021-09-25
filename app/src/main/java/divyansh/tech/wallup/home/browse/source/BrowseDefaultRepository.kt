package divyansh.tech.wallup.home.browse.source

import divyansh.tech.wallup.home.browse.datamodel.BrowseResponseModel
import divyansh.tech.wallup.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BrowseDefaultRepository @Inject constructor(
    private val remoteRepo: BrowseRemoteRepository,
    private val localRepo: BrowseLocalRepository
): BrowseDataSource {

    override suspend fun getPopularWallpapers(): Flow<Result<*>> {
        return flow {
            emit(remoteRepo.getPopularWallpapers())
        }
    }

    override suspend fun getCategories(): Flow<Result<*>> {
        return flow {
            emit(localRepo.getAllCategories())
        }
    }

    override suspend fun getRecommended(): Flow<Result<*>> {
        return flow {
            emit(localRepo.getAllRecommended())
        }
    }
}