package com.example.raman.snu_exams2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class OpeningScreen extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_screen);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        FrameLayout fl1 = (FrameLayout)findViewById(R.id.frameLayout1);
        FrameLayout fl2 = (FrameLayout)findViewById(R.id.frameLayout2);
        FrameLayout fl3 = (FrameLayout)findViewById(R.id.frameLayout3);

        fl1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(OpeningScreen.this, EngineeringCourses.class));
                    }
                }
        );

        fl2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(OpeningScreen.this, NaturalScienceCourses.class));
                    }
                }
        );

        fl3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(OpeningScreen.this, HumanitiesCourses.class));
                    }
                }
        );
    }
}
