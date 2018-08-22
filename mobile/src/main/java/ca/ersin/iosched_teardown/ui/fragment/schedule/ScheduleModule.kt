package ca.ersin.iosched_teardown.ui.fragment.schedule

import androidx.lifecycle.ViewModel
import ca.ersin.shared.di.ViewModelKey
import ca.ersin.shared.di.scope.FragmentScoped
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class ScheduleModule {

    @FragmentScoped
    @ContributesAndroidInjector(
            modules = [
//                ScheduleChildFragmentsModule::class,
//                SessionViewPoolModule::class
            ]
    )
    internal abstract fun contributeScheduleFragment(): ScheduleFragment

    @Binds
    @IntoMap
    @ViewModelKey(ScheduleFragmentViewModel::class)
    abstract fun bindScheduleViewModel(viewModel: ScheduleFragmentViewModel): ViewModel

}