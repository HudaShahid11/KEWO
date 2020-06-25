package com.kewo.huda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class online extends AppCompatActivity {
    Button admin,finance,grooming,health,law,lang,mgt,marketing,standards,supply_chain,tech,vocational;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);
        admin = findViewById(R.id.admin);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), comingsoon.class);
                startActivity(i);
            }
        });

        finance = findViewById(R.id.finance);
        finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), comingsoon.class);
                startActivity(i);
            }
        });

        grooming = findViewById(R.id.grooming);
        grooming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), comingsoon.class);
                startActivity(i);
            }
        });
        health = findViewById(R.id.health);
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), comingsoon.class);
                startActivity(i);
            }
        });
        law = findViewById(R.id.law);
        law.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), comingsoon.class);
                startActivity(i);
            }
        });

        lang = findViewById(R.id.lang);
        lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), comingsoon.class);
                startActivity(i);
            }
        });
        mgt = findViewById(R.id.mgt);
        mgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), comingsoon.class);
                startActivity(i);
            }
        });
        marketing = findViewById(R.id.marketing);
        marketing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), comingsoon.class);
                startActivity(i);
            }
        });

        standards = findViewById(R.id.standards);
        standards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), comingsoon.class);
                startActivity(i);
            }
        });
        supply_chain = findViewById(R.id.supply_chain);
        supply_chain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), comingsoon.class);
                startActivity(i);
            }
        });
        tech = findViewById(R.id.tech);
        tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), comingsoon.class);
                startActivity(i);
            }
        });

        vocational = findViewById(R.id.vocational);
        vocational.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), comingsoon.class);
                startActivity(i);
            }
        });
    }
}
