package com.example.applogin.model;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServer {

    public static final String URL ="http://192.168.43.43/login/mobile/";

    private static Retrofit retrofit;

    public static Retrofit getClient()
    {
        if (retrofit ==  null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory( GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
