package com.micky.leakcanarysamples;;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class BaseApplication extends Application {

    private static BaseApplication instance;

    private RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }

        mRefWatcher = Constants.DEBUG ?  LeakCanary.install(this) : RefWatcher.DISABLED;
    }

    public static BaseApplication getInstance() {
        return instance;
    }

    public static RefWatcher getRefWatcher() {
        return getInstance().mRefWatcher;
    }
}
