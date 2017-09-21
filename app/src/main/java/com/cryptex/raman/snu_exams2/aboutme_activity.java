package com.cryptex.raman.snu_exams2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class aboutme_activity extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutme_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About the developer");

//        AboutView view = AboutBuilder.with(this)
//                .setPhoto(R.mipmap.profile_picture)
//                .setCover(R.mipmap.profile_cover)
//                .setName("Your Full Name")
//                .setSubTitle("Mobile Developer")
//                .setBrief("I'm warmed of mobile technologies. Ideas maker, curious and nature lover.")
//                .setAppIcon(R.mipmap.ic_launcher)
//                .setAppName(R.string.app_name)
//                .addGooglePlayStoreLink("8002078663318221363")
//                .addGitHubLink("user")
//                .addFacebookLink("user")
//                .addFiveStarsAction()
//                .setVersionNameAsAppSubTitle()
//                .addShareAction(R.string.app_name)
//                .setWrapScrollView(true)
//                .setLinksAnimated(true)
//                .setShowAsCard(true)
//                .build();
//
//
//
//        addContentView(view, LinearLayout.LayoutParams);


    }
}
