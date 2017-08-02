package com.micky.leakcanarysamples;;

import android.os.Bundle;
import android.os.Handler;

public class TestActivity extends BaseActivity {

    private final Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {

            }
        }, 3 * 60 * 1000);

        finish();
    }
}
