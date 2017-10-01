package com.cryptex.raman.snu_exams2;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.dynamitechetan.flowinggradient.FlowingGradientClass;
import com.sdsmdg.harjot.rotatingtext.RotatingTextWrapper;
import com.sdsmdg.harjot.rotatingtext.models.Rotatable;
import com.stepstone.apprating.AppRatingDialog;
import com.stepstone.apprating.listener.RatingDialogListener;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class rate1 extends AppCompatActivity implements RatingDialogListener {

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate1);

        showDialog();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Rate this app");

        RelativeLayout rl = (RelativeLayout)findViewById(R.id.relLayout);
        FlowingGradientClass grad = new FlowingGradientClass();
        grad.setBackgroundResource(R.drawable.translate)
                .onRelativeLayout(rl)
                .setTransitionDuration(3000)
                .start();

        RotatingTextWrapper rotatingTextWrapper = (RotatingTextWrapper) findViewById(R.id.custom_switcher);
        rotatingTextWrapper.setSize(60);

        Rotatable rotatable = new Rotatable(Color.parseColor("#FFA036"), 1000, "YOU", "Toi", "君は", "Sie", "您", "당신");
        rotatable.setSize(60);
        rotatable.setAnimationDuration(500);
        rotatable.setColor(Color.YELLOW);

        rotatingTextWrapper.setContent("Thank ?", rotatable);
    }

    @Override
    public void onPositiveButtonClicked(int i, @NotNull String s) {
        String feedback = s;
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","rd650@snu.edu.in", null));
        intent.putExtra(Intent.EXTRA_TEXT, feedback + "\n\nThe ratings given are: " + i);
        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
    }

    @Override
    public void onNegativeButtonClicked() {

    }
    private void showDialog() {
        new AppRatingDialog.Builder()
                .setPositiveButtonText("Submit")
                .setNegativeButtonText("Cancel")
                .setNoteDescriptions(Arrays.asList("Very Bad", "Not good", "Quite ok", "Very Good", "Excellent !!!"))
                .setDefaultRating(3)
                .setTitle("Rate this application")
                .setDescription("Please select some stars and give your feedback")
                .setTitleTextColor(R.color.white)
                .setDescriptionTextColor(R.color.white)
                .setHint("Please write your comment here ...")
                .setHintTextColor(R.color.white)
                .setCommentTextColor(R.color.white)
                .setCommentBackgroundColor(R.color.colorPrimaryDark)
                .setWindowAnimation(R.style.MyDialogFadeAnimation)
                .create(rate1.this)
                .show();
    }
}