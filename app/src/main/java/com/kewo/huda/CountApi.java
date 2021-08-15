package com.kewo.huda;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Belal on 11/5/2015.
 */
public interface CountApi {
    @FormUrlEncoded
    @POST("/apps/counter")
    public void insertUser(

            @Field("password") String password,


            Callback<Response> callback);
}
