package com.hfad.mvplogin;


import android.app.Application;
import android.content.Context;

import com.hfad.mvplogin.data.DataManager;
import com.hfad.mvplogin.data.DbHelper;
import com.hfad.mvplogin.data.SharedPrefsHelper;
import com.hfad.mvplogin.ui.activity.ApplicationContext;
import com.hfad.mvplogin.ui.activity.component.AuthComponent;

import javax.inject.Inject;

public class MVPLoginApplication extends Application {

    static private DataManager dataManager;
    static private AppComponent appComponent;
    static private AuthComponent authComponent;

    public static MVPLoginApplication get(Context context) {
        return (MVPLoginApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }

    static public AuthComponent plusAuthComponent() {
        if (authComponent == null) {
            authComponent = appComponent.plusAuthComponent();
        }
        return authComponent;
    }

    static public DataManager getDataManager(Context context) {
        if (dataManager == null) {
            DbHelper dbHelper = new DbHelper(context, "demo-dagger.db", 2);
            SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(appComponent.getApplication().getSharedPreferences("demo-prefs", Context.MODE_PRIVATE));
            dataManager = new DataManager(context, dbHelper, sharedPrefsHelper);
        }
        return dataManager;

    }

    static public void clearAuthComponent() {
        authComponent = null;
    }

    static public AppComponent getAppComponent() {
        return appComponent;
    }

    static public AuthComponent getAuthComponent() { return authComponent; }

}