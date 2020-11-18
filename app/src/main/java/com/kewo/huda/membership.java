package com.kewo.huda;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class membership extends AppCompatActivity {
    Dialog detail_dialog;
    ImageView close;
    LinearLayout Linear_form;
    TextView step_form, form_text;
    Button form,detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);
        detail_dialog = new Dialog(this);

        Linear_form = findViewById(R.id.linear_form);
        step_form = findViewById(R.id.step_form);
        form_text = findViewById(R.id.form_text);
        form = findViewById(R.id.form);
        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),membership_form.class);
                startActivity(i);
            }
        });
        detail = findViewById(R.id.detail);
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup();
            }
        });
        final TextView first = (TextView) findViewById(R.id.first);
        final TextView second = (TextView) findViewById(R.id.second);

        final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(9000L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final float progress = (float) animation.getAnimatedValue();
                final float width = first.getWidth();
                final float translationX = width * progress;
                first.setTranslationX(translationX);
                second.setTranslationX(translationX - width);
            }
        });

        animator.start();
    }
    public void showPopup(){
        detail_dialog.setContentView(R.layout.detail_dialog);
        close = detail_dialog.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detail_dialog.dismiss();
            }
        });

        detail_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        detail_dialog.show();
    }


}
