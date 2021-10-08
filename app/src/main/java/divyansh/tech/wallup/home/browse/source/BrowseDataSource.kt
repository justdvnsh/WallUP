package divyansh.tech.wallup.home.browse.source

import divyansh.tech.wallup.utils.Result
import kotlinx.coroutines.flow.Flow

interface BrowseDataSource {

    suspend fun getFeaturedWallpaperAndHomePageData(): Flow<Result<*>>
    suspend fun getPopularWallpapers(): Flow<Result<*>>
    suspend fun getPopularCategories(): Flow<Result<*>>
    suspend fun getWallpaperDetails(url: String): Flow<Result<String>>
}