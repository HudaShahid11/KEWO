package com.kewo.huda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class workshop extends AppCompatActivity {
    Button finance,technology,language,vocational,standard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop);
        finance = findViewById(R.id.finance);
        finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), CourseActivity.class);
                i.putExtra("category","workshop_finance");
                startActivity(i);
            }
        });
        technology = findViewById(R.id.technology);
        technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), CourseActivity.class);
                i.putExtra("category","workshop_technology");
                startActivity(i);
            }
        });
        language = findViewById(R.id.language);
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), CourseActivity.class);
                i.putExtra("category","workshop_language");
                startActivity(i);
            }
        });
        vocational = findViewById(R.id.vocational);
        vocational.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), CourseActivity.class);
                i.putExtra("category","workshop_vocational");
                startActivity(i);
            }
        });
        standard = findViewById(R.id.standard);
        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), CourseActivity.class);
                i.putExtra("category","workshop_standard");
                startActivity(i);
            }
        });
    }
}
