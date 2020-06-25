package com.kewo.huda;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class profile extends AppCompatActivity {
TextView course_reg,job_reg,id,email;
Button course,job;
Session session;
public static final String ROOT_URL = "http://kewo.org/app/kewo_app";
ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        course_reg = findViewById(R.id.course_reg);
        job_reg = findViewById(R.id.job_reg);
        course = findViewById(R.id.course);
        session = new Session(getApplicationContext());
        email = findViewById(R.id.email);
        email.setText(session.getemail());
        id = findViewById(R.id.id);

        id.setText(session.getIdInString());
        dialog = new ProgressDialog(this);

        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setTitle("Loading...");
                dialog.setMessage("Please wait...");
                dialog.setCancelable(false); // disable dismiss by tapping outside of the dialog
                dialog.show();
                RestAdapter adapter = new RestAdapter.Builder()
                        .setEndpoint(ROOT_URL) //Setting the Root URL
                        .build(); //Finally building the adapter

                //Creating object for our interface
                profile_user api = adapter.create(profile_user.class);

                //Defining the method insertuser of our interface
                api.course(

                        //Passing the values by getting it from editTexts

                        session.getid(),


                        //Creating an anonymous callback
                        new Callback<Response>() {


                            @Override
                            public void success(Response result, Response response) {
                                //On success we will read the server's output using bufferedreader
                                //Creating a bufferedreader object
                                BufferedReader reader = null;

                                //An string to store output from the server
                                String output = "";

                                try {
                                    //Initializing buffered reader
                                    reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                                    //Reading the output in the string
                                    output = reader.readLine();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                    dialog.dismiss();

                                    course_reg.setText(output);



                            }



                            @Override
                            public void failure(RetrofitError error) {
                                dialog.dismiss();
                                AlertDialog.Builder builder
                                        = new AlertDialog
                                        .Builder(profile.this);


                                builder.setMessage(error.toString());
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
                        }
                );
            }
        });
        job=findViewById(R.id.job);
        job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setTitle("Loading...");
                dialog.setMessage("Please wait...");
                dialog.setCancelable(false); // disable dismiss by tapping outside of the dialog
                dialog.show();
                RestAdapter adapter = new RestAdapter.Builder()
                        .setEndpoint(ROOT_URL) //Setting the Root URL
                        .build(); //Finally building the adapter

                //Creating object for our interface
                profile_user api = adapter.create(profile_user.class);

                //Defining the method insertuser of our interface
                api.job(

                        //Passing the values by getting it from editTexts

                        session.getid(),


                        //Creating an anonymous callback
                        new Callback<Response>() {


                            @Override
                            public void success(Response result, Response response) {
                                //On success we will read the server's output using bufferedreader
                                //Creating a bufferedreader object
                                BufferedReader reader = null;

                                //An string to store output from the server
                                String output = "";

                                try {
                                    //Initializing buffered reader
                                    reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                                    //Reading the output in the string
                                    output = reader.readLine();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                if(output.equals("Not a Post request")){
                                    AlertDialog.Builder builder
                                            = new AlertDialog
                                            .Builder(profile.this);


                                    builder.setMessage(output);
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
                                else{
                                    dialog.dismiss();
                                    job_reg.setText(output);


                                }

                            }



                            @Override
                            public void failure(RetrofitError error) {
                                dialog.dismiss();
                                AlertDialog.Builder builder
                                        = new AlertDialog
                                        .Builder(profile.this);


                                builder.setMessage(error.toString());
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
                        }
                );
            }
        });

    }


    }
