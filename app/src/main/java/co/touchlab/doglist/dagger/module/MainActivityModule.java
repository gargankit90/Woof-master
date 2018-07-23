package co.touchlab.doglist.dagger.module;

import co.touchlab.doglist.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Ankit Garg on 10/28/17.
 */

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();
}
