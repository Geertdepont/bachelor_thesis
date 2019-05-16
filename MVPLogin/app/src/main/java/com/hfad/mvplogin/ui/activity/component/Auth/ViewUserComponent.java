package com.hfad.mvplogin.ui.activity.component.Auth;

import com.hfad.mvplogin.ui.activity.Scope.Auth.GreetScope;
import com.hfad.mvplogin.ui.activity.Scope.Auth.ViewUserScope;
import com.hfad.mvplogin.ui.activity.View.GreetActivity;
import com.hfad.mvplogin.ui.activity.View.ViewUsersActivity;
import com.hfad.mvplogin.ui.activity.module.Auth.ViewUserModule;
import com.hfad.mvplogin.ui.activity.module.LogInModule;

import dagger.Subcomponent;

@ViewUserScope
@Subcomponent(modules = ViewUserModule.class)
public interface ViewUserComponent {

    void inject(ViewUsersActivity viewUsersActivity);

}