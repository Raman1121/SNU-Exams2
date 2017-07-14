package com.example.raman.snu_exams2;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.tapadoo.alerter.Alerter;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

import static android.R.id.message;

public class ExamType extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_type);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //ALERTER
        Alerter.create(this)
                .setTitle("YOU too can contribute!")
                .setText("Press the button at the bottom right corner ;)")
                .setBackgroundColorInt(Color.GRAY)
                .setDuration(5000)
                .enableProgress(true)
                .show();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialTapTargetPrompt.Builder(ExamType.this)
                        .setTarget(findViewById(R.id.fab))
                        .setPrimaryText("Send your first email")
                        .setSecondaryText("Tap the envelop to start composing your first email")
                        .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener()
                        {
                            @Override
                            public void onHidePrompt(MotionEvent event, boolean tappedTarget)
                            {
                                //Do something such as storing a value so that this prompt is never shown again
                                tappedTarget = false;
                                sendEmail();
                            }

                            @Override
                            public void onHidePromptComplete()
                            {


                            }
                        })
                        .show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Alerter.hide();
    }

    public void sendEmail(){
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","rd650@snu.edu.in", null));
        //intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
    }

}
