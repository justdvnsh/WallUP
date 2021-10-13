package divyansh.tech.wallup.home.browse.screens.search

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.databinding.FragmentSearchBinding
import divyansh.tech.wallup.home.browse.screens.search.callbacks.SearchCallbacks
import divyansh.tech.wallup.home.browse.screens.search.epoxy.SearchController
import divyansh.tech.wallup.utils.CustomDialog
import divyansh.tech.wallup.utils.EventObserver

@AndroidEntryPoint
class SearchFragment: Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val viewModel by viewModels<SearchViewModel>()
    private val searchController by lazy {
        SearchController(SearchCallbacks(viewModel))
    }

    private lateinit var  _dialog: AlertDialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSearchBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _dialog = CustomDialog.createDialog(requireContext(), requireActivity())
        setupEditText()
        setupClickListeners()
        setupRecyclerView()
        setupObservers()
    }

    private fun setupEditText() {
        binding.searchEditText.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH || event.action == KeyEvent.ACTION_DOWN) {
                hideKeyBoard()
                binding.searchEditText.clearFocus()
                viewModel.search(v.text.toString().trim())
                return@OnEditorActionListener true
            }
            false
        })
    }

    private fun setupClickListeners() {
        binding.backButton.setOnClickListener {
            hideKeyBoard()
            findNavController().popBackStack()
        }
    }

    private fun setupRecyclerView() {
        binding.searchRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            (layoutManager as GridLayoutManager).spanSizeLookup = searchController.spanSizeLookup
            adapter = searchController.adapter
            searchController.spanCount = 2
        }
    }


    private fun setupObservers() {

        viewModel.searchResultLiveData.observe(
            viewLifecycleOwner,
            Observer {
                if (it == null) {
                    binding.searchRecyclerView.visibility = View.GONE
                    binding.noResultsView.visibility = View.VISIBLE
                } else searchController.setData(it)
            }
        )

        viewModel.loadingLiveData.observe(
            viewLifecycleOwner,
            Observer {
                if (it) _dialog.show()
                else _dialog.dismiss()
            }
        )

        viewModel.navigation.observe(
            viewLifecycleOwner,
            EventObserver {
                findNavController().navigate(it)
            }
        )
    }

    private fun hideKeyBoard() {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(activity?.currentFocus?.windowToken, 0)
    }

    private fun showKeyBoard() {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(activity?.currentFocus, 0)
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = activity?.getSystemService(Context.CONNECTIVITY_SERVICE)
        return if (connectivityManager is ConnectivityManager) {
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            networkInfo?.isConnected ?: false
        } else false
    }
}