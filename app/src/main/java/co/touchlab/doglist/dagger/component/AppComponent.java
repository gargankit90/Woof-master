package co.touchlab.doglist.dagger.component;

import android.app.Application;

import co.touchlab.doglist.dagger.module.AppModule;
import co.touchlab.doglist.dagger.module.MainActivityModule;
import co.touchlab.doglist.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Ankit Garg on 12/21/17.
 */

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        MainActivityModule.class
})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(App app);
}
