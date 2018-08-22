package ca.ersin.iosched_teardown.ui.fragment.info

import androidx.lifecycle.ViewModel
import ca.ersin.iosched_teardown.ui.fragment.info.event.EventInfoFragmentViewModel
import ca.ersin.iosched_teardown.ui.fragment.info.event.SettingsFragmentViewModel
import ca.ersin.shared.di.ViewModelKey
import ca.ersin.shared.di.scope.FragmentScoped
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class InfoModule {

    @FragmentScoped
    @ContributesAndroidInjector(modules = [InfoFragmentsModule::class])
    internal abstract fun contributeInfoFragment(): InfoFragment

    // About and Travel don't have viewmodels

    @Binds
    @IntoMap
    @ViewModelKey(SettingsFragmentViewModel::class)
    abstract fun bindSettingsFragmentViewModel(viewModel: SettingsFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EventInfoFragmentViewModel::class)
    abstract fun bindEventInfoFragmentViewModel(viewModel: EventInfoFragmentViewModel): ViewModel
}