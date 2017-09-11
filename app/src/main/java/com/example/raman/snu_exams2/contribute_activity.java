package com.example.raman.snu_exams2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tapadoo.alerter.Alerter;

public class contribute_activity extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contribute_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("How to Contribute");

        Alerter.create(this)
                .setTitle("YOU too can contribute!")
                .setText("Wanna know how? ;)")
                .setBackgroundColorInt(Color.DKGRAY)
                .setDuration(3000)
                .enableProgress(true)
                .show();
    }
}
