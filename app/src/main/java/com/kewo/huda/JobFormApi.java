package com.kewo.huda;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Belal on 11/5/2015.
 */
public interface JobFormApi {
    @FormUrlEncoded
    @POST("/apps/job_reg")
    public void insertUser(

            @Field("job_id") int job_id,
            @Field("user_id") int user_id,
            @Field("name") String name,
            @Field("email") String email,
            @Field("cnic") String cnic,
            @Field("phone") String phone,
            @Field("qualification") String qualification,
            @Field("reason") String reason,

            Callback<Response> callback);
}
