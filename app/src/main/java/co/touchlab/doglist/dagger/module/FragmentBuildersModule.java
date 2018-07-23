package co.touchlab.doglist.dagger.module;

import co.touchlab.doglist.view.BreedListFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Ankit Garg on 10/28/17.
 */

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract BreedListFragment contributeBreedListFragment();
}

