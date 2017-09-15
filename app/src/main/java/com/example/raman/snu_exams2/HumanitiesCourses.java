package com.example.raman.snu_exams2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

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
        Toasty.error(getApplicationContext(), "Content not available yet :(", Toast.LENGTH_SHORT, true).show();
        Toasty.warning(getApplicationContext(), "Stay tuned for more ;)", Toast.LENGTH_LONG, true).show();
    }
}
