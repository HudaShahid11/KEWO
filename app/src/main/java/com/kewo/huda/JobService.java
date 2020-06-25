package com.kewo.huda;




import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JobService {
    @GET("apps/jobs")
    Call<List<JobResponse>> getAllJobs();
}

