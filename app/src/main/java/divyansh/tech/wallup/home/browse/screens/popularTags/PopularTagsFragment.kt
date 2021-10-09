package divyansh.tech.wallup.home.browse.screens.popularTags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.common.BrowseCallbacks
import divyansh.tech.wallup.databinding.FragmentPopularTagsBinding
import divyansh.tech.wallup.home.browse.BrowseViewModel
import divyansh.tech.wallup.home.browse.screens.popularTags.callbacks.PopularTagsCallback
import divyansh.tech.wallup.home.browse.screens.popularTags.epoxy.EpoxyPopularTagsController
import divyansh.tech.wallup.utils.CustomDialog
import divyansh.tech.wallup.utils.EventObserver

@AndroidEntryPoint
class PopularTagsFragment: Fragment() {

    private lateinit var _binding: FragmentPopularTagsBinding
    val binding get() = _binding

    private val args by navArgs<PopularTagsFragmentArgs>()

    private val viewModel by viewModels<PopularTagsViewModel>()

    private lateinit var  _dialog: AlertDialog

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
        _dialog = CustomDialog.createDialog(requireContext(), requireActivity())
        setupRecyclerView()
        setupObservers()
    }

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

        viewModel.loadingLiveData.observe(
            viewLifecycleOwner,
            Observer {
                if (it) _dialog.show()
                else _dialog.dismiss()
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