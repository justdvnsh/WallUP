package divyansh.tech.wallup.home.browse.source

import divyansh.tech.wallup.utils.Result
import javax.inject.Inject

class BrowseDefaultRepository @Inject constructor(
    private val remoteRepo: BrowseRemoteRepository,
    private val localRepo: BrowseLocalRepository
): BrowseDataSource {

    override suspend fun getPopularWallpapers(): Result<*> {
        return remoteRepo.getPopularWallpapers()
    }
}