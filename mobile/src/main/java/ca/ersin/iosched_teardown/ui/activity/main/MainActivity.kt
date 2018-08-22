package ca.ersin.iosched_teardown.ui.activity.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ca.ersin.iosched_teardown.R
import ca.ersin.iosched_teardown.ui.MainNavigationFragment
import ca.ersin.iosched_teardown.ui.fragment.info.InfoFragment
import ca.ersin.iosched_teardown.ui.fragment.map.MapFragment
import ca.ersin.iosched_teardown.ui.fragment.schedule.ScheduleFragment
import ca.ersin.shared.Analytics
import ca.ersin.shared.util.consume
import ca.ersin.shared.util.inTransaction
import ca.ersin.shared.util.viewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    companion object {
        private const val FRAGMENT_ID = R.id.fragment_container
    }

    @Inject
    lateinit var analytics: Analytics

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var currentFragment: MainNavigationFragment

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
            supportFragmentManager.beginTransaction().add(R.id.activityMainLinear, InfoFragment()).commit()
        }

        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_schedule -> consume {
                    replaceFragment(ScheduleFragment())
                }
                R.id.navigation_map -> consume {
                    replaceFragment(MapFragment())
                }
                R.id.navigation_info -> consume {
                    replaceFragment(InfoFragment())
                }
                else -> false
            }
        }
        // Add a listener to prevent reselects from being treated as selects.
        navigation.setOnNavigationItemReselectedListener {}

        if (savedInstanceState == null) {
            // Show Schedule on first creation
            navigation.selectedItemId = R.id.navigation_schedule
        } else {
            // Find the current fragment
            currentFragment =
                    supportFragmentManager.findFragmentById(FRAGMENT_ID) as? MainNavigationFragment
                    ?: throw IllegalStateException("Activity recreated, but no fragment found!")
        }
    }

    private fun <F> replaceFragment(fragment: F) where F : Fragment, F : MainNavigationFragment {
        supportFragmentManager.inTransaction {
            currentFragment = fragment
            replace(FRAGMENT_ID, fragment)
        }
    }

    override fun onBackPressed() {
        if (!currentFragment.onBackPressed()) {
            super.onBackPressed()
        }
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        currentFragment.onUserInteraction()
    }
}
