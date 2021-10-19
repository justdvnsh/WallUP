package divyansh.tech.wallup.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import divyansh.tech.wallup.home.browse.datamodel.OfflineWallpapers
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers

@Database(entities = [OfflineWallpapers::class], version = 1)
abstract class WallpaperDatabase: RoomDatabase() {
    abstract fun wallpaperDao(): WallpaperDao
}