package com.kewo.huda;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class job extends AppCompatActivity {
Button banking,content_writing,engineering,food,health,it,marketing,media,pharmaceutical,textile,welfare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        banking = findViewById(R.id.banking);
        banking.setOnClickListener(v -> {
            Intent i = new Intent(getBaseContext(),JobActivity.class);
            i.putExtra("industry","Banking");
            startActivity(i);
        });

        content_writing = findViewById(R.id.content_writing);
        content_writing.setOnClickListener(v -> {
            Intent i = new Intent(getBaseContext(),JobActivity.class);
            i.putExtra("industry","Content Writing");
            startActivity(i);
        });
        engineering = findViewById(R.id.engineering);
        engineering.setOnClickListener(v -> {
            Intent i = new Intent(getBaseContext(),JobActivity.class);
            i.putExtra("industry","Engineering");
            startActivity(i);
        });
        food = findViewById(R.id.food);
        food.setOnClickListener(v -> {
            Intent i = new Intent(getBaseContext(),JobActivity.class);
            i.putExtra("industry","Food");
            startActivity(i);
        });
        health = findViewById(R.id.health);
        health.setOnClickListener(v -> {
            Intent i = new Intent(getBaseContext(),JobActivity.class);
            i.putExtra("industry","Health");
            startActivity(i);
        });
        it = findViewById(R.id.it);
        it.setOnClickListener(v -> {
            Intent i = new Intent(getBaseContext(),JobActivity.class);
            i.putExtra("industry","IT");
            startActivity(i);
        });
        marketing = findViewById(R.id.marketing);
        marketing.setOnClickListener(v -> {
            Intent i = new Intent(getBaseContext(),JobActivity.class);
            i.putExtra("industry","Marketing");
            startActivity(i);
        });
        media = findViewById(R.id.media);
        media.setOnClickListener(v -> {
            Intent i = new Intent(getBaseContext(),JobActivity.class);
            i.putExtra("industry","Media");
            startActivity(i);
        });
        pharmaceutical = findViewById(R.id.pharmacy);
        pharmaceutical.setOnClickListener(v -> {
            Intent i = new Intent(getBaseContext(),JobActivity.class);
            i.putExtra("industry","Pharmaceutical");
            startActivity(i);
        });
        textile = findViewById(R.id.textile);
        textile.setOnClickListener(v -> {
            Intent i = new Intent(getBaseContext(),JobActivity.class);
            i.putExtra("industry","Textile");
            startActivity(i);
        });
        welfare = findViewById(R.id.welfare);
        welfare.setOnClickListener(v -> {
            Intent i = new Intent(getBaseContext(),JobActivity.class);
            i.putExtra("industry","Welfare");
            startActivity(i);
        });

    }
}
