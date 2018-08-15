package ca.ersin.iosched_teardown.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ca.ersin.iosched_teardown.R
import ca.ersin.iosched_teardown.ui.fragment.ParentFragment
import ca.ersin.shared.Analytics
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var analytics: Analytics

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        analytics.inc(this::class.java)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.activityMainLinear, ParentFragment()).commit()
        }
    }
}
