package com.kewo.huda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class JobDetail extends AppCompatActivity {
TextView designation,company,dept,criteria, exp ,req,loc,shift,res,gender,age;
TextView age_t,shift_t;
JobResponse userResponse;
Button apply;
ImageButton fb,wapp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);
        designation = findViewById(R.id.designation);
        criteria = findViewById(R.id.criteria);
        exp = findViewById(R.id.exp);
        req = findViewById(R.id.req);
        loc = findViewById(R.id.loc);
        shift = findViewById(R.id.shift);
        res = findViewById(R.id.res);
        company = findViewById(R.id.company);
        dept = findViewById(R.id.dept);
        apply = findViewById(R.id.apply);
        gender = findViewById(R.id.gender);
        age = findViewById(R.id.age);
        shift_t = findViewById(R.id.shift_t);
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
        Intent intent = getIntent();
        if(intent.getExtras() != null){
            userResponse = (JobResponse) intent.getSerializableExtra("data");
            designation.setText(userResponse.getDesignation());
            if(userResponse.getCompany().equals("")){

                company.setText("-");

            }
            else{
                company.setText(userResponse.getCompany());
            }

            if(userResponse.getDepartment().equals("")){

                dept.setText("-");

            }
            else{
                dept.setText(userResponse.getDepartment());
            }


            if(userResponse.getEligibility_criteria().equals("")){

                criteria.setText("-");

            }
            else{
                criteria.setText(userResponse.getEligibility_criteria());
            }

            if(userResponse.getExperience().equals("")){

                exp.setText("-");

            }
            else{
                exp.setText(userResponse.getExperience());
            }
            if(userResponse.getOther_requirements().equals("")){

                req.setText("-");

            }
            else{
                req.setText(userResponse.getOther_requirements());
            }

            if(userResponse.getLocation().equals("")){

                loc.setText("-");

            }
            else{
                loc.setText(userResponse.getLocation());
            }
            if(userResponse.getAge().equals("")){

                age.setText("-");

            }
            else{
                age.setText(userResponse.getAge());
            }
            if(userResponse.getShift().equals("")){

                shift.setText("-");

            }
            else{
                shift.setText(userResponse.getShift());
            }
            if(userResponse.getResponsibilities().equals("")){

                res.setText("-");

            }
            else{
                res.setText(userResponse.getResponsibilities());
            }
            if(userResponse.getGender().equals("")){

                gender.setText("-");

            }
            else{
                gender.setText(userResponse.getGender());
            }



            apply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getBaseContext(),JobForm.class);
                    i.putExtra("data",userResponse);
                    startActivity(i);

                }
            });



    }

}}
