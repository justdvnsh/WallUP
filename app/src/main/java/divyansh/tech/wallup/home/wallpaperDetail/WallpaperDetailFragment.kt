package divyansh.tech.wallup.home.wallpaperDetail

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.webkit.JavascriptInterface
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
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
import divyansh.tech.wallup.home.wallpaperDetail.utils.WallpaperDetailDeserializer
import divyansh.tech.wallup.utils.EventObserver
import timber.log.Timber

@AndroidEntryPoint
class WallpaperDetailFragment: Fragment() {

    private lateinit var _binding: FragmentWallpaperDetailsBinding
    val binding get() = _binding

    private val viewModel by viewModels<WallpaperDetailViewModel>()

    private val args by navArgs<WallpaperDetailFragmentArgs>()

    inner class JavaScriptInterface(context: Context) {

        @JavascriptInterface
        fun showHTML(html: String) {
            Timber.e("HTML DATA -> $html")
            showImage(html)
        }
    }

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
                setupWebView(it.res[0].url)
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

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView(url: String) {
        binding.webView.apply {
            settings.javaScriptEnabled = true
            addJavascriptInterface(JavaScriptInterface(requireContext()), "HtmlViewer")
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    binding.webView.loadUrl("javascript:window.HtmlViewer.showHTML" +
                            "('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');")
                }
            }
            loadUrl(url)
        }
    }

    private fun showImage(html: String) {
        viewModel.getWallpaperImage(html)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getWallpaperData(args.wallpaper.wallpaperUrl)
    }
}