package divyansh.tech.wallup.home.browse.utils

import divyansh.tech.wallup.home.browse.datamodel.Wallpapers
import divyansh.tech.wallup.utils.Result
import timber.log.Timber

class BrowseFragmentDeserializer {
    companion object {
        fun getWallpapers(response: String): Result<String> {
//            val jsoup =
            Timber.e("RESPONSE -> $response")
            return Result.Success(response)
        }
    }
}