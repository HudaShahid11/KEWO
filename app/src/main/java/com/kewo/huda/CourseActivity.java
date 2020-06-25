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

public class CourseActivity extends AppCompatActivity implements CoursesAdapter.ClickedItem{
    Toolbar toolbar;
    RecyclerView recyclerView;
    CoursesAdapter usersAdapter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course2);
        dialog = new ProgressDialog(this);
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        usersAdapter = new CoursesAdapter(this::ClickedUser);
        dialog.setTitle("Loading...");
        dialog.setMessage("Please wait...");
        dialog.setCancelable(false); // disable dismiss by tapping outside of the dialog
        dialog.show();
        getAllUsers();

    }
    public  void getAllUsers(){
        Call<List<CourseResponse>> userlist = CourseApiClient.getUserService().getAllCourses();
        userlist.enqueue(new Callback<List<CourseResponse>>() {
            @Override
            public void onResponse(Call<List<CourseResponse>> call, Response<List<CourseResponse>> response) {
                if(response.isSuccessful()){

                    List<CourseResponse> userResponses = response.body();
                    List<CourseResponse> course = new ArrayList<>();
                    Intent intent = getIntent();
                    String category = intent.getStringExtra("category");

                    for(int i=0 ; i < userResponses.size(); i++){
                        if(userResponses.get(i).getCategory().equals(category)){

                            course.add(userResponses.get(i));
                        }
                    }


                    usersAdapter.setData(course);
                    recyclerView.setAdapter(usersAdapter);
                    dialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<CourseResponse>> call, Throwable t) {
                dialog.dismiss();
                AlertDialog.Builder builder
                        = new AlertDialog
                        .Builder(CourseActivity.this);


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
    public void ClickedUser(CourseResponse userResponse) {
        startActivity(new Intent(this,CourseDetail.class).putExtra("data",userResponse));

    }
}

