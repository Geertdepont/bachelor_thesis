package com.hfad.mvplogin;

import android.app.Application;
import android.content.Context;

//import com.hfad.mvplogin.data.DataManager;
import com.hfad.mvplogin.data.DbHelper;
import com.hfad.mvplogin.data.SharedPrefsHelper;
import com.hfad.mvplogin.ui.activity.ApplicationContext;
import com.hfad.mvplogin.ui.activity.View.AddUserActivity;
import com.hfad.mvplogin.ui.activity.View.LogInActivity;
import com.hfad.mvplogin.ui.activity.component.AddUserComponent;
import com.hfad.mvplogin.ui.activity.component.AuthComponent;
import com.hfad.mvplogin.ui.activity.component.LoginComponent;
import com.hfad.mvplogin.ui.activity.module.AddUserModule;
import com.hfad.mvplogin.ui.activity.module.AuthModule;
import com.hfad.mvplogin.ui.activity.module.LogInModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    Application getApplication();

    void inject(MVPLoginApplication mvpLoginApplication);

    LoginComponent plus(LogInModule module);

    AddUserComponent plus(AddUserModule module);

    AuthComponent plusAuthComponent();

}