package com.kewo.huda;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Belal on 11/5/2015.
 */
public interface CourseFormApi {
    @FormUrlEncoded
    @POST("/apps/register_form_app2")
    public void insertUser(

            @Field("course_id") int course_id,
            @Field("user_id") int user_id,
            @Field("fname") String fname,
            @Field("lname") String lname,
            @Field("fathername") String fathername,
            @Field("street_youth") String street_youth,
            @Field("district") String district,
            @Field("address") String address,
            @Field("contact_number_1") String contact_number_1,
            @Field("contact_number_2") String contact_number_2,
            @Field("email") String email,
            @Field("date_of_birth") String date_of_birth,
            @Field("age") String age,
            @Field("cnic_b_form") String cnic_b_form,
            @Field("course") String course,
            @Field("category") String category,
            @Field("gender") String gender,
            @Field("qualification") String qualification,
            @Field("skills") String skills,
            @Field("program") String program,
            @Field("referred_by") String referred_by,




            Callback<Response> callback);
}
