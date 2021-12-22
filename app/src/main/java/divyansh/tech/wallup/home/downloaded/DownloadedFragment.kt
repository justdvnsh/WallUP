package divyansh.tech.wallup.home.downloaded

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.R
import divyansh.tech.wallup.databinding.FragmentDownloadedBinding
import divyansh.tech.wallup.home.downloaded.utils.ViewPagerAdapter

@AndroidEntryPoint
class DownloadedFragment: Fragment() {
    private lateinit var _binding: FragmentDownloadedBinding
    lateinit var pagerAdapter: ViewPagerAdapter
    private var mediator: TabLayoutMediator? = null
    val tabNames= listOf("Saved","Downloaded")

    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {

        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDownloadedBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewpager()
    }

    private fun setUpViewpager(){

        pagerAdapter = ViewPagerAdapter(fragmentManager = childFragmentManager, lifecycle = lifecycle)
        _binding.apply {
            viewPager2.isUserInputEnabled = true

            viewPager2.adapter = pagerAdapter
            viewPager2.registerOnPageChangeCallback(pageChangeCallback)

            if (mediator != null)
                mediator!!.detach()
            pagerAdapter.removeAllFragments()
            pagerAdapter.addFragments(tabNames)
            viewPager2.offscreenPageLimit = pagerAdapter.itemCount

            val tabs = mutableListOf<String>().apply {
                addAll(tabNames)
            }

            val strategy =
                TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                    tab.text = tabs[position]
                }

            mediator = TabLayoutMediator(
                tabLayout,
                viewPager2,
                strategy
            )

            mediator?.attach()
        }

    }

    override fun onStop() {
        _binding.viewPager2.unregisterOnPageChangeCallback(pageChangeCallback)
        super.onStop()
    }

}