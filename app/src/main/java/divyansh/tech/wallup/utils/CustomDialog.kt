package divyansh.tech.wallup.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import divyansh.tech.wallup.R

class CustomDialog {
    companion object {
        fun createDialog(context: Context, activity: FragmentActivity): AlertDialog {
            val builder: AlertDialog.Builder = AlertDialog.Builder(context)
            val view = activity.layoutInflater.inflate(R.layout.loading_dialog, null)
            builder.setView(view)
            builder.setCancelable(false)
            return builder.create()
        }
    }
}