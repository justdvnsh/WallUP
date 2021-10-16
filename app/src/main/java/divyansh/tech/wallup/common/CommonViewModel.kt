package divyansh.tech.wallup.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import divyansh.tech.wallup.utils.Event

open class CommonViewModel : ViewModel() {

    // Clicked events
    private val _navigationLiveData: MutableLiveData<Event<NavDirections>> = MutableLiveData()
    val navigation: LiveData<Event<NavDirections>> get() = _navigationLiveData

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loadingLiveData get() = _loading

    /*
  * Helper functions -> Events
  * */
    fun changeNavigation(navDirections: NavDirections) {
        _navigationLiveData.value = Event(navDirections)
    }

    protected fun showLoading() {
        _loading.postValue(true)
    }

    protected fun hideLoading() {
        _loading.postValue(false)
    }
}