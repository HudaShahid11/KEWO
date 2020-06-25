package com.kewo.huda;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Belal on 11/5/2015.
 */
public interface guest_api {
    @FormUrlEncoded
    @POST("/apps/guest")
    public void insertUser(

            @Field("name") String name,
            @Field("cnic") String cnic,
            @Field("phone") String phone,

            Callback<Response> callback);
}
