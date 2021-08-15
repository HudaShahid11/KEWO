package com.kewo.huda;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
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

public class CourseForm extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{
    TextView title;
    CourseResponse userResponse;
    RadioGroup radioGroup,radioGroup2,radioGroup3;
    RadioButton radioButton,radioButton2,radioButton3;
    int selectedId,selectedId2,selectedId3;
    EditText fname,lname,fathername,address,contact_number_1,contact_number_2,email,date_of_birth,age,cnic_b_form,qualification,skills,referred_by;
    Button register;
    Url url = new Url();
    String link = url.getUrl();

    private Session session;
    ProgressDialog dialog;
    String district;
    String[] country = {"Badin","Dadu","Ghotki","Hyderabad","Jacobabad","Jamshoro","Karachi Central","Karachi East","Karachi South","Karachi West","Korangi","Malir","Kashmore","Khairpur","Larkana","Matiari","Mirpur Khas","Naushahro Firoze","Shaheed Benazirabad","Qambar Shahdadkot","Sanghar","Shikarpur","Sukkur","Tando Allahyar","Tando Muhammad Khan","Tharparkar","Thatta","Umerkot","Sujawal"};


    Spinner spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_form);
        title =  findViewById(R.id.title);
        fname= findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        fathername = findViewById(R.id.father_name);
        address = findViewById(R.id.address);
        contact_number_1=findViewById(R.id.contact_number_1);
        contact_number_2= findViewById(R.id.contact_number_2);
        email = findViewById(R.id.email_address);
        date_of_birth = findViewById(R.id.date_of_birth);
        age= findViewById(R.id.age);
        cnic_b_form = findViewById(R.id.cnic_b_form);
        qualification= findViewById(R.id.qualification);
        skills = findViewById(R.id.skills);
        referred_by = findViewById(R.id.referred_by);
        radioGroup = findViewById(R.id.radio_group);
        radioGroup.clearCheck();
        radioGroup2 = findViewById(R.id.radio_group2);
        radioGroup2.clearCheck();
        radioGroup3 = findViewById(R.id.radio_group3);
        radioGroup3.clearCheck();
        radioGroup.setOnCheckedChangeListener(
                (group, checkedId) -> {

                    // Get the selected Radio Button

                    radioButton
                            = group
                            .findViewById(checkedId);
                });
        radioGroup2.setOnCheckedChangeListener(
                (group, checkedId) -> {

                    // Get the selected Radio Button

                    radioButton2
                            = group
                            .findViewById(checkedId);
                });
        radioGroup3.setOnCheckedChangeListener(
                (group, checkedId) -> {

                    // Get the selected Radio Button

                    radioButton3
                            = group
                            .findViewById(checkedId);
                });
        spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        register = findViewById(R.id.register);

        session = new Session(getApplicationContext());
        email.setText(session.getemail());
        contact_number_1.setText(session.getphone());
        cnic_b_form.setText(session.getcnic());
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
                fname.getText().toString(),
                lname.getText().toString(),
                fathername.getText().toString(),
                radioButton3.getText().toString(),
                district,
                address.getText().toString(),
                contact_number_1.getText().toString(),
                contact_number_2.getText().toString(),
                email.getText().toString(),
                date_of_birth.getText().toString(),
                age.getText().toString(),
                cnic_b_form.getText().toString(),
                title.getText().toString(),
                userResponse.getCategory(),
                radioButton.getText().toString(),
                qualification.getText().toString(),
                skills.getText().toString(),
                radioButton2.getText().toString(),
                referred_by.getText().toString(),
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
                        AlertDialog.Builder builder
                                = new AlertDialog
                                .Builder(CourseForm.this);


                        builder.setMessage(output);
                        builder.setTitle("Message");
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
        selectedId = radioGroup.getCheckedRadioButtonId();
        selectedId2 = radioGroup2.getCheckedRadioButtonId();
        selectedId3 = radioGroup3.getCheckedRadioButtonId();
        if(fname.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter first name",Toast.LENGTH_LONG).show();
        }
        else if(lname.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter last name",Toast.LENGTH_LONG).show();
        }
        else if(fathername.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter father name",Toast.LENGTH_LONG).show();
        }
        else if(email.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter email",Toast.LENGTH_LONG).show();
        }
        else if(contact_number_1.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter contact number 1",Toast.LENGTH_LONG).show();
        }
        else if(contact_number_2.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter contact number 2",Toast.LENGTH_LONG).show();
        }
        else if(date_of_birth.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter date of birth",Toast.LENGTH_LONG).show();
        }
        else if(age.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter age",Toast.LENGTH_LONG).show();
        }
        else if (selectedId == -1) {
            Toast.makeText(CourseForm.this,
                    "Select gender",
                    Toast.LENGTH_LONG)
                    .show();
        }
        else if(cnic_b_form.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter CNIC OR B-Form",Toast.LENGTH_LONG).show();
        }
        else if (selectedId3 == -1) {
            Toast.makeText(CourseForm.this,
                    "Select option for street youth",
                    Toast.LENGTH_LONG)
                    .show();
        }
        else if(address.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter address",Toast.LENGTH_LONG).show();
        }
        else if(qualification.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Enter qualification",Toast.LENGTH_LONG).show();
        }
        else if(skills.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Mention Skills",Toast.LENGTH_LONG).show();
        }
        else if (selectedId2 == -1) {
            Toast.makeText(CourseForm.this,
                    "Select program",
                    Toast.LENGTH_LONG)
                    .show();
        }
//        else if ((userResponse.getCategory().equals("internship_e_filing")) &&  !(selectedId2 == 0)) {
//            Toast.makeText(CourseForm.this,
//                    "Select Weekdays for this internship",
//                    Toast.LENGTH_LONG)
//                    .show();
//        }

        else{
            radioButton = radioGroup.findViewById(selectedId);
            radioButton2 = radioGroup2.findViewById(selectedId2);
            dialog.setTitle("Loading...");
            dialog.setMessage("Please wait...");
            dialog.setCancelable(false); // disable dismiss by tapping outside of the dialog
            dialog.show();
            insertUser();}
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        district =country[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

