package com.hfad.mvplogin.ui.activity.module.Auth;

import com.hfad.mvplogin.ui.activity.Interactor.ViewUserInteractor;
import com.hfad.mvplogin.ui.activity.Presenter.Auth.GreetPresenter;
import com.hfad.mvplogin.ui.activity.Presenter.Auth.ViewUserPresenter;
import com.hfad.mvplogin.ui.activity.Scope.Auth.GreetScope;
import com.hfad.mvplogin.ui.activity.Scope.Auth.ViewUserScope;
import com.hfad.mvplogin.ui.activity.Scope.AuthScope;
import com.hfad.mvplogin.ui.activity.View.Credentials.Credentials;
import com.hfad.mvplogin.ui.activity.View.Credentials.CredentialsImpl;
import com.hfad.mvplogin.ui.activity.View.GreetView;

import dagger.Module;
import dagger.Provides;

@Module
public class GreetModule {

    private GreetView greetView;

    public GreetModule(GreetView greetView) {
        this.greetView = greetView;
    }


    @GreetScope
    @Provides
    public GreetView provideGreetView() {
        return greetView;
    }

    @GreetScope
    @Provides
    GreetPresenter greetPresenter(Credentials credentials) {
        return new GreetPresenter(greetView, credentials);
    }

}
