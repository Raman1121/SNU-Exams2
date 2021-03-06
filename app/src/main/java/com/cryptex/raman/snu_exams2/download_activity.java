package com.cryptex.raman.snu_exams2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.gospelware.liquidbutton.LiquidButton;

import es.dmoral.toasty.Toasty;

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

       // Toast.makeText(this, "Tap on the screen again ;) ", Toast.LENGTH_SHORT).show();
        Toasty.warning(getApplicationContext(), "Tap on the screen again ;)", Toast.LENGTH_LONG, true).show();

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


                Toasty.success(getApplicationContext(), "File Downloaded :)", Toast.LENGTH_LONG, true).show();
                LinearLayout ll = (LinearLayout) findViewById(R.id.download_act);

                Toasty.normal(getApplicationContext(), "Exit the app and Check your file manager", R.drawable.file_manager).show();
                startActivity(new Intent(download_activity.this, OpeningScreen.class));
            }
            @Override
            public void onProgressUpdate(float progress) {
                //textView.setText(String.format("%.2f", progress * 100) + "%");
            }
        });
        liquidButton.finishPour();

    }
}
