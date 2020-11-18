package com.kewo.huda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class internship extends AppCompatActivity {
Button e_filing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internship);
        e_filing = findViewById(R.id.e_filing);
        e_filing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), CourseActivity.class);
                i.putExtra("category","internship_e_filing");
                startActivity(i);
            }
        });
    }

}
