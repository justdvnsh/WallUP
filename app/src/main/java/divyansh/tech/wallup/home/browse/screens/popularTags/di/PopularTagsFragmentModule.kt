package divyansh.tech.wallup.home.browse.screens.popularTags.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import divyansh.tech.wallup.home.browse.screens.featuredCategories.source.FeaturedCategoriesDataSource
import divyansh.tech.wallup.home.browse.screens.featuredCategories.source.FeaturedCategoriesDefaultRepo
import divyansh.tech.wallup.home.browse.screens.popularTags.source.PopularTagsDataSource
import divyansh.tech.wallup.home.browse.screens.popularTags.source.PopularTagsDefaultRepo

@Module
@InstallIn(ViewModelComponent::class)
abstract class PopularTagsFragmentModule {

    @Binds
    @ViewModelScoped
    abstract fun bindPopularTagsModule(repo: PopularTagsDefaultRepo):
            PopularTagsDataSource
}