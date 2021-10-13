package divyansh.tech.wallup.home.browse.screens.search.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import divyansh.tech.wallup.home.browse.screens.featuredCategories.source.FeaturedCategoriesDataSource
import divyansh.tech.wallup.home.browse.screens.featuredCategories.source.FeaturedCategoriesDefaultRepo
import divyansh.tech.wallup.home.browse.screens.search.source.SearchDataSource
import divyansh.tech.wallup.home.browse.screens.search.source.SearchDefaultRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class SearchFragmentModule {

    @Binds
    @ViewModelScoped
    abstract fun bindSearchModule(repo: SearchDefaultRepository): SearchDataSource
}