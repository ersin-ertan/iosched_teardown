package ca.ersin.iosched_teardown.ui.fragment.map

import androidx.lifecycle.ViewModel
import ca.ersin.shared.di.ViewModelKey
import ca.ersin.shared.di.scope.FragmentScoped
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class MapModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeMapFragment(): MapFragment

    @Binds
    @IntoMap
    @ViewModelKey(MapFragmentViewModel::class)
    abstract fun bindMapFragmentViewModel(viewModel: MapFragmentViewModel): ViewModel

}