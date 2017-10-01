package com.cryptex.raman.snu_exams2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.Menu;

import com.dynamitechetan.flowinggradient.FlowingGradientClass;
import com.tapadoo.alerter.Alerter;


public class OpeningScreen extends AppCompatActivity {





//    @Override
//    public boolean onSupportNavigateUp() {
//        finish();
//        return true;
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
//        if(id == R.id.help){
//
//            Intent intent = new Intent(OpeningScreen.this, help_activity2.class);
//            startActivity(intent);
//            return true;
//        }
        if(id == R.id.contribute){

            Intent intent = new Intent(OpeningScreen.this, contribute_activity.class);
            startActivity(intent);
            return true;
        }
        if(id == R.id.about){

            Intent intent = new Intent(OpeningScreen.this, about_me2.class);
            startActivity(intent);
            return true;
        }
        if(id == R.id.rate){
            Intent intent = new Intent(OpeningScreen.this, rate1.class);
            startActivity(intent);
            return true;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_screen);

        TextView tv1 = (TextView)findViewById(R.id.textView1);
        TextView tv2 = (TextView)findViewById(R.id.textView2);
        TextView tv3 = (TextView)findViewById(R.id.textView3);

        RelativeLayout rl = (RelativeLayout)findViewById(R.id.relativeLayout);
        FlowingGradientClass grad = new FlowingGradientClass();
        grad.setBackgroundResource(R.drawable.translate)
                .onRelativeLayout(rl)
                .setTransitionDuration(3000)
                .start();

        //ALERTER
        Alerter.create(this)
                .setTitle("Hey there, WELCOME!!")
                .setText("Exams are near, eh?")
                .setBackgroundColorInt(Color.BLACK)
                .setDuration(5000)
                .enableProgress(true)
                .show();




        tv1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(OpeningScreen.this, EngineeringCourses.class));
                    }
                }
        );

        tv2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(OpeningScreen.this, NaturalScienceCourses.class));
                    }
                }
        );

        tv3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(OpeningScreen.this, HumanitiesCourses.class));
                    }
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Alerter.hide();
    }
}








