package com.kewo.huda;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobActivity extends AppCompatActivity implements JobsAdapter.ClickedItem{
    Toolbar toolbar;
    RecyclerView recyclerView;
    JobsAdapter usersAdapter;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job2);
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        usersAdapter = new JobsAdapter(this::ClickedUser);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading...");
        dialog.setMessage("Please wait...");
        dialog.setCancelable(false); // disable dismiss by tapping outside of the dialog
        dialog.show();
        getAllUsers();

    }
    public  void getAllUsers(){
        Call<List<JobResponse>> userlist = JobApiClient.getUserService().getAllJobs();
        userlist.enqueue(new Callback<List<JobResponse>>() {
            @Override
            public void onResponse(Call<List<JobResponse>> call, Response<List<JobResponse>> response) {
                if(response.isSuccessful()){

                    List<JobResponse> userResponses = response.body();
                    List<JobResponse> job = new ArrayList<>();
                    Intent intent = getIntent();
                    String industry = intent.getStringExtra("industry");

                    for(int i=0 ; i < userResponses.size(); i++){
                        if(userResponses.get(i).getIndustry().equals(industry)){

                            job.add(userResponses.get(i));
                        }
                    }


                    usersAdapter.setData(job);
                    recyclerView.setAdapter(usersAdapter);
                    dialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<JobResponse>> call, Throwable t) {
                dialog.dismiss();
                AlertDialog.Builder builder
                        = new AlertDialog
                        .Builder(JobActivity.this);


                builder.setMessage(t.getLocalizedMessage());
                builder.setTitle("Error");
                builder.setCancelable(false);
                        /*builder.setPositiveButton(
                                        "Exit",
                                        (dialog, which) -> {

                                            // When the user click yes button
                                            // then app will close
                                            finish();
                                        });*/
                builder
                        .setNegativeButton(
                                "Ok",
                                (dialog, which) -> {
                                    dialog.cancel();
                                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }

    @Override
    public void ClickedUser(JobResponse userResponse) {
        startActivity(new Intent(this,JobDetail.class).putExtra("data",userResponse));

    }
}

