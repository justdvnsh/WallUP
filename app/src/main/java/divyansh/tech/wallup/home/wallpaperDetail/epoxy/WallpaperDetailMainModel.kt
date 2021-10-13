package divyansh.tech.wallup.home.wallpaperDetail.epoxy

import android.annotation.SuppressLint
import android.content.Context
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.airbnb.epoxy.*
import divyansh.tech.wallup.BR
import divyansh.tech.wallup.R
import divyansh.tech.wallup.common.BrowseCallbacks
import divyansh.tech.wallup.home.browse.datamodel.PopularTags

@EpoxyModelClass(layout = R.layout.tag_item_view)
abstract class EpoxyTagItemModel: DataBindingEpoxyModel() {
    @EpoxyAttribute
    lateinit var tag: PopularTags

    @EpoxyAttribute
    lateinit var callback: BrowseCallbacks

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(BR.tag, tag)
        binding.setVariable(BR.tagCallback, callback)
    }
}

@SuppressLint("NonConstantResourceId")
@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class CategoryBackground(context: Context) : Carousel(context) {
    override fun createLayoutManager(): RecyclerView.LayoutManager {
        return StaggeredGridLayoutManager(3, GridLayoutManager.HORIZONTAL)
    }
}

@EpoxyModelClass(layout = R.layout.heading_item)
abstract class EpoxyHeadingItemModel: DataBindingEpoxyModel() {
    @EpoxyAttribute
    lateinit var heading: String

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(BR.heading, heading)
    }
}