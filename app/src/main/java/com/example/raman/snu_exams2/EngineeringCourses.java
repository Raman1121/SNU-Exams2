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
import static com.example.raman.snu_exams2.R.id.parent;

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

        String engCourses[] = {"PHY-101", "PHY-102", "CHE-101", "CHE-102", "MAT-201", "MAT-202", "MAT-203","MAT-205", "EED-101",
                "EED-102", "EED-103","EED-206","EED-201","EED-202","EED-209", "CSD-101", "CSD-201","CSD-205","CSD-206","CSD-207", "MED-101",
                "MED-102", "CED-101","CED-103","CED-201","CED-202","CED-204","CED-206","CHY-111","ECO-101"};

        //LISTVIEW
        ListAdapter adapter = new customAdapter(this, engCourses);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //startActivity(new Intent(EngineeringCourses.this, ExamType.class));
                String course = adapterView.getItemAtPosition(position).toString();
                Intent intent = new Intent(EngineeringCourses.this, Year2.class);
                intent.putExtra("course_name", course);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        Alerter.hide();
    }
}
