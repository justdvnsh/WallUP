package divyansh.tech.wallup.home.wallpaperDetail

import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.common.CommonFragment
import divyansh.tech.wallup.common.CommonViewModel
import divyansh.tech.wallup.databinding.FragmentWallpaperDetailsBinding
import divyansh.tech.wallup.utils.CustomDialog
import divyansh.tech.wallup.utils.EventObserver
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream


@AndroidEntryPoint
class WallpaperDetailFragment : CommonFragment() {

    private lateinit var _binding: FragmentWallpaperDetailsBinding
    val binding get() = _binding

    private val viewModel by viewModels<WallpaperDetailViewModel>()

    private val args by navArgs<WallpaperDetailFragmentArgs>()

    private lateinit var _wallpaper: Bitmap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWallpaperDetailsBinding.inflate(inflater, container, false)
        setupFullScreen()
        binding.imageUrl = args.url
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoading()
        setupObservers()
        setupImage()
    }

    override fun getCommonViewModel(): CommonViewModel = viewModel

    private fun setupFullScreen() {
        requireActivity().apply {
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER)
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN)
        }
    }

    private fun setupImage() {
        Glide.with(this)
            .asBitmap()
            .load(args.url)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    hideLoading()
                    _wallpaper = resource
                    binding.rootView.visibility = View.VISIBLE
                    binding.imageBackground.setImageBitmap(resource)
                    setupWallpaperButton()
                    setupSaveToGallery()
                    setupFavoriteButton()
                }

                override fun onLoadCleared(placeholder: Drawable?) {}
            })
    }

    private fun setupWallpaperButton() {
        binding.setAsWallpaper.setOnClickListener {
            // set wallpaper
            val bos = ByteArrayOutputStream()
            _wallpaper.compress(CompressFormat.PNG, 0 /*ignored for PNG*/, bos)
            val bitmapdata: ByteArray = bos.toByteArray()
            val bs = ByteArrayInputStream(bitmapdata)
            WallpaperManager.getInstance(requireContext()).setStream(bs)
            Snackbar.make(requireView(), "Wallpaper set", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun setupSaveToGallery() {
        binding.saveToGallery.setOnClickListener {
            MediaStore.Images.Media.insertImage(
                requireActivity().contentResolver,
                _wallpaper,
                "yourTitle",
                "yourDescription"
            );
            Snackbar.make(requireView(), "Saved to gallery", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun setupFavoriteButton() {
        binding.favorite.setOnClickListener {
            viewModel.saveWallpaper(args.url)
        }
    }

    private fun setupObservers() {

        viewModel.favoriteLiveData.observe(
            viewLifecycleOwner,
            EventObserver {
                Snackbar.make(requireView(), "Wallpaper Saved", Snackbar.LENGTH_SHORT).show()
            }
        )

        viewModel.navigation.observe(
            viewLifecycleOwner,
            EventObserver {
                findNavController().navigate(it)
            }
        )
    }
}