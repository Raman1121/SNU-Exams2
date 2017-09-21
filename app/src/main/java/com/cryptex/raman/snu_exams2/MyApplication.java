package com.cryptex.raman.snu_exams2;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by raman on 18/9/17.
 */

public class MyApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
