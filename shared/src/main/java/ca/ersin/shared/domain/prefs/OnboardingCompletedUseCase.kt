package ca.ersin.shared.domain.prefs

import ca.ersin.shared.data.prefs.PreferenceStorage
import ca.ersin.shared.domain.UseCase
import javax.inject.Inject

open class OnboardingCompletedUseCase @Inject constructor(private val preferenceStorage: PreferenceStorage) : UseCase<Unit, Boolean>() {
    override fun execute(parameters: Unit): Boolean = preferenceStorage.onboardingCompleted
}