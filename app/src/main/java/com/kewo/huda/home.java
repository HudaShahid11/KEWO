package com.kewo.huda;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class home extends AppCompatActivity {
    Dialog epicdialog;
    Button visit;
    Button close;
 ImageButton course;
 ImageButton category;
 ImageButton gallery;
 ImageButton job, profile,video,events,social,international,membership,internship,workshop;
 TextView first;
    Url url = new Url();
    String link = url.getUrl();
    String password = "123456";
    ProgressDialog dialog;
    String text ="Total Registration: ";
    String last_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        epicdialog = new Dialog(this);
        showPopup();
        first= findViewById(R.id.first);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading...");
        dialog.setMessage("Please wait...");
        dialog.setCancelable(false); // disable dismiss by tapping outside of the dialog
        dialog.show();
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(link) //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        CountApi api = adapter.create(CountApi.class);

        //Defining the method insertuser of our interface
        api.insertUser(

                //Passing the values by getting it from editTexts
                password,




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
                        last_text = text+output;
                        first.setText(last_text);






                    }



                    @Override
                    public void failure(RetrofitError error) {
                        dialog.dismiss();

                        first.setText("Loading..");


                    }
                }
        );

        course = findViewById(R.id.course);
        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),course.class);
                startActivity(intent);
            }
        });
        international = findViewById(R.id.international);
        international.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),international.class);
                startActivity(intent);
            }
        });
        workshop = findViewById(R.id.workshop);
        workshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),workshop.class);
                startActivity(intent);
            }
        });
       internship = findViewById(R.id.internship);
        internship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),internship.class);
                startActivity(intent);
            }
        });
        gallery = findViewById(R.id.gallery);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/pg/kewo4u/photos/"));
                startActivity(intent);
            }
        });
        job = findViewById(R.id.job);
        job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),job.class);
                startActivity(intent);
            }
        });
        membership = findViewById(R.id.membership);
        membership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),membership_about.class);
                startActivity(intent);
            }
        });
//        profile = findViewById(R.id.profile);
//        profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getBaseContext(),profile.class);
//                startActivity(intent);
//            }
//        });
        social = findViewById(R.id.social);
        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),social.class);
                startActivity(intent);
            }
        });
        video = findViewById(R.id.video);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCspIAEN70nTgCFexoweb0Gw"));
                startActivity(intent);
            }
        });

        events = findViewById(R.id.events);
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/pg/kewo4u/events/"));
                startActivity(intent);
            }
        });
    }
    public void showPopup(){
        epicdialog.setContentView(R.layout.epic_popup);
        close = epicdialog.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                epicdialog.dismiss();
            }
        });
        visit= epicdialog.findViewById(R.id.visit);
        visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),international.class);
                startActivity(i);
            }
        });
        epicdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicdialog.show();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
