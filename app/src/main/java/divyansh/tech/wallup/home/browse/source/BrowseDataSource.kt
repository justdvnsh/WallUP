package divyansh.tech.wallup.home.browse.source

import divyansh.tech.wallup.utils.Result
import kotlinx.coroutines.flow.Flow

interface BrowseDataSource {

    suspend fun getPopularWallpapers(): Flow<Result<*>>
    suspend fun getCategories(): Flow<Result<*>>
    suspend fun getRecommended(): Flow<Result<*>>
}