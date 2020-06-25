package com.kewo.huda;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class CourseDetail extends AppCompatActivity {
    TextView title, description,duration,cost,assessment,certification,responsive,publisher,info;
    ImageView image;
    CourseResponse userResponse;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        title = findViewById(R.id.title);
        description = findViewById(R.id.desc);
        duration = findViewById(R.id.duration);
        assessment = findViewById(R.id.assessment);
        certification = findViewById(R.id.certification);
        responsive = findViewById(R.id.responsive);
        publisher = findViewById(R.id.publisher);

        cost = findViewById(R.id.cost);
        info = findViewById(R.id.info);
        start = findViewById(R.id.start);

        image = findViewById(R.id.image);

        Intent intent = getIntent();
        if(intent.getExtras() != null){
            userResponse = (CourseResponse) intent.getSerializableExtra("data");
            String title_data = userResponse.getTitle();
            String desc_data = userResponse.getDescription();
            String img_data = userResponse.getUrl();
            String duration_data = userResponse.getDuration();
            String cost_data = userResponse.getCost();
            String ass_data = userResponse.getAssessment();
            String cer_data = userResponse.getCertification();
            String res_data = userResponse.getResponsive();
            String pub_data = userResponse.getPublisher();
            String info_data = userResponse.getWeb_url();

            Picasso.get().load(img_data).into(image);
            title.setText(title_data);
            description.setText(desc_data);
            duration.setText(duration_data);
            cost.setText(cost_data);
            assessment.setText(ass_data);
            certification.setText(cer_data);
            responsive.setText(res_data);
            publisher.setText(pub_data);

            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getBaseContext(),CourseForm.class);
                    i.putExtra("data",userResponse);
                    startActivity(i);


                }
            });
            info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(info_data));
                    startActivity(i);
                }
            });

        }
    }
}
