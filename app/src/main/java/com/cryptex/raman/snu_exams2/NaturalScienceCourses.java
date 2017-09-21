package com.cryptex.raman.snu_exams2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.dynamitechetan.flowinggradient.FlowingGradientClass;

import es.dmoral.toasty.Toasty;

public class NaturalScienceCourses extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_natural_science_courses);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Toasty.error(getApplicationContext(), "Content not available yet :(", Toast.LENGTH_SHORT, true).show();
        Toasty.warning(getApplicationContext(), "Stay tuned for more ;)", Toast.LENGTH_LONG, true).show();

        RelativeLayout rl = (RelativeLayout)findViewById(R.id.rl_natural);
        FlowingGradientClass grad = new FlowingGradientClass();
        grad.setBackgroundResource(R.drawable.translate)
                .onRelativeLayout(rl)
                .setTransitionDuration(3000)
                .start();
    }
}
