package ca.ersin.iosched_teardown.di.module

import androidx.lifecycle.ViewModel
import ca.ersin.iosched_teardown.ui.fragment.ParentFragment
import ca.ersin.iosched_teardown.ui.fragment.ParentFragmentsModule
import ca.ersin.iosched_teardown.ui.fragment.children.ChildFragmentViewModel
import ca.ersin.shared.di.ViewModelKey
import ca.ersin.shared.di.scope.FragmentScoped
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class FragmentModule {

    @FragmentScoped
    @ContributesAndroidInjector(modules = [ParentFragmentsModule::class])
    internal abstract fun contributeParentFragment(): ParentFragment

    @Binds
    @IntoMap
    @ViewModelKey(ChildFragmentViewModel::class)
    abstract fun bindChildFragmentViewModel(viewModel: ChildFragmentViewModel): ViewModel

}