package divyansh.tech.wallup.home.browse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.databinding.FragmentBrowseBinding
import timber.log.Timber

@AndroidEntryPoint
class BrowseFragment: Fragment() {
    private lateinit var _binding: FragmentBrowseBinding

    private val viewModel by viewModels<BrowseViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBrowseBinding.inflate(inflater, container, false)
        Timber.e("INSIDE OBSERVERS -> ${viewModel.toString()}")
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Timber.e("INSIDE OBSERVERS -> ${viewModel.toString()}")
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        Timber.e("INSIDE OBSERVERS -> ${viewModel.toString()}")
        viewModel.popularWallpapersLiveData.observe(viewLifecycleOwner, Observer {
            Timber.i("WALLPAPERS -> ${it.toString()}")
            _binding.resposne.text = it
        })
    }
}