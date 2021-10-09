package divyansh.tech.wallup.home.browse.screens.featuredCategories.source

import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FeaturedCategoriesDefaultRepo @Inject constructor(
    private val remoteRepo: FeaturedCategoriesRemoteRepo
): FeaturedCategoriesDataSource{

    override suspend fun getWallpapers(url: String): Flow<Result<ArrayList<Wallpapers>>> {
        return flow {
            emit(remoteRepo.getWallpapers(url))
        }
    }
}