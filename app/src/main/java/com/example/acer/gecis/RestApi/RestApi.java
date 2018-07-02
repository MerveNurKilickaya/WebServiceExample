package com.example.acer.gecis.RestApi;

import com.example.acer.gecis.Models.Bilgi;
import com.example.acer.gecis.Models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {
    @GET("/comments")
    Call<List<Bilgi>> getir();
    @GET("/comments")
    Call<List<Result>> getirResult(@Query("postId") String postid,@Query("id") String id);
}
