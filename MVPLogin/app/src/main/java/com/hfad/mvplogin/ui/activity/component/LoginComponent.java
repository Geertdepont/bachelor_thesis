package com.hfad.mvplogin.ui.activity.component;

import com.hfad.mvplogin.MVPLoginApplication;
import com.hfad.mvplogin.ui.activity.View.LogInActivity;
import com.hfad.mvplogin.ui.activity.Scope.ActivityScope;
import com.hfad.mvplogin.ui.activity.View.LoginView;
import com.hfad.mvplogin.ui.activity.module.LogInModule;

import dagger.Component;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = LogInModule.class)
public interface LoginComponent {

    void inject(LogInActivity logInActivity);

}