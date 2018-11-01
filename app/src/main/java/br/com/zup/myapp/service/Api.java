package br.com.zup.myapp.service;


import br.com.zup.myapp.model.SearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("/")
    Call<SearchResponse> getSearch(@Query("t") String search,
                                   @Query("apiKey") String key);
}