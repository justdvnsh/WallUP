package divyansh.tech.wallup.common

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import divyansh.tech.wallup.utils.CustomDialog

abstract class CommonFragment : Fragment() {

    private lateinit var _dialog: AlertDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _dialog = CustomDialog.createDialog(requireContext(), requireActivity())
        setupObservers()
    }

    private fun setupObservers() {
        getCommonViewModel().loadingLiveData.observe(
            viewLifecycleOwner,
            Observer {
                if (it) showLoading()
                else hideLoading()
            }
        )
    }

    protected abstract fun getCommonViewModel(): CommonViewModel

    protected fun showLoading() {
        _dialog.show()
    }

    protected fun hideLoading() {
        _dialog.dismiss()
    }
}