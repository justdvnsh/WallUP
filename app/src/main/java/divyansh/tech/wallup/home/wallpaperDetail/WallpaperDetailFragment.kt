 package divyansh.tech.wallup.home.wallpaperDetail

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.R
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
    private lateinit var _dialog: AlertDialog

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
        binding.imageUrl = args.url
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDialog()
        setupObservers()
        setupImage()
    }

    private fun setupDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        val view = requireActivity().layoutInflater.inflate(R.layout.loading_dialog, null)
        builder.setView(view)
        builder.setCancelable(false)
        _dialog = builder.create()
        _dialog.show()
    }

    private fun setupImage() {
        Glide.with(this)
            .asBitmap()
            .load(args.url)
            .into(object: CustomTarget<Bitmap>(){
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    _dialog.dismiss()
                    binding.rootView.visibility = View.VISIBLE
                    binding.imageBackground.setImageBitmap(resource)
                    setupWallpaperButton(resource)
                    setupSaveToGallery(resource)
                }

                override fun onLoadCleared(placeholder: Drawable?) {}
            })
    }

    private fun setupWallpaperButton(res: Bitmap) {
        binding.setAsWallpaper.setOnClickListener {
            // set wallpaper
        }
    }

    private fun setupSaveToGallery(res: Bitmap) {
        binding.saveToGallery.setOnClickListener {
            MediaStore.Images.Media.insertImage(
                requireActivity().contentResolver,
                res,
                "yourTitle" ,
                "yourDescription");
        }
    }

    private fun setupObservers() {
        viewModel.wallpaperDetailLiveData.observe(
            viewLifecycleOwner,
            Observer {
                wallpaperDetailController.setData(it)
            }
        )

        viewModel.wallpaperImageLiveData.observe(
            viewLifecycleOwner,
            Observer {
                binding.imageBackground.setImageBitmap(it)
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