package com.example.raman.snu_exams2;

import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ramotion.foldingcell.FoldingCell;
import com.tapadoo.alerter.Alerter;

import static com.example.raman.snu_exams2.R.drawable.jon;

public class help_activity extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_activity);
        final FoldingCell fc = (FoldingCell) findViewById(R.id.folding_cell);
        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fc.toggle(false);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("HELP");

//        Alerter.create(this)
//                .setTitle("HEEEEELLLLLLPPPP!!!")
//                .setText("Need Help??")
//                .setBackgroundColorInt(Color.RED)
//                .setDuration(3000)
//                .enableProgress(true)
//                .show();

    }
}
