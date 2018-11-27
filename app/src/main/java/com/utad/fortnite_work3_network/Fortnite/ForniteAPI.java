package com.utad.fortnite_work3_network.Fortnite;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ForniteAPI {

    @Headers("TRN-Api-Key: 48057d93-96dc-41a1-b740-2a3e605ee4e9")
    @GET("v1/profile/{platform}/{epic-nickname}")
    Observable<UserFortnite> getFortniteInfo(@Path("platform") String platform, @Path("epic-nickname") String epic_nickname);


    static ForniteAPI Factory(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(" https://api.fortnitetracker.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit.create(ForniteAPI.class);
    }
}