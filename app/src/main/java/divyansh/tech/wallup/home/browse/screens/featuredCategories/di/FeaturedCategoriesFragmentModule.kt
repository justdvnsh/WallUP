package divyansh.tech.wallup.home.browse.screens.featuredCategories.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import divyansh.tech.wallup.home.browse.screens.featuredCategories.source.FeaturedCategoriesDataSource
import divyansh.tech.wallup.home.browse.screens.featuredCategories.source.FeaturedCategoriesDefaultRepo

@Module
@InstallIn(ViewModelComponent::class)
abstract class FeaturedCategoriesFragmentModule {

    @Binds
    @ViewModelScoped
    abstract fun bindFeaturedCategoryModule(repo: FeaturedCategoriesDefaultRepo):
            FeaturedCategoriesDataSource
}