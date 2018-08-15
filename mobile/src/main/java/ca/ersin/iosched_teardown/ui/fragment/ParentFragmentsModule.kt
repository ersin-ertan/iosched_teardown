package ca.ersin.iosched_teardown.ui.fragment

import androidx.lifecycle.ViewModel
import ca.ersin.iosched_teardown.ui.fragment.children.ChildFragment
import ca.ersin.shared.di.ViewModelKey
import ca.ersin.shared.di.scope.ChildFragmentScoped
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class ParentFragmentsModule {

    @ChildFragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeChildFragment(): ChildFragment

    @Binds
    @IntoMap
    @ViewModelKey(ParentFragmentViewModel::class)
    abstract fun bindScheduleViewModel(viewModel: ParentFragmentViewModel): ViewModel
}