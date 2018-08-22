package ca.ersin.iosched_teardown.ui.fragment.info

import ca.ersin.iosched_teardown.ui.fragment.info.event.AboutFragment
import ca.ersin.iosched_teardown.ui.fragment.info.event.EventInfoFragment
import ca.ersin.iosched_teardown.ui.fragment.info.event.SettingsFragment
import ca.ersin.iosched_teardown.ui.fragment.info.event.TravelFragment
import ca.ersin.shared.di.scope.ChildFragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class InfoFragmentsModule {

    @ChildFragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeEventFragment(): EventInfoFragment

    @ChildFragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeTravelFragment(): TravelFragment

    @ChildFragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeFaqFragment(): AboutFragment

    @ChildFragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeSettingsFragment(): SettingsFragment

}