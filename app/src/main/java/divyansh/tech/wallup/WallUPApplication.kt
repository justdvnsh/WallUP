package divyansh.tech.wallup

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WallUPApplication: Application() {
    override fun onCreate() = super.onCreate()
}