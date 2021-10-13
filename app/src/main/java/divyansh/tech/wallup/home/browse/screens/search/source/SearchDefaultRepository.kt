package divyansh.tech.wallup.home.browse.screens.search.source

import divyansh.tech.wallup.home.browse.screens.search.dataModel.SearchScreenModel
import divyansh.tech.wallup.utils.Result
import divyansh.tech.wallup.utils.customErrors.CouldNotParseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchDefaultRepository @Inject constructor(
    private val remoteRepo: SearchRemoteRepository
): SearchDataSource{
    override suspend fun searchWallpapers(query: String): Flow<Result<SearchScreenModel>> {
        return flow {
            val responseSourceTwo = remoteRepo.getWallpapersFromSourceTwo(query)
            val responseSourceOne = remoteRepo.getWallpapersFromSourceOne(query)
            if (responseSourceTwo is Result.Success) {
                if (responseSourceOne is Result.Success) {
                    emit(Result.Success(
                        SearchScreenModel(
                            categories = responseSourceTwo.data,
                            wallpapers = responseSourceOne.data
                        )
                    ))
                } else emit(Result.Error(CouldNotParseException("Something Went wrong")))
            } else emit(Result.Error(CouldNotParseException("Something Went wrong")))
        }
    }
}