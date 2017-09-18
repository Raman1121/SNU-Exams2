package com.example.raman.snu_exams2;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.spark.submitbutton.SubmitButton;
import com.tapadoo.alerter.Alerter;

import static android.R.attr.gravity;
import static android.R.id.message;

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
                .setBackgroundColorInt(Color.BLACK)
                .setDuration(3000)
                .enableProgress(true)
                .show();

        TextView txt = (TextView)findViewById(R.id.text);
        txt.setGravity(Gravity.LEFT);

        SubmitButton bttn = (SubmitButton)findViewById(R.id.submitButton);
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","rd650@snu.edu.in", null));
                //intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });

        TextView text = (TextView)findViewById(R.id.text);
        text.setGravity(Gravity.LEFT);


    }
}
