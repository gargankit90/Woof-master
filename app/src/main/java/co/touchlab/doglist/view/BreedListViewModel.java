package co.touchlab.doglist.view;

import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import co.touchlab.doglist.models.Breed;
import co.touchlab.doglist.repository.BreedRepository;
import io.reactivex.Observable;

/**
 * Created by Ankit Garg on 10/28/17.
 */

public class BreedListViewModel extends ViewModel {

    private Observable<Breed> breedObservable;

    @Inject
    public BreedListViewModel(BreedRepository breedRepository) {
        breedObservable = breedRepository.loadBreed()
                .cache();
    }

    public Observable<Breed> getBreedObservable() {
        return breedObservable;
    }
}