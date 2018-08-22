package ca.ersin.iosched_teardown.ui.activity.launch

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ca.ersin.iosched_teardown.ui.activity.main.MainActivity
import ca.ersin.iosched_teardown.ui.activity.onboarding.OnboardingActivity
import ca.ersin.shared.result.EventObserver
import ca.ersin.shared.util.checkAllMatched
import ca.ersin.shared.util.viewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class LauncherActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: LaunchViewModel = viewModelProvider(viewModelFactory)
        viewModel.launchDestination.observe(this, EventObserver {
            when (it) {
                LaunchDestination.MAIN_ACTIVITY -> startActivity(Intent(this, MainActivity::class.java))
                LaunchDestination.ONBOARDING -> startActivity(Intent(this, OnboardingActivity::class.java))
            }.checkAllMatched
            finish()
        })
    }
}
