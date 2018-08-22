package ca.ersin.iosched_teardown.ui.activity.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ca.ersin.shared.Analytics
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(val analytics: Analytics) : ViewModel() {

    inner class AnalyticsLiveData(val analytics: Analytics) : LiveData<Long>() {

        private val listener = object : Analytics.CounterListener {
            override fun onCounterChanged(counter: Long) {
                value = counter
            }
        }

        override fun onActive() {
            analytics.addListener(listener)
        }

        override fun onInactive() {
            analytics.removeListener(listener)
        }
    }

    val analyticsLiveData: AnalyticsLiveData

    init {
        analytics.inc(this::class.java)
        analyticsLiveData = AnalyticsLiveData(analytics)
    }


}