package divyansh.tech.wallup.home.browse.source

import divyansh.tech.wallup.utils.Result

interface BrowseDataSource {

    suspend fun getPopularWallpapers(): Result<*>
}