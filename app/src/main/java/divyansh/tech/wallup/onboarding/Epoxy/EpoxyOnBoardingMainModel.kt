package divyansh.tech.wallup.onboarding.Epoxy

import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import divyansh.tech.wallup.BR
import divyansh.tech.wallup.R
import divyansh.tech.wallup.onboarding.datamodels.TopicsItem

@EpoxyModelClass(layout = R.layout.item_topics)
abstract class TopicItemModel: DataBindingEpoxyModel() {
    @EpoxyAttribute
    lateinit var topic: TopicsItem

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(BR.topic, topic)
    }
}