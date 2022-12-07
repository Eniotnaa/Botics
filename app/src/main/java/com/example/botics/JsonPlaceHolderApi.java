package com.example.botics;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("test.php")
    Call<List<User>> getUser();
}
