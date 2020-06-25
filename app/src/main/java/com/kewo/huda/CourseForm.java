package com.kewo.huda;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CourseForm extends AppCompatActivity implements View.OnClickListener{
    TextView title;
    CourseResponse userResponse;

    EditText cnic , qualification,reason,email,name,phone;
    Button register;
    Url url = new Url();
    String link = url.getUrl();

    private Session session;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_form);
        title =  findViewById(R.id.title);
        name = findViewById(R.id.name);
        cnic = findViewById(R.id.cnic);
        qualification = findViewById(R.id.qualification);
        reason = findViewById(R.id.reason);
        email= findViewById(R.id.email);
        register = findViewById(R.id.register);
        phone = findViewById(R.id.phone);
        session = new Session(getApplicationContext());
        email.setText(session.getemail());
        phone.setText(session.getphone());
        cnic.setText(session.getcnic());
        dialog = new ProgressDialog(this);


        Intent intent = getIntent();
        if(intent.getExtras() != null){
            userResponse = (CourseResponse) intent.getSerializableExtra("data");
            String title_data = userResponse.getTitle();
            title.setText(title_data);
        }
        register.setOnClickListener(this);

    }
    private void insertUser(){
        //Here we will handle the http request to insert user to mysql db
        //Creating a RestAdapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(link) //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        CourseFormApi api = adapter.create(CourseFormApi.class);

        //Defining the method insertuser of our interface
        api.insertUser(


                userResponse.getId(),
                session.getid(),
                name.getText().toString(),
                email.getText().toString(),
                cnic.getText().toString(),
                phone.getText().toString(),
                qualification.getText().toString(),
                reason.getText().toString(),

                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        dialog.dismiss();
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

                        //Displaying the output as a toast
                        if(output.equals("Something went wrong") || output.equals("Enter CNIC") || output.equals("Not a Post request")){
                            AlertDialog.Builder builder
                                    = new AlertDialog
                                    .Builder(CourseForm.this);


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
                        else if (output.equals("Registered")){
                            AlertDialog.Builder builder
                                    = new AlertDialog
                                    .Builder(CourseForm.this);


                            builder.setMessage("Your form has been submitted");
                            builder.setTitle("Success");
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
                                                Intent intent;
                                                intent = new Intent(getBaseContext(),home.class);
                                                startActivity(intent);
                                                finish();
                                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                            }

                    }



                    @Override
                    public void failure(RetrofitError error) {
                        dialog.dismiss();
                        AlertDialog.Builder builder
                                = new AlertDialog
                                .Builder(CourseForm.this);


                        builder.setMessage("Try Again!!");
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
    @Override
    public void onClick(View v) {
        //Calling insertUser on button click
        if(name.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter name",Toast.LENGTH_LONG).show();
        }
        else if(cnic.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter Cnic",Toast.LENGTH_LONG).show();
        }


        else if(phone.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter phone number",Toast.LENGTH_LONG).show();
        }

        else{
            dialog.setTitle("Loading...");
            dialog.setMessage("Please wait...");
            dialog.setCancelable(false); // disable dismiss by tapping outside of the dialog
            dialog.show();
            insertUser();}
    }
}

