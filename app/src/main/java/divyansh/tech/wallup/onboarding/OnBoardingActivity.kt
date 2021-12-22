package divyansh.tech.wallup.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.R

@AndroidEntryPoint
class OnBoardingActivity : AppCompatActivity() {

    private val viewModel by viewModels<OnboardingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.topicsLiveData.observe(
            this,
            Observer {
                Log.e("ONBOARDING -> ", it.toString())
                Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
            }
        )
    }
}