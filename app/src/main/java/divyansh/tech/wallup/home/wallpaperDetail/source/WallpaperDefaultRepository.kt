package divyansh.tech.wallup.home.wallpaperDetail.source

import divyansh.tech.wallup.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WallpaperDefaultRepository @Inject constructor(
    private val remoteRepo: WallpaperDetailRemoteRepo
): WallpaperDetailDataSource {
    override suspend fun getWallpaperResolutionList(url: String): Flow<Result<*>> {
        return flow {
            val response = remoteRepo.getWallpaperResolutions(url)
            emit(response)
        }
    }
}