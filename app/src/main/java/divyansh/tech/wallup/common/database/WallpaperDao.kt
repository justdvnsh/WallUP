package divyansh.tech.wallup.common.database

import androidx.lifecycle.LiveData
import androidx.room.*
import divyansh.tech.wallup.home.browse.datamodel.OfflineWallpapers
import divyansh.tech.wallup.home.browse.datamodel.Wallpapers

@Dao
interface WallpaperDao {
    @Query("SELECT * FROM wallpapers")
    suspend fun getAllWallpapers(): List<OfflineWallpapers>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewWallpaper(wallpapers: OfflineWallpapers)

    @Delete
    fun deleteWallpaper(wallpapers: OfflineWallpapers)
}