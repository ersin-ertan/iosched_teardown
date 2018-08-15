package ca.ersin.iosched_teardown

import ca.ersin.iosched_teardown.di.component.DaggerAppComponent
import ca.ersin.shared.Analytics
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

class App : DaggerApplication() {

    @Inject
    lateinit var analytics: Analytics

    override fun onCreate() {
        super.onCreate()

        analytics.inc(this::class.java)

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
            DaggerAppComponent.builder().create(this)
}