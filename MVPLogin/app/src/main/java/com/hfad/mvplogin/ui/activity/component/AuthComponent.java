package com.hfad.mvplogin.ui.activity.component;


import com.hfad.mvplogin.ui.activity.Scope.AuthScope;
import com.hfad.mvplogin.ui.activity.View.Credentials.Credentials;
import com.hfad.mvplogin.ui.activity.View.GreetActivity;
import com.hfad.mvplogin.ui.activity.View.ViewUsersActivity;
import com.hfad.mvplogin.ui.activity.component.Auth.GreetComponent;
import com.hfad.mvplogin.ui.activity.component.Auth.ViewUserComponent;
import com.hfad.mvplogin.ui.activity.module.Auth.GreetModule;
import com.hfad.mvplogin.ui.activity.module.Auth.ViewUserModule;
import com.hfad.mvplogin.ui.activity.module.AuthModule;

import dagger.Subcomponent;

@AuthScope
@Subcomponent(modules = AuthModule.class)
public interface AuthComponent {

    Credentials getCredentials();

    GreetComponent plus(GreetModule module);

    ViewUserComponent plus(ViewUserModule module);
}
