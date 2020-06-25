package com.kewo.huda;



import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;


public interface signup_api {
    @FormUrlEncoded
    @POST("/apps/login")
    public void insertUser(
            @Field("email") String email,
            @Field("password") String password,
            Callback<Response> callback);
}
