package com.kewo.huda;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class membership_form extends AppCompatActivity implements View.OnClickListener {
    EditText cnic, education, email, name, phone, address, dob;
    private Session session;
    RadioButton male, female;
    Button submit;
    RadioGroup radioGroup;
    Url url = new Url();
    String link = url.getUrl();
    RadioButton genderradioButton;
    ProgressDialog dialog;
    CheckBox kewo,rotract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership_form);
        name = findViewById(R.id.name);
        cnic = findViewById(R.id.cnic);
        education = findViewById(R.id.education);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        dob = findViewById(R.id.dob);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        submit = findViewById(R.id.submit);
        kewo = findViewById(R.id.kewo);
        rotract = findViewById(R.id.rotract);
        dialog = new ProgressDialog(this);


        radioGroup = findViewById(R.id.radio_group);


        session = new Session(getApplicationContext());
        email.setText(session.getemail());
        phone.setText(session.getphone());
        cnic.setText(session.getcnic());
        submit.setOnClickListener(this);
    }
    private void insertUser(){
        //Here we will handle the http request to insert user to mysql db
        //Creating a RestAdapter
        radioGroup=(RadioGroup)findViewById(R.id.radio_group);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        genderradioButton = (RadioButton) findViewById(selectedId);
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(link) //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        membership_form_api api = adapter.create(membership_form_api.class);

        //Defining the method insertuser of our interface
        api.insertUser(



                kewo.isChecked(),
                rotract.isChecked(),
                name.getText().toString(),
                email.getText().toString(),
                cnic.getText().toString(),
                phone.getText().toString(),
                genderradioButton.getText().toString(),
                dob.getText().toString(),
                education.getText().toString(),
                address.getText().toString(),

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
                        if(output.equals("Something went wrong") ){
                            AlertDialog.Builder builder
                                    = new AlertDialog
                                    .Builder(membership_form.this);


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
                                    .Builder(membership_form.this);


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
//                                                Intent intent;
//                                                intent = new Intent(getBaseContext(),membership.class);
//                                                startActivity(intent);
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
                                .Builder(membership_form.this);


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
        radioGroup=(RadioGroup)findViewById(R.id.radio_group);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        genderradioButton = (RadioButton) findViewById(selectedId);
        //Calling insertUser on button click
        if(kewo.isChecked() == false){
            Toast.makeText(this,"Select KEWO.",Toast.LENGTH_LONG).show();

        }
        else if(name.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter name",Toast.LENGTH_LONG).show();
        }
        else if(email.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter Email",Toast.LENGTH_LONG).show();
        }
        else if(cnic.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter Cnic",Toast.LENGTH_LONG).show();
        }


        else if(phone.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter phone number",Toast.LENGTH_LONG).show();
        }
        else if((selectedId==-1)){
            Toast.makeText(this,"Select gender",Toast.LENGTH_LONG).show();
        }
        else if(dob.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter Date of birth",Toast.LENGTH_LONG).show();
        }
        else if(education.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter Education",Toast.LENGTH_LONG).show();
        }
        else if(address.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter Address",Toast.LENGTH_LONG).show();
        }
        else{
            dialog.setTitle("Loading...");
            dialog.setMessage("Please wait...");
            dialog.setCancelable(false); // disable dismiss by tapping outside of the dialog
            dialog.show();
            insertUser();}
    }
}