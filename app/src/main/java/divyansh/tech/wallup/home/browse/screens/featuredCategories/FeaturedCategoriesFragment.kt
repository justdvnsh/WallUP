package divyansh.tech.wallup.home.browse.screens.featuredCategories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.databinding.FragmentFeaturedCategoriesBinding
import divyansh.tech.wallup.home.browse.screens.featuredCategories.callbacks.FeaturedCategoryCallbacks
import divyansh.tech.wallup.home.browse.screens.featuredCategories.epoxy.EpoxyFeaturedCategoriesController
import divyansh.tech.wallup.utils.EventObserver

@AndroidEntryPoint
class FeaturedCategoriesFragment: Fragment() {

    private lateinit var _binding: FragmentFeaturedCategoriesBinding
    val binding get() = _binding

    private val args by navArgs<FeaturedCategoriesFragmentArgs>()

    private val viewModel by viewModels<FeaturedCategoriesViewModel>()

    private val controller by lazy {
        val callback = FeaturedCategoryCallbacks(viewModel)
        EpoxyFeaturedCategoriesController(callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeaturedCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        binding.featuredCatRV.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = controller.adapter
        }
    }

    private fun setupObservers() {
        viewModel.featuredCatWallpapers.observe(
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
        viewModel.getWallpapers(args.category.categoryUrl)
    }
}