package com.example.joy.gjj_smartbutler.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by joy on 2018/2/14.
 * 包名：com.example.joy.gjj_smartbutler.application
 * 描述：${CLASS_NAME}
 */

public class BaseApplication extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
