package divyansh.tech.wallup.home.browse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.common.BrowseCallbacks
import divyansh.tech.wallup.common.CommonFragment
import divyansh.tech.wallup.common.CommonViewModel
import divyansh.tech.wallup.databinding.FragmentBrowseBinding
import divyansh.tech.wallup.home.browse.epoxy.EpoxyBrowseController
import divyansh.tech.wallup.utils.EventObserver
import timber.log.Timber

@AndroidEntryPoint
class BrowseFragment : CommonFragment() {

    private lateinit var _binding: FragmentBrowseBinding

    private val viewModel by viewModels<BrowseViewModel>()

    private val browseController by lazy {
        val callback = BrowseCallbacks(viewModel)
        EpoxyBrowseController(callback)
    }

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
        setupListeners()
        setupRecyclerView()
        setupObservers()
    }

    override fun getCommonViewModel(): CommonViewModel = viewModel

    private fun setupListeners() {
        _binding.search.setOnClickListener {
            val action = BrowseFragmentDirections.actionBrowseFragment2ToSearchFragment()
            viewModel.changeNavigation(action)
        }
    }

    private fun setupRecyclerView() {
        _binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            (layoutManager as GridLayoutManager).spanSizeLookup = browseController.spanSizeLookup
            adapter = browseController.adapter
            browseController.spanCount = 2
        }
    }

    private fun setupObservers() {
        Timber.e("INSIDE OBSERVERS -> ${viewModel.toString()}")
        viewModel.popularWallpapersLiveData.observe(viewLifecycleOwner, Observer {
            Timber.e("DATA -> $it")
            browseController.setData(it)
        })

        viewModel.navigation.observe(
            viewLifecycleOwner,
            EventObserver {
                findNavController().navigate(it)
            }
        )
    }
}