package com.kewo.huda;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CourseService {
    @GET("apps/courses")
    Call<List<CourseResponse>> getAllCourses();
}

