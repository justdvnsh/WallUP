package divyansh.tech.wallup.home.downloaded.screens.downloaded

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.databinding.FragmentDownloadedWallpaperBinding

@AndroidEntryPoint
class DownloadedWallpaperFragment : Fragment() {

    companion object {
        fun getInstance()= DownloadedWallpaperFragment()
    }

    private lateinit var _binding : FragmentDownloadedWallpaperBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentDownloadedWallpaperBinding.inflate(inflater,container,false)
        return _binding.root
    }

}