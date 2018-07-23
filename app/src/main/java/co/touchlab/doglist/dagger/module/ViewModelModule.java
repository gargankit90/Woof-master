package co.touchlab.doglist.dagger.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import co.touchlab.doglist.dagger.ViewModelKey;
import co.touchlab.doglist.view.BreedListViewModel;
import co.touchlab.doglist.view.BreedListViewModelFactory;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Ankit Garg on 10/29/17.
 */

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(BreedListViewModel.class)
    abstract ViewModel bindBreedListViewModel(BreedListViewModel searchViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(BreedListViewModelFactory factory);
}
