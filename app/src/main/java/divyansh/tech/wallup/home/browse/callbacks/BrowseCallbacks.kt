package divyansh.tech.wallup.home.browse.callbacks

import divyansh.tech.wallup.home.browse.BrowseFragmentDirections
import divyansh.tech.wallup.home.browse.BrowseViewModel

class BrowseCallbacks(
    private val viewModel: BrowseViewModel
) {

    fun onWallpaperClick(imageUrl: String) {
        val action = BrowseFragmentDirections.actionBrowseFragment2ToWallpaperActivity(imageUrl)
        viewModel.changeNavigation(action)
    }
}