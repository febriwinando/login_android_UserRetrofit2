package com.example.applogin.model;

import com.example.applogin.api.ResponseInsert;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AddListMovie {
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseInsert> addIdMovie(
            @Field("username") String username,
            @Field("password") String password
    );
}
