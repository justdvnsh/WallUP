package divyansh.tech.wallup.home.browse.screens.popularTags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.common.CommonFragment
import divyansh.tech.wallup.common.CommonViewModel
import divyansh.tech.wallup.databinding.FragmentPopularTagsBinding
import divyansh.tech.wallup.home.browse.screens.popularTags.callbacks.PopularTagsCallback
import divyansh.tech.wallup.home.browse.screens.popularTags.epoxy.EpoxyPopularTagsController
import divyansh.tech.wallup.utils.EventObserver

@AndroidEntryPoint
class PopularTagsFragment : CommonFragment() {

    private lateinit var _binding: FragmentPopularTagsBinding
    val binding get() = _binding

    private val args by navArgs<PopularTagsFragmentArgs>()

    private val viewModel by viewModels<PopularTagsViewModel>()

    private val controller by lazy {
        EpoxyPopularTagsController(PopularTagsCallback(viewModel))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPopularTagsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    override fun getCommonViewModel(): CommonViewModel = viewModel

    private fun setupRecyclerView() {
        binding.popularTagsRv.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = controller.adapter
        }
    }

    private fun setupObservers() {
        viewModel.popularTagsWallpaperLiveData.observe(
            viewLifecycleOwner,
            Observer {
                controller.setData(it)
            }
        )

        viewModel.navigation.observe(
            viewLifecycleOwner,
            EventObserver {
                findNavController().navigate(it)
            }
        )
    }

    override fun onResume() {
        super.onResume()
        viewModel.getWallpapers(args.tag.url)
    }
}