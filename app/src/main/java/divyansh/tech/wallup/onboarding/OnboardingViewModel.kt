package divyansh.tech.wallup.onboarding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.wallup.common.CommonViewModel
import divyansh.tech.wallup.common.DispatcherModule
import divyansh.tech.wallup.onboarding.datamodels.Topics
import divyansh.tech.wallup.onboarding.source.OnboardingRemoteDataSource
import divyansh.tech.wallup.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val remoteRepo: OnboardingRemoteDataSource,
    @DispatcherModule.IODispatcher private val coroutineDispatcher: CoroutineDispatcher
): CommonViewModel() {

    private val _topicsLiveData = MutableLiveData<Topics>()
    val topicsLiveData get() = _topicsLiveData

    init {
        getTopics()
    }

    private fun getTopics() = viewModelScope.launch(coroutineDispatcher) {
        when(val response = remoteRepo.getTopics()) {
            is Result.Success -> {
                Timber.e("ONBOARDING -> ${(response.data)}")
            }
            is Result.Error -> Timber.e("ONBOARDING -> SOMETHING WENT WRONG")
            else -> {}
        }
    }
}