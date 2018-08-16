package ca.ersin.iosched_teardown.ui

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ca.ersin.iosched_teardown.R
import ca.ersin.iosched_teardown.ui.fragment.ParentFragment
import ca.ersin.shared.Analytics
import ca.ersin.shared.util.viewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var analytics: Analytics

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        analytics.inc(this::class.java)

        mainActivityViewModel = viewModelProvider(viewModelFactory)
        mainActivityViewModel.analyticsLiveData.observe(this, Observer {
            Log.v("MainActivity", "MainActivity Analytics counter observer:$it")
        })

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.activityMainLinear, ParentFragment()).commit()
        }
    }
}
