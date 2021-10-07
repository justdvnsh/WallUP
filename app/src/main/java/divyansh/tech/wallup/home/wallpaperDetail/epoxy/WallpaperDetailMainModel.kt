package divyansh.tech.wallup.home.wallpaperDetail.epoxy

import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import divyansh.tech.wallup.BR
import divyansh.tech.wallup.R
import divyansh.tech.wallup.home.wallpaperDetail.dataModels.Resolution
import divyansh.tech.wallup.home.wallpaperDetail.dataModels.Tags

@EpoxyModelClass(layout = R.layout.tag_item_view)
abstract class EpoxyTagItemModel: DataBindingEpoxyModel() {
    @EpoxyAttribute
    lateinit var tag: Tags

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(BR.tag, tag)
    }
}

@EpoxyModelClass(layout = R.layout.res_item_view)
abstract class EpoxyResolutionItemModel: DataBindingEpoxyModel() {
    @EpoxyAttribute
    lateinit var resolution: Resolution

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(BR.res, resolution)
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