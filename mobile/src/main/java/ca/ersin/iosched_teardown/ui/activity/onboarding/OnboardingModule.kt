package ca.ersin.iosched_teardown.ui.activity.onboarding

import androidx.lifecycle.ViewModel
import ca.ersin.iosched_teardown.ui.fragment.onboarding.OnboardingFragment
import ca.ersin.shared.di.ViewModelKey
import ca.ersin.shared.di.scope.FragmentScoped
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class OnboardingModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeOnboardingFragment(): OnboardingFragment

    @Binds
    @IntoMap
    @ViewModelKey(OnboardingViewModel::class)
    internal abstract fun bindOnboardingViewModel(viewModel: OnboardingViewModel): ViewModel
}