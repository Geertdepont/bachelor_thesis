package com.hfad.bossapplication;


import android.app.Application;
import android.content.Context;


public class BossApplication extends Application {

    static private AppComponent appComponent;

    public static BossApplication get(Context context) {
        return (BossApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }

    static public AppComponent getAppComponent() {
        return appComponent;
    }
}