package ca.ersin.iosched_teardown.di.module

import ca.ersin.iosched_teardown.ui.MainActivity
import ca.ersin.iosched_teardown.ui.MainActivityModule
import ca.ersin.shared.di.scope.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainActivityModule::class, FragmentModule::class])
    internal abstract fun mainActivity(): MainActivity

}