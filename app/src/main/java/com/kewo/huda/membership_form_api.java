package com.kewo.huda;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Belal on 11/5/2015.
 */
public interface membership_form_api {
    @FormUrlEncoded
    @POST("/apps/membership")
    public void insertUser(

            @Field("kewo") Boolean kewo,
            @Field("rotract") Boolean rotract,
            @Field("name") String name,
            @Field("email") String email,
            @Field("cnic") String cnic,
            @Field("phone") String phone,
            @Field("gender") String gender,
            @Field("dob") String dob,
            @Field("education") String education,
            @Field("address") String address,

            Callback<Response> callback);
}
