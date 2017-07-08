package com.example.raman.snu_exams2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

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





        String engCourses[] = {"PHY101", "PHY102", "CHE101", "CHE102", "MAT201", "MAT202", "EED101", "EED102", "EED103", "CSD101", "CSD201", "MED101", "MED102", "CED101", "CED102", "CHY111"};

        ListAdapter adapter = new customAdapter(this, engCourses);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);


    }
}
