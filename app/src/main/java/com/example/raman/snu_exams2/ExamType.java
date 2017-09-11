package com.example.raman.snu_exams2;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.tapadoo.alerter.Alerter;

import java.io.File;
import java.io.IOException;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

import static android.R.id.message;
import static com.example.raman.snu_exams2.R.id.fab;
import static com.example.raman.snu_exams2.R.id.midsems;
import static java.lang.Boolean.TRUE;

public class ExamType extends AppCompatActivity {

    private boolean FLAG_MIDSEMS;
    private boolean FLAG_ENDSEMS;
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private StorageReference pathRef = storage.getReference();


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

        FrameLayout midsems = (FrameLayout) findViewById(R.id.midsems);
        FrameLayout endsems = (FrameLayout) findViewById(R.id.endsems);

        midsems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FLAG_MIDSEMS = true;
                Intent intent = new Intent();

               // Toast.makeText(getApplicationContext(), "Midsems was touched", Toast.LENGTH_SHORT).show();
            }
        });

        endsems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FLAG_ENDSEMS = true;
                //Toast.makeText(getApplicationContext(), "Endsems was touched", Toast.LENGTH_SHORT).show();
            }
        });

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

        String course_name = this.getIntent().getExtras().getString("course_name");

        if(course_name.equals("PHY101")){
            Toast.makeText(this, "Entered PHY-101", Toast.LENGTH_SHORT).show();
            if(FLAG_MIDSEMS){

                Toast.makeText(this, "Midsems was touched ", Toast.LENGTH_SHORT).show();

//                StorageReference islandRef = pathRef.child("jon.jpg");
//                final long ONE_MEGABYTE = 1024 * 1024;
//                islandRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
//                    @Override
//                    public void onSuccess(byte[] bytes) {
//                        // Data for "images/island.jpg" is returns, use this as needed
//                        Toast.makeText(ExamType.this, "Downloading Complete", Toast.LENGTH_SHORT).show();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception exception) {
//                        // Handle any errors
//                        Toast.makeText(ExamType.this, "Downloading Failed", Toast.LENGTH_SHORT).show();
//                    }
//                });
            }
            else if(FLAG_ENDSEMS){
                Toast.makeText(this, "Endsems was touched", Toast.LENGTH_SHORT).show();
            }
        }
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
