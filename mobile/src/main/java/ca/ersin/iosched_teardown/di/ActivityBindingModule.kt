package ca.ersin.iosched_teardown.di

import ca.ersin.iosched_teardown.di.module.FragmentModule
import ca.ersin.iosched_teardown.ui.MainActivity
import ca.ersin.shared.di.scope.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    internal abstract fun mainActivity(): MainActivity

}