package com.example.raman.snu_exams2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

import static android.R.id.message;

public class Year2 extends AppCompatActivity {

    private static final int PERMS_REQUEST_CODE = 123;


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Year and Exam Type");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialTapTargetPrompt.Builder(Year2.this)
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

        String years[] = {"2015 Midsems", "2015 Endsems", "2016 Midsems", "2016 Endsems", "2017 Midsems", "2017 Endsems"};

        ListAdapter adapter = new customAdapter2(this, years);
        ListView listView = (ListView) findViewById(R.id.year_listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String year = adapterView.getItemAtPosition(position).toString();

                decide(year);

            }
        });
    }

    void decide(String year) {
        String course_name = this.getIntent().getExtras().getString("course_name");

        if (course_name.equals("CSD-101")) {
            if (year.equals("2015 Midsems")) {
                String filename = "CSD-101 2015 Midsem.pdf";
                if (hasPermission()){
                    downloadFile(filename, course_name, "Midsems", "2015");
                }else{
                    requestPerms();
                }
            }
            if (year.equals("2015 Endsems")) {
                String filename = "CSD-101 2015 Endsem.pdf";
                if (hasPermission()){
                    downloadFile(filename, course_name, "Endsems", "2015");
                }else{
                    requestPerms();
                }
            }

            if (year.equals("2016 Midsems")) {

                String filename = "CSD-101 2016 Midsem.pdf";
                if (hasPermission()){
                    downloadFile(filename, course_name, "Midsems", "2016");
                }else{
                    requestPerms();
                }
            }
            if (year.equals("2016 Endsems")) {

                String filename = "CSD-101 2016 Endsem.pdf";
                if (hasPermission()){
                    downloadFile(filename, course_name, "Endsems", "2016");
                }else{
                    requestPerms();
                }
            }
        }

        if(course_name.equals("CSD-201")){
            if (year.equals("2016 Midsems")){
                String filename = "CSD-201 2016 Midsem.pdf";
                if (hasPermission()){
                    downloadFile(filename, course_name, "Midsems", "2016");
                }else{
                    requestPerms();
                }
            }

            if(year.equals("2016 Endsems")){
                String filename = "CSD-201 2016 Endsem.pdf";
                if (hasPermission()){
                    downloadFile(filename, course_name, "Endsems", "2016");
                }else{
                    requestPerms();
                }
            }
        }

        if(course_name.equals("CSD-205")){
            if (year.equals("2016 Midsems")){
                String filename = "CSD-205 2016 Midsem.pdf";
                if (hasPermission()){
                    downloadFile(filename, course_name, "Midsems", "2016");
                }else{
                    requestPerms();
                }
            }

            if(year.equals("2016 Endsems")){
                String filename = "CSD-205 2016 Endsem.pdf";
                if (hasPermission()){
                    downloadFile(filename, course_name, "Endsems", "2016");
                }else{
                    requestPerms();
                }
            }
        }

        if (course_name.equals("MAT-201")){
            if(year.equals("2016 Midsems")){

                String filename = "MAT-201 2016 Midsems.pdf";
                if (hasPermission()){
                    downloadFile(filename, course_name, "Midsems", "2016");
                }else{
                    requestPerms();
                }
            }
            if (year.equals("2016 Endsems")){
                String filename = "MAT-201 2016 Endsem.pdf";
                if (hasPermission()){
                    downloadFile(filename, course_name, "Endsems", "2016");
                }else{
                    requestPerms();
                }
            }
        }

        if (course_name.equals("MAT-202")){
            if(year.equals("2016 Midsems")){
                String filename = "MAT-202 2016 Midsems.pdf";
                if (hasPermission()){
                    downloadFile(filename, course_name, "Midsems", "2016");
                }else{
                    requestPerms();
                }
            }
            if (year.equals("2016 Endsems")){
                String filename = "MAT-202 2016 Endsem.pdf";
                if (hasPermission()){
                    downloadFile(filename, course_name, "Endsems", "2016");
                }else{
                    requestPerms();
                }
            }
        }

        if(course_name.equals("MAT-203")) {
            if (year.equals("2016 Midsems")) {
                String filename = "MAT-203 2016 Midsem.pdf";
                if (hasPermission()) {
                    downloadFile(filename, course_name, "Midsems", "2016");
                } else {
                    requestPerms();
                }
            }
//            if(year.equals("2016 Endsems")) {
//                String filename = "MAT-203 2016 Endsem.pdf";
//                if (hasPermission()) {
//                    downloadFile(filename, course_name, "Endsems", "2016");
//                } else {
//                    requestPerms();
//                }
//            }
            if (year.equals("2015 Midsems")) {
                String filename = "MAT-203 2015 Midsem.pdf";
                if (hasPermission()) {
                    downloadFile(filename, course_name, "Midsems", "2015");
                } else {
                    requestPerms();
                }
            }
//            if(year.equals("2015 Endsems")){
//                String filename = "MAT-203 2015 Endsem.pdf";
//                if(hasPermission()){
//                    downloadFile(filename, course_name, "Endsems", "2015");
//                }else{
//                    requestPerms();
//                }
//            }
        }


            if (course_name.equals("PHY-101")) {
                if (year.equals("2015 Midsems")) {
                    String filename = "PHY-101 2015 Midsems.pdf";
                    if (hasPermission()) {
                        downloadFile(filename, course_name, "Midsems", "2015");
                    } else {
                        requestPerms();
                    }
                }
                if (year.equals("2015 Endsems")) {
                    String filename = "PHY-101 2015 Endsems.pdf";
                    if (hasPermission()) {
                        downloadFile(filename, course_name, "Endsems", "2015");
                    } else {
                        requestPerms();
                    }
                }
                if (year.equals("2016 Midsems")) {
                    String filename = "PHY-101 2016 Midsems.pdf";
                    if (hasPermission()) {
                        downloadFile(filename, course_name, "Midsems", "2016");
                    } else {
                        requestPerms();
                    }
                }
                if (year.equals("2016 Endsems")) {
                    String filename = "PHY-101 2016 Endsems.pdf";
                    if (hasPermission()) {
                        downloadFile(filename, course_name, "Endsems", "2016");
                    } else {
                        requestPerms();
                    }
                }
            }

            if (course_name.equals("PHY-102")) {
                if (year.equals("2015 Midsems")) {
                    String filename = "PHY-102 2015 Midsems.pdf";
                    if (hasPermission()) {
                        downloadFile(filename, course_name, "Midsems", "2015");
                    } else {
                        requestPerms();
                    }
                }
                if (year.equals("2015 Endsems")) {
                    String filename = "PHY-102 2015 Endsems.pdf";
                    if (hasPermission()) {
                        downloadFile(filename, course_name, "Endsems", "2015");
                    } else {
                        requestPerms();
                    }
                }
                if (year.equals("2016 Midsems")) {
                    String filename = "PHY-102 2016 Midsems.pdf";
                    if (hasPermission()) {
                        downloadFile(filename, course_name, "Midsems", "2016");
                    } else {
                        requestPerms();
                    }
                }
                if (year.equals("2016 Endsems")) {
                    String filename = "PHY-102 2016 Endsems.pdf";
                    if (hasPermission()) {
                        downloadFile(filename, course_name, "Endsems", "2016");
                    } else {
                        requestPerms();
                    }
                }
            }


            if (course_name.equals("EED-101")) {
                if (year.equals("2016 Midsems")) {
                    String filename = "EED-101 2016 Midsems.pdf";
                    if (hasPermission()) {
                        downloadFile(filename, course_name, "Midsems", "2016");
                    } else {
                        requestPerms();
                    }
                }
                if (year.equals("2016 Endsems")) {
                    String filename = "EED-101 2016 Endsems.pdf";
                    if (hasPermission()) {
                        downloadFile(filename, course_name, "Endsems", "2016");
                    } else {
                        requestPerms();
                    }
                }
            }

            if (course_name.equals("EED-102")) {
                if (year.equals("2016 Midsems")) {
                    String filename = "EED-102 2016 Midsems.pdf";
                    if (hasPermission()) {
                        downloadFile(filename, course_name, "Midsems", "2016");
                    } else {
                        requestPerms();
                    }
                }
                if (year.equals("2016 Endsems")) {
                    String filename = "EED-102 2016 Endsems.pdf";
                    if (hasPermission()) {
                        downloadFile(filename, course_name, "Endsems", "2016");
                    } else {
                        requestPerms();
                    }
                }
            }

            if (course_name.equals("EED-103")) {
                if (year.equals("2016 Midsems")) {
                    String filename = "EED-103 2016 Midsems.pdf";
                    if (hasPermission()) {
                        downloadFile(filename, course_name, "Midsems", "2016");
                    } else {
                        requestPerms();
                    }
                }
                if (year.equals("2016 Endsems")) {
                    String filename = "EED-103 2016 Endsems.pdf";
                    if (hasPermission()) {
                        downloadFile(filename, course_name, "Endsems", "2016");
                    } else {
                        requestPerms();
                    }
                }
            }


            if (course_name.equals("MED-101")) {
                if (year.equals("2016 Midsems")) {
                    String filename = "MED-101 2016 Midsems.pdf";
                    if (hasPermission()) {
                        downloadFile(filename, course_name, "Midsems", "2016");
                    } else {
                        requestPerms();
                    }
                }
                if (year.equals("2016 Endsems")) {
                    String filename = "MED-101 2016 Endsems.pdf";
                    if (hasPermission()) {
                        downloadFile(filename, course_name, "Endsems", "2016");
                    } else {
                        requestPerms();
                    }
                }
            }

            if (course_name.equals("MED-102")) {
                if (year.equals("2016 Midsems")) {
                    String filename = "MED-102 2016 Midsems.pdf";
                    if (hasPermission()) {
                        downloadFile(filename, course_name, "Midsems", "2016");
                    } else {
                        requestPerms();
                    }
                }
                if (year.equals("2016 Endsems")) {
                    String filename = "MED-102 2016 Endsems.pdf";
                    if (hasPermission()) {
                        downloadFile(filename, course_name, "Endsems", "2016");
                    } else {
                        requestPerms();
                    }
                }
            }
    }

    public void sendEmail(){
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","rd650@snu.edu.in", null));
        //intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
    }

    private void downloadFile(String filename, String course_name, String examType, String year){
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        String file = course_name + "_" + examType + ".pdf";
        StorageReference islandRef = storageRef.child(course_name).child(examType).child(year).child(file);

        Toast.makeText(this, "Downloading File", Toast.LENGTH_LONG).show();

        File rootPath = new File(Environment.getExternalStorageDirectory(), "SNU-EXAMS-Question Papers");
        if(!rootPath.exists()) {
            rootPath.mkdirs();
        }

        final File localFile = new File(rootPath, filename);

        islandRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                //add code here
                startActivity(new Intent(Year2.this, download_activity.class));
                //Toast.makeText(Year2.this, "File Downloaded", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Year2.this, "Download Failed", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void requestPerms(){
        String[] permissions = new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE};

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            requestPermissions(permissions, PERMS_REQUEST_CODE);

        }
    }

    private boolean hasPermission(){
        int res = 0;
        String[] permissions = new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE};

        for(String perms : permissions){
            res = checkCallingOrSelfPermission(perms);

            if(!(res == PackageManager.PERMISSION_GRANTED)){
                return false;
            }
        }
        return true;
    }

}
