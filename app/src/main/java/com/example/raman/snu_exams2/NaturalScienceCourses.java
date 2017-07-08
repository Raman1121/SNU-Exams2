package com.example.raman.snu_exams2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NaturalScienceCourses extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_natural_science_courses);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
