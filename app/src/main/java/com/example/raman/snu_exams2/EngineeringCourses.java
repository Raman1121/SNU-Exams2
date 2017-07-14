package com.example.raman.snu_exams2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.tapadoo.alerter.Alerter;

import static android.os.Build.VERSION_CODES.M;

public class EngineeringCourses extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineering_courses);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //ALERTER
        Alerter.create(this)
                .setTitle("You made it this far.. GREAT!")
                .setText("Choose your course of interest here.")
                .setBackgroundColorInt(Color.GRAY)
                .setDuration(5000)
                .enableProgress(true)
                .show();

        String engCourses[] = {"PHY101", "PHY102", "CHE101", "CHE102", "MAT201", "MAT202", "EED101", "EED102", "EED103", "CSD101", "CSD201", "MED101", "MED102", "CED101", "CED102", "CHY111"};

        //LISTVIEW
        ListAdapter adapter = new customAdapter(this, engCourses);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(EngineeringCourses.this, ExamType.class));
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        Alerter.hide();
    }
}
