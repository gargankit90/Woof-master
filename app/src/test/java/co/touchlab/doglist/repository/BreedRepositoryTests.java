package co.touchlab.doglist.repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import co.touchlab.doglist.DogService;
import co.touchlab.doglist.models.Breed;
import co.touchlab.doglist.models.ImageResult;
import co.touchlab.doglist.models.NameResult;
import io.reactivex.Observable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Ankit Garg on 1/3/18.
 */

public class BreedRepositoryTests {
    private BreedRepository repository;
    @Mock
    NameResult nameResult;
    @Mock
    ImageResult imageResult;
    @Mock
    DogService mockDogService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        repository = new BreedRepository(mockDogService);
    }

    @Test
    public void testLoadBreed() {
        Observable<NameResult> nameResultObservable = Observable.just(nameResult);
        Observable<ImageResult> imageResultObservable = Observable.just(imageResult);
        when(nameResult.getMessage()).
                thenReturn(Arrays.asList(
                        "affenpinscher",
                        "african",
                        "airedale",
                        "akita",
                        "appenzeller",
                        "basenji",
                        "beagle",
                        "bluetick",
                        "borzoi",
                        "bouvier",
                        "boxer"));
        when(imageResult.getMessage()).
                thenReturn("https://dog.ceo/api/img/terrier-dandie/n02096437_1641.jpg");
        when(mockDogService.getBreeds()).
                thenReturn(nameResultObservable);
        when(mockDogService.getImage(anyString())).
                thenReturn(imageResultObservable);
        Observable<Breed> breedObservable = repository.loadBreed();
        assertNotNull("Breed Object is not null", breedObservable.blockingFirst());
        assertEquals("Breed name is set properly ", "terrier", breedObservable.blockingFirst().getName());
    }
}
