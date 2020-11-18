package com.kewo.huda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class international extends AppCompatActivity {
Button pgd, safety,cisco_networking, cisco_infrastructure_automation, cisco_security, cisco_iot_and_data_analytics, cisco_os_and_it, cisco_programming, cisco_others;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_international);

        safety = findViewById(R.id.safety);
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), CourseActivity.class);
                i.putExtra("category","safecon_safety");
                startActivity(i);
            }
        });
        cisco_networking = findViewById(R.id.cisco_networking);
        cisco_networking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),CourseActivity.class);
                i.putExtra("category","cisco_networking");
                startActivity(i);
            }
        });
        cisco_infrastructure_automation = findViewById(R.id.cisco_infrastructure_automation);
        cisco_infrastructure_automation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),CourseActivity.class);
                i.putExtra("category","cisco_infrastructure_automation");
                startActivity(i);
            }
        });
        cisco_security = findViewById(R.id.cisco_security);
        cisco_security.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),CourseActivity.class);
                i.putExtra("category","cisco_security");
                startActivity(i);
            }
        });
        cisco_iot_and_data_analytics = findViewById(R.id.cisco_iot_and_data_analytics);
        cisco_iot_and_data_analytics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),CourseActivity.class);
                i.putExtra("category","cisco_iot_and_data_analytics");
                startActivity(i);
            }
        });
        cisco_os_and_it = findViewById(R.id.cisco_os_and_it);
        cisco_os_and_it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),CourseActivity.class);
                i.putExtra("category","cisco_os_and_it");
                startActivity(i);
            }
        });
        cisco_programming = findViewById(R.id.cisco_programming);
        cisco_programming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),CourseActivity.class);
                i.putExtra("category","cisco_programming");
                startActivity(i);
            }
        });
        cisco_others = findViewById(R.id.cisco_others);
        cisco_others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),CourseActivity.class);
                i.putExtra("category","cisco_others");
                startActivity(i);
            }
        });
    }
}
