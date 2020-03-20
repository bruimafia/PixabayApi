package ru.bruimafia.rx.api;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.bruimafia.rx.pojo.ImagesResponse;

public interface ApiService {

    @GET("?key=12509481-d4dac1b6d0057180c8643284a&per_page=10")
    Observable<ImagesResponse> getImages(@Query("q") String q, @Query("order") String order, @Query("page") int page);

}
