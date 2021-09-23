package divyansh.tech.wallup.home.downloaded

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.databinding.FragmentDownloadedBinding

@AndroidEntryPoint
class DownloadedFragment: Fragment() {
    private lateinit var _binding: FragmentDownloadedBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDownloadedBinding.inflate(inflater, container, false)
        return _binding.root
    }
}