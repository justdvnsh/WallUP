package divyansh.tech.wallup.common

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import androidx.room.RoomDatabase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import divyansh.tech.wallup.common.database.WallpaperDatabase
import divyansh.tech.wallup.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val USER_PREF = "user_prefs"

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun providesRetrofitInstance(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

    @Provides
    @Singleton
    fun providesRoomInstance(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            WallpaperDatabase::class.java,
            "wallpaper-db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun providesWallpaperDao(db: WallpaperDatabase) = db.wallpaperDao()

    @Provides
    @Singleton
    fun provideSharedPrefs(
        @ApplicationContext context: Context
    ): SharedPreferences = context.getSharedPreferences(USER_PREF, Context.MODE_PRIVATE)
}