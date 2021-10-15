package divyansh.tech.wallup.home.settings

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.R
import divyansh.tech.wallup.databinding.FragmentSettingsBinding

@AndroidEntryPoint
class SettingsFragment: Fragment() {
    private lateinit var _binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }

    private fun setUpListeners() {
        _binding.aboutUsButton.setOnClickListener { setupAboutUsButton() }
        _binding.supportUsButton.setOnClickListener { supportUsButton() }
    }

    private fun supportUsButton() {
        val uri = Uri.parse("https://github.com/justdvnsh/WallUP")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    private fun setupAboutUsButton() {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.title_about_us)
            .setMessage(R.string.message_about_us)
            .setPositiveButton(R.string.ok_button) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}