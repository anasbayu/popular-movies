package bayu.anas.com.popularmovie.Network;

import bayu.anas.com.popularmovie.model.ResultResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by AnasBayu on 04/07/2017.
 */

public interface APIInterface {
    @GET("movie/{sort}")
    Call<ResultResponse> getMovie(
            @Path("sort") String order,
            @Query("api_key") String apiKey
    );
}
