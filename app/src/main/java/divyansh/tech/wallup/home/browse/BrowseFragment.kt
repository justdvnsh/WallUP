package divyansh.tech.wallup.home.browse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.databinding.FragmentBrowseBinding
import divyansh.tech.wallup.home.browse.epoxy.EpoxyBrowseController
import timber.log.Timber

@AndroidEntryPoint
class BrowseFragment: Fragment() {
    private lateinit var _binding: FragmentBrowseBinding

    private val viewModel by viewModels<BrowseViewModel>()

    private val browseController = EpoxyBrowseController()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBrowseBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        _binding.browseViewRv.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = browseController.adapter
            browseController.spanCount = 2
            (layoutManager as GridLayoutManager).spanSizeLookup =
                browseController.spanSizeLookup
        }
    }

    private fun setupObservers() {
        Timber.e("INSIDE OBSERVERS -> ${viewModel.toString()}")
        viewModel.popularWallpapersLiveData.observe(viewLifecycleOwner, Observer {
            browseController.setData(it)
        })
    }
}