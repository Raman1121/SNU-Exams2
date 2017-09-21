package com.cryptex.raman.snu_exams2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Year extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

        if (course_name.equals("CSD101")) {
            if (year.equals("2015 Midsems")) {
                //// TODO: start Download

            }
            if (year.equals("2016 Midsems")) {
                //// TODO: start Download
            }
        }

    }
}
