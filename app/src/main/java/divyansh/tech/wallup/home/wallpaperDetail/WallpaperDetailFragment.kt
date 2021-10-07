package divyansh.tech.wallup.home.wallpaperDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.daimajia.easing.linear.Linear
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.databinding.FragmentWallpaperDetailsBinding
import divyansh.tech.wallup.home.wallpaperDetail.callbacks.WallpaperDetailCallbacks
import divyansh.tech.wallup.home.wallpaperDetail.epoxy.EpoxyWallpaperDetailController
import divyansh.tech.wallup.utils.EventObserver

@AndroidEntryPoint
class WallpaperDetailFragment: Fragment() {

    private lateinit var _binding: FragmentWallpaperDetailsBinding
    val binding get() = _binding

    private val viewModel by viewModels<WallpaperDetailViewModel>()

    private val args by navArgs<WallpaperDetailFragmentArgs>()

    private val wallpaperDetailController by lazy {
        val callback = WallpaperDetailCallbacks(viewModel)
        EpoxyWallpaperDetailController(callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWallpaperDetailsBinding.inflate(inflater, container, false)
        binding.imageUrl = args.wallpaper.imageUrl
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        binding.wallpaperDetailRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = wallpaperDetailController.adapter
            wallpaperDetailController.spanCount = 3
        }
    }

    private fun setupObservers() {
        viewModel.wallpaperDetailLiveData.observe(
            viewLifecycleOwner,
            Observer {
                wallpaperDetailController.setData(it)
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
        viewModel.getWallpaperData(args.wallpaper.wallpaperUrl)
    }
}