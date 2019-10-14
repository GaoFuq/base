package com.gfq.base.application;

import android.app.Application;


/**
 * create by 高富强
 * on {2019/10/14} {11:32}
 * desctapion:
 */
public class BaseApplication extends Application {
    public static  Application application;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        initLoadSir();
    }

    public void initLoadSir() {
    }
}
