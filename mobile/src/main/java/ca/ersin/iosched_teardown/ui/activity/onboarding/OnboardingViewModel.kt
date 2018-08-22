package ca.ersin.iosched_teardown.ui.activity.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.ersin.shared.domain.prefs.OnboardingCompleteActionUseCase
import ca.ersin.shared.result.Event
import javax.inject.Inject

class OnboardingViewModel @Inject constructor(private val onboardingCompleteActionUseCase: OnboardingCompleteActionUseCase) : ViewModel() {

    private val _navigateToMainActivity = MutableLiveData<Event<Unit>>()
    val navigateToMainActivity: LiveData<Event<Unit>> = _navigateToMainActivity

    fun getStartedClick() {
        onboardingCompleteActionUseCase(true)
        _navigateToMainActivity.postValue(Event(Unit))
    }
}
