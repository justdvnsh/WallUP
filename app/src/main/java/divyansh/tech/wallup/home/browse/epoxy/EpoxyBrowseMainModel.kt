package divyansh.tech.wallup.home.browse.epoxy

import android.annotation.SuppressLint
import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import divyansh.tech.wallup.BR

import divyansh.tech.wallup.R

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.recycler_popular_wallpaper_item)
abstract class EpoxyWallpapers(): DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var imageUrl: String

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(BR.imageUrl, imageUrl)
    }
}

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.recycler_browse_view)
abstract class EpoxyBrowseView(): DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var heading: String

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(BR.heading, heading)
    }
}

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.recycler_category_item)
abstract class EpoxyRecyclerCategory(): DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var imageUrl: Integer

    @EpoxyAttribute
    lateinit var heading: String

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(BR.imageUrl, imageUrl)
        binding.setVariable(BR.heading, heading)
    }
}

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.recycler_recommended_item)
abstract class EpoxyRecommendedCategory(): DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var imageUrl: Integer

    @EpoxyAttribute
    lateinit var heading: String

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(BR.imageUrl, imageUrl)
        binding.setVariable(BR.heading, heading)
    }
}