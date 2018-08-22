package ca.ersin.iosched_teardown.di.module

import ca.ersin.iosched_teardown.ui.activity.launch.LaunchModule
import ca.ersin.iosched_teardown.ui.activity.launch.LauncherActivity
import ca.ersin.iosched_teardown.ui.activity.main.MainActivity
import ca.ersin.iosched_teardown.ui.activity.main.MainActivityModule
import ca.ersin.iosched_teardown.ui.activity.map.MapActivity
import ca.ersin.iosched_teardown.ui.activity.onboarding.OnboardingActivity
import ca.ersin.iosched_teardown.ui.activity.onboarding.OnboardingModule
import ca.ersin.iosched_teardown.ui.fragment.info.InfoModule
import ca.ersin.iosched_teardown.ui.fragment.map.MapModule
import ca.ersin.iosched_teardown.ui.fragment.schedule.ScheduleModule
import ca.ersin.shared.di.scope.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainActivityModule::class, InfoModule::class, MapModule::class, ScheduleModule::class])
    internal abstract fun mainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [LaunchModule::class])
    internal abstract fun launcherActivity(): LauncherActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MapModule::class])
    internal abstract fun mapActivity(): MapActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [OnboardingModule::class])
    internal abstract fun onboardingActivity(): OnboardingActivity

}