package divyansh.tech.wallup.home.settings

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.wallup.R
import divyansh.tech.wallup.databinding.FragmentSettingsBinding

@AndroidEntryPoint
class SettingsFragment: Fragment() {
    private lateinit var _binding: FragmentSettingsBinding
    private lateinit var mContext:Context

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
        mContext=requireContext()
        setUpListeners()
    }

    private fun setUpListeners() {
        _binding.aboutUsButton.setOnClickListener { setupAboutUsButton() }
        _binding.supportUsButton.setOnClickListener { supportUsButton() }
        setUpThemeChange()
    }

    private fun supportUsButton() {
        val uri = Uri.parse("https://github.com/justdvnsh/WallUP")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    private fun setupAboutUsButton() {
        AlertDialog.Builder(mContext)
            .setTitle(R.string.title_about_us)
            .setMessage(R.string.message_about_us)
            .setPositiveButton(R.string.ok_button) { dialog, _ ->
                dialog.dismiss()
            }
            .show()

    }

    private fun setUpThemeChange(){

        val uiModes = resources.getStringArray(R.array.ui_mode)

        val checkedItem: Int = when(AppCompatDelegate.getDefaultNightMode()){
            AppCompatDelegate.MODE_NIGHT_NO-> 0
            AppCompatDelegate.MODE_NIGHT_YES-> 1
            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM-> 2
            else-> 2
        }

        _binding.themeButton.setOnClickListener {
            AlertDialog
                .Builder(mContext)
                .setTitle("Choose Theme")
                .setSingleChoiceItems(uiModes, checkedItem){ dialog, checked ->
                    when(checked){
                        0 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                        1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        2 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                    }
                    dialog.dismiss()
                }
                .setCancelable(true)
                .show()
        }


    }

}