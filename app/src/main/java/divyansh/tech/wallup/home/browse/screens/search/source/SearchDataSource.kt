package divyansh.tech.wallup.home.browse.screens.search.source

import divyansh.tech.wallup.home.browse.screens.search.dataModel.SearchScreenModel
import divyansh.tech.wallup.utils.Result
import kotlinx.coroutines.flow.Flow

interface SearchDataSource {
    suspend fun searchWallpapers(query: String): Flow<Result<SearchScreenModel>>
}