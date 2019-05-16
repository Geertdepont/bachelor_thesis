package com.hfad.mvplogin.ui.activity.component.Auth;

import com.hfad.mvplogin.ui.activity.Scope.ActivityScope;
import com.hfad.mvplogin.ui.activity.Scope.Auth.GreetScope;
import com.hfad.mvplogin.ui.activity.View.GreetActivity;
import com.hfad.mvplogin.ui.activity.View.LogInActivity;
import com.hfad.mvplogin.ui.activity.module.Auth.GreetModule;
import com.hfad.mvplogin.ui.activity.module.LogInModule;

import dagger.Subcomponent;

@GreetScope
@Subcomponent(modules = GreetModule.class)
public interface GreetComponent {

    void inject(GreetActivity greetActivity);

}