package ca.ersin.shared.domain.prefs

import ca.ersin.shared.data.prefs.PreferenceStorage
import ca.ersin.shared.domain.UseCase
import javax.inject.Inject

open class OnboardingCompleteActionUseCase @Inject constructor(private val preferenceStorage: PreferenceStorage): UseCase<Boolean, Unit>(){
    override fun execute(completed:Boolean){
        preferenceStorage.onboardingCompleted = completed
    }
}