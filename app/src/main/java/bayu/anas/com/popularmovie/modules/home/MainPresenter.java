package bayu.anas.com.popularmovie.modules.home;

import java.util.ArrayList;
import java.util.List;

import bayu.anas.com.popularmovie.Network.APIInterface;
import bayu.anas.com.popularmovie.adapter.MovieAdapter;
import bayu.anas.com.popularmovie.model.Movie;
import bayu.anas.com.popularmovie.model.ResultResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AnasBayu on 04/07/2017.
 */

public class MainPresenter {

    private MainView mView;
    private Retrofit retrofit;

    public MainPresenter(MainView mView, String baseUrl) {
        this.mView = mView;

        retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void getPopularMovies(String apiKey, final MovieAdapter adapter){
        mView.onProgress();

        APIInterface iApi = retrofit.create(APIInterface.class);
        Call<ResultResponse> data = iApi.getPopularMovies(apiKey);
        data.enqueue(new Callback<ResultResponse>() {
            @Override
            public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                List<Movie> movies = new ArrayList<>();
                movies.addAll( response.body().getResults());
                adapter.setData(movies);
                mView.onFinished();
            }

            @Override
            public void onFailure(Call<ResultResponse> call, Throwable t) {
                t.printStackTrace();
                mView.onFinished();
            }
        });
    }

    public void getTopRatedMovies(String apiKey, final MovieAdapter adapter){
        mView.onProgress();

        APIInterface iApi = retrofit.create(APIInterface.class);
        Call<ResultResponse> data = iApi.getTopRatedMovies(apiKey);
        data.enqueue(new Callback<ResultResponse>() {
            @Override
            public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                List<Movie> movies = new ArrayList<>();
                movies.addAll( response.body().getResults());
                adapter.setData(movies);
                mView.onFinished();
            }

            @Override
            public void onFailure(Call<ResultResponse> call, Throwable t) {
                t.printStackTrace();
                mView.onFinished();
            }
        });
    }
}
