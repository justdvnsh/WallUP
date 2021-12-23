package divyansh.tech.wallup.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.R
import divyansh.tech.wallup.databinding.ActivityOnBoardingBinding
import divyansh.tech.wallup.onboarding.Epoxy.EpoxyOnBoardingController

@AndroidEntryPoint
class OnBoardingActivity : AppCompatActivity() {

    private val viewModel by viewModels<OnboardingViewModel>()
    private lateinit var binding: ActivityOnBoardingBinding

    private val controller by lazy {
        EpoxyOnBoardingController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerView()
        setupObservers()
    }

    private fun setRecyclerView() {
        binding.topicsRv.apply {
            adapter = controller.adapter
            layoutManager = GridLayoutManager(this@OnBoardingActivity, 2)
        }
    }

    private fun setupObservers() {
        viewModel.topicsLiveData.observe(
            this,
            Observer {
                controller.setData(it)
            }
        )
    }
}