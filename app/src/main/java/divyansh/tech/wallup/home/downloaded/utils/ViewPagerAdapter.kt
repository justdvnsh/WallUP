package divyansh.tech.wallup.home.downloaded.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import divyansh.tech.wallup.home.downloaded.screens.downloaded.DownloadedWallpaperFragment
import divyansh.tech.wallup.home.downloaded.screens.saved.SavedWallpaperFragment


class ViewPagerAdapter(private val list: MutableList<Fragment> = mutableListOf(),
                       fragmentManager: FragmentManager,
                       lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager , lifecycle) {

    private val pageIds= mutableListOf<Long>()

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }

    fun addFragments(ls:List<String>){
        pageIds.clear()
        list.add(SavedWallpaperFragment.getInstance())
        list.add(DownloadedWallpaperFragment.getInstance())

        pageIds.addAll(list.map { it.hashCode().toLong() })
        notifyDataSetChanged()
    }

    fun removeAllFragments(){
        list.clear()
        pageIds.clear()
        notifyDataSetChanged()
    }

    override fun getItemId(position: Int): Long {
        return pageIds[position]
    }

    override fun containsItem(itemId: Long): Boolean {
        return pageIds.contains(itemId)
    }


}