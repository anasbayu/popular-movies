package bayu.anas.com.popularmovie.Network;

import bayu.anas.com.popularmovie.model.ResultResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by AnasBayu on 04/07/2017.
 */

public interface APIInterface {
    @GET("movie/popular")
    Call<ResultResponse> getPopularMovies(
            @Query("api_key") String apiKey
    );

    @GET("movie/top_rated")
    Call<ResultResponse> getTopRatedMovies(
            @Query("api_key") String apiKey
    );
}
