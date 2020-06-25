package com.kewo.huda;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Belal on 11/5/2015.
 */
public interface profile_user {
    @FormUrlEncoded
    @POST("/apps/user_course")
    public void course(

            @Field("user_id") int user_id,
            Callback<Response> callback);

    @FormUrlEncoded
    @POST("/apps/user_job")
    public void job(

            @Field("user_id") int user_id,
            Callback<Response> callback);
}
