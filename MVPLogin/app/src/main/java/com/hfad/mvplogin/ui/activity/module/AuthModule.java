package com.hfad.mvplogin.ui.activity.module;

import com.hfad.mvplogin.ui.activity.Scope.Auth.GreetScope;
import com.hfad.mvplogin.ui.activity.Scope.AuthScope;
import com.hfad.mvplogin.ui.activity.View.Credentials.Credentials;
import com.hfad.mvplogin.ui.activity.View.Credentials.CredentialsImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class AuthModule {

    public AuthModule() {
    }

    @Provides
    @AuthScope
    static public Credentials provideCredentials() {
        return new CredentialsImpl();
    }
}
