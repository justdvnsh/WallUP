package divyansh.tech.wallup

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.databinding.ActivityMainBinding
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        setupNavigation()
        Timber.e("INSIDE MAIN ACTIVITY")
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragmentMainActivity)
        navController = navHostFragment?.findNavController()!!
        NavigationUI.setupWithNavController(
            _binding.mainBottomNavigation,
            navController
        )
        navHostFragment.findNavController().addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id) {
                R.id.browseFragment2 -> _binding.mainBottomNavigation.visibility = View.VISIBLE
                R.id.downloadedFragment2 -> _binding.mainBottomNavigation.visibility = View.VISIBLE
                R.id.settingsFragment2 -> _binding.mainBottomNavigation.visibility = View.VISIBLE
                else -> _binding.mainBottomNavigation.visibility = View.GONE
            }
        }
    }
}