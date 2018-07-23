package co.touchlab.doglist;

import co.touchlab.doglist.models.ImageResult;
import co.touchlab.doglist.models.NameResult;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DogService {
    @GET("breeds/list")
    Observable<NameResult> getBreeds();

    @GET("breed/{name}/images/random")
    Observable<ImageResult> getImage(@Path("name") String name);
}
