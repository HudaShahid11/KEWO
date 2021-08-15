package com.kewo.huda;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.share.widget.ShareDialog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class signup extends AppCompatActivity implements View.OnClickListener{
    private TextView signin,visit;
    private Button login;
    Session session;
    private EditText email , password;
    Url url = new Url();
    String link = url.getUrl();
    ProgressDialog dialog;
    ImageButton fb,wapp;
    ShareDialog shareDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signin = findViewById(R.id.signin);
        session = new Session(getApplicationContext());
        dialog = new ProgressDialog(this);
        shareDialog = new ShareDialog(this);
        fb= findViewById(R.id.fb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ShareLinkContent linkContent = new ShareLinkContent.Builder().setQuote("").setContentUrl(Uri.parse("https://play.google.com/store/apps/details?id=com.kewo.huda")).build();
//                if(ShareDialog.canShow(ShareLinkContent.class)){
//                    shareDialog.show(linkContent);
//                }
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.kewo.huda");
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.facebook.katana");
                startActivity(sendIntent);
            }
        });
        wapp = findViewById(R.id.wapp);
        wapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.kewo.huda");
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(),signin.class);
                startActivity(intent);

            }
        });
        visit = findViewById(R.id.visit);
        visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(),guest.class);
                startActivity(intent);

            }
        });

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        login.setOnClickListener(this);
        if(session.getlogin()){
            startActivity(new Intent(getApplicationContext(),home.class));
        }

    }
    private void insertUser(){
        //Here we will handle the http request to insert user to mysql db
        //Creating a RestAdapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(link) //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        signup_api api = adapter.create(signup_api.class);

        //Defining the method insertuser of our interface
        api.insertUser(

                //Passing the values by getting it from editTexts


                email.getText().toString(),
                password.getText().toString(),

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

                        if(output.equals("Something went wrong") || output.equals("Empty Fields") || output.equals("Not a Post request")){
                            AlertDialog.Builder builder
                                    = new AlertDialog
                                    .Builder(signup.this);


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
                            session.setlogin(true);
                            session.setphone("");
                            session.setcnic("");
                            session.setemail(email.getText().toString().trim());
                            session.setid(output);
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
                                .Builder(signup.this);


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
    //Overriding onclick method
    @Override
    public void onClick(View v) {
        //Calling insertUser on button click
        if(email.getText().toString().trim().length() == 0 || password.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Fill all fields",Toast.LENGTH_LONG).show();
        }
        else{
            dialog.setTitle("Loading...");
            dialog.setMessage("Please wait...");
            dialog.setCancelable(false); // disable dismiss by tapping outside of the dialog
            dialog.show();
            insertUser();
        }

    }
}
