package com.example.raman.snu_exams2;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gospelware.liquidbutton.LiquidButton;

import static android.os.Build.VERSION_CODES.M;
import static com.example.raman.snu_exams2.R.id.textView;

public class download_activity extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LiquidButton liquidButton = (LiquidButton) findViewById(R.id.button);

        Toast.makeText(this, "Tap on the screen again ;) ", Toast.LENGTH_SHORT).show();

        liquidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LiquidButton btn = (LiquidButton) v;
                btn.startPour();
            }
        });
        liquidButton.setFillAfter(true);
        liquidButton.setAutoPlay(true);
        liquidButton.setPourFinishListener(new LiquidButton.PourFinishListener() {
            @Override
            public void onPourFinish() {
                Toast.makeText(download_activity.this, "File Downloaded", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onProgressUpdate(float progress) {
                //textView.setText(String.format("%.2f", progress * 100) + "%");
            }
        });
        liquidButton.finishPour();
    }
}