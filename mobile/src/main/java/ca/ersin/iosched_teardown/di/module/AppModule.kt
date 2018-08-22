package ca.ersin.iosched_teardown.di.module

import android.content.Context
import ca.ersin.iosched_teardown.App
import ca.ersin.shared.Analytics
import ca.ersin.shared.data.prefs.PreferenceStorage
import ca.ersin.shared.data.prefs.SharedPreferenceStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun providesContext(application: App): Context =
            application.applicationContext


    @Singleton
    @Provides
    fun providesPreferenceStorage(context: Context): PreferenceStorage =
            SharedPreferenceStorage(context)

    @Singleton
    @Provides
    fun providesAnalytics(context: Context): Analytics = Analytics(context)
}