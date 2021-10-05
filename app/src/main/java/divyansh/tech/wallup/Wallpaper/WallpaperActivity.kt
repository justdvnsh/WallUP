package divyansh.tech.wallup.Wallpaper

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.R
import divyansh.tech.wallup.databinding.ActivityWallpaperBinding

@AndroidEntryPoint
class WallpaperActivity: AppCompatActivity() {

    private lateinit var binding: ActivityWallpaperBinding
    private val args by navArgs<WallpaperActivityArgs>()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityWallpaperBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupStatusBar()
        setupImageView()
    }

    private fun setupImageView() {

    }

    private fun setupStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER)
            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = ContextCompat.getColor(this, R.color.gfgWhite)
        }
    }
}