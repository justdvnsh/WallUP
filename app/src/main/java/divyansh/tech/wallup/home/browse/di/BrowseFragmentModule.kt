package divyansh.tech.wallup.home.browse.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import divyansh.tech.wallup.home.browse.source.BrowseDataSource
import divyansh.tech.wallup.home.browse.source.BrowseDefaultRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class BrowseFragmentModule {

    @Binds
    @ViewModelScoped
    abstract fun bindBrowseRepository(repo: BrowseDefaultRepository):BrowseDataSource
}