package ca.ersin.iosched_teardown.di.module

import android.content.Context
import android.content.SharedPreferences
import ca.ersin.iosched_teardown.App
import ca.ersin.shared.Analytics
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun providesContext(application: App): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun providesPreferenceStorage(context: Context): SharedPreferences =
            context.getSharedPreferences("myApp", Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun providesAnalytics(context: Context): Analytics = Analytics(context)
}