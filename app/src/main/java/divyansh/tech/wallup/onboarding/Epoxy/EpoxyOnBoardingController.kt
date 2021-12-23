package divyansh.tech.wallup.onboarding.Epoxy

import com.airbnb.epoxy.TypedEpoxyController
import divyansh.tech.wallup.onboarding.datamodels.Topics

class EpoxyOnBoardingController: TypedEpoxyController<Topics>() {
    override fun buildModels(data: Topics?) {
        data?.let {
            it.forEach {
                topicItem {
                    id(it.id)
                    topic(it)
                }
            }
        }
    }
}