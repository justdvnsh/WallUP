package divyansh.tech.wallup.home.browse.screens.popularTags.source

import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.utils.Result
import kotlinx.coroutines.flow.Flow

interface PopularTagsDataSource {
    suspend fun getWallpapers(url: String): Flow<Result<ArrayList<Wallpapers>>>
}