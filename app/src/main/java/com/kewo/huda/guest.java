package com.kewo.huda;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class guest extends AppCompatActivity implements View.OnClickListener{
EditText username,cnic,phone;
Button visit;
Url url = new Url();
String link = url.getUrl();
ProgressDialog dialog;
Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        username = findViewById(R.id.username);
        cnic = findViewById(R.id.cnic);
        phone = findViewById(R.id.phone);
        visit = findViewById(R.id.visit);
        session = new Session(getApplicationContext());
        dialog = new ProgressDialog(this);
        visit.setOnClickListener(this);


    }
    private void insertUser(){
        //Here we will handle the http request to insert user to mysql db
        //Creating a RestAdapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(link) //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        guest_api api = adapter.create(guest_api.class);

        //Defining the method insertuser of our interface
        api.insertUser(

                //Passing the values by getting it from editTexts

                username.getText().toString(),
                cnic.getText().toString(),
                phone.getText().toString(),

                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {
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
                        if(output.equals("Something went wrong") || output.equals("Empty Fields") || output.equals("Not a Post request")){
                            AlertDialog.Builder builder
                                    = new AlertDialog
                                    .Builder(guest.this);


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
                        //Displaying the output as a toast

                        else{
                            session.setlogin(true);
                            session.setemail("");
                            session.setid(output);
                            session.setcnic(cnic.getText().toString().trim());
                            session.setphone(phone.getText().toString().trim());
                            Intent intent;
                            intent = new Intent(getBaseContext(),home.class);
                            startActivity(intent);

                            finish();
                        }

                    }



                    @Override
                    public void failure(RetrofitError error) {
                        dialog.dismiss();
                        AlertDialog.Builder builder
                                = new AlertDialog
                                .Builder(guest.this);


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
        if(phone.getText().toString().trim().length() == 0||username.getText().toString().trim().length() == 0||cnic.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Fill our fields",Toast.LENGTH_LONG).show();
        }

        else {
            dialog.setTitle("Loading...");
            dialog.setMessage("Please wait...");
            dialog.setCancelable(false); // disable dismiss by tapping outside of the dialog
            dialog.show();
            insertUser();
        }

    }
}
