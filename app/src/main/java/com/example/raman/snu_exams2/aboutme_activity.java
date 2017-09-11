package com.example.raman.snu_exams2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tapadoo.alerter.Alerter;

public class aboutme_activity extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutme_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About the developer");

        Alerter.create(this)
                .setTitle("DING DING")
                .setBackgroundColorInt(Color.DKGRAY)
                .setDuration(5000)
                .enableProgress(true)
                .show();


    }
}
