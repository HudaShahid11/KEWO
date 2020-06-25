package com.kewo.huda;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class social extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);
    }
    public void wb(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kewo.org/"));
        startActivity(i);
    }
    public void fb(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/kewo4u/"));
        startActivity(i);
    }
    public void yt(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCspIAEN70nTgCFexoweb0Gw?app=desktop"));
        startActivity(i);
    }

    public void em(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "info@kewo.org"));
        startActivity(i);
    }
}
