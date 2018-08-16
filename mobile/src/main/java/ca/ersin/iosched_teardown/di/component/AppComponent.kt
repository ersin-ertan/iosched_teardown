package ca.ersin.iosched_teardown.di.component

import ca.ersin.iosched_teardown.App
import ca.ersin.iosched_teardown.di.module.ActivityBindingModule
import ca.ersin.iosched_teardown.di.module.AppModule
import ca.ersin.shared.di.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            AppModule::class,
            ActivityBindingModule::class,
            ViewModelModule::class]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}