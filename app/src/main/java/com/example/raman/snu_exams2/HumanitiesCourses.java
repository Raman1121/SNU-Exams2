package com.example.raman.snu_exams2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HumanitiesCourses extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humanities_courses);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
