package com.hfad.mvplogin.ui.activity.module;

import android.content.Context;

import com.hfad.mvplogin.MVPLoginApplication;
import com.hfad.mvplogin.ui.activity.Interactor.LoginInteractor;
import com.hfad.mvplogin.ui.activity.Presenter.LoginPresenter;
import com.hfad.mvplogin.ui.activity.Scope.ActivityScope;
import com.hfad.mvplogin.ui.activity.View.LoginView;

import dagger.Module;
import dagger.Provides;


@Module
public class LogInModule {

    private LoginView loginView;

    public LogInModule(LoginView loginView) {
        this.loginView = loginView;
    }

    @ActivityScope
    @Provides
    public LoginView provideLoginView() {
        return loginView;
    }


    @ActivityScope
    @Provides
    LoginPresenter provideLoginPresenter(LoginInteractor loginInteractor) {
        return new LoginPresenter(this.loginView, loginInteractor);
    }
}