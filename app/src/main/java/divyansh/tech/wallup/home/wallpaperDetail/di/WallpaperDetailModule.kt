package divyansh.tech.wallup.home.wallpaperDetail.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import divyansh.tech.wallup.home.browse.source.BrowseDataSource
import divyansh.tech.wallup.home.browse.source.BrowseDefaultRepository
import divyansh.tech.wallup.home.wallpaperDetail.source.WallpaperDefaultRepository
import divyansh.tech.wallup.home.wallpaperDetail.source.WallpaperDetailDataSource

@Module
@InstallIn(ViewModelComponent::class)
abstract class WallpaperDetailModule {

    @Binds
    @ViewModelScoped
    abstract fun bindWallpaperDetailRepository(repo: WallpaperDefaultRepository):
            WallpaperDetailDataSource
}