package divyansh.tech.wallup.home.browse.screens.popularTags.source

import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PopularTagsDefaultRepo @Inject constructor(
    private val repo: PopularTagsRemoteRepo
): PopularTagsDataSource {
    override suspend fun getWallpapers(url: String): Flow<Result<ArrayList<Wallpapers>>> {
        return flow {
            emit(repo.getWallpapers(url))
        }
    }
}