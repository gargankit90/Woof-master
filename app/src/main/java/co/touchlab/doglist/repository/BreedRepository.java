package co.touchlab.doglist.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import co.touchlab.doglist.DogService;
import co.touchlab.doglist.models.Breed;
import io.reactivex.Observable;

/**
 * Created by Ankit Garg on 12/21/17.
 */

@Singleton
public class BreedRepository {
    private final DogService dogService;

    @Inject
    BreedRepository(DogService dogService) {
        this.dogService = dogService;
    }

    public Observable<Breed> loadBreed() {
        return dogService.getBreeds()
                .flatMap(nameResult -> Observable.just(nameResult.getMessage()))
                .flatMapIterable(listOfBreeds -> listOfBreeds)
                .flatMap(breedName -> dogService.getImage(breedName))
                .flatMap(imageResult -> {
                    Breed breed = new Breed();
                    breed.setImageURL(imageResult.getMessage());
                    String[] urlParts = imageResult.getMessage().split("-|/");
                    String breedName = urlParts[5];
                    breed.setName(breedName);
                    return Observable.just(breed);
                });
    }
}

