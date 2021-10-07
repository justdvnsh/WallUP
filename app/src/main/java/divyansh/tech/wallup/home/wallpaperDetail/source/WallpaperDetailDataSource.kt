package divyansh.tech.wallup.home.wallpaperDetail.source

import divyansh.tech.wallup.utils.Result
import kotlinx.coroutines.flow.Flow

interface WallpaperDetailDataSource {

    suspend fun getWallpaperResolutionList(url: String): Flow<Result<*>>
}