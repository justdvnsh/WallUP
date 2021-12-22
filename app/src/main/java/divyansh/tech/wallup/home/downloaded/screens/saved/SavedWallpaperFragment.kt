package divyansh.tech.wallup.home.downloaded.screens.saved

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.databinding.FragmentSavedWallpaperBinding

@AndroidEntryPoint
class SavedWallpaperFragment : Fragment() {

    companion object {
        fun getInstance() = SavedWallpaperFragment()
    }

    private lateinit var _binding:FragmentSavedWallpaperBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentSavedWallpaperBinding.inflate(inflater,container,false)
        return _binding.root
    }

}