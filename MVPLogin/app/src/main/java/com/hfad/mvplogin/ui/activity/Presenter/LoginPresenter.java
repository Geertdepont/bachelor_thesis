package com.hfad.mvplogin.ui.activity.Presenter;


import com.hfad.mvplogin.MVPLoginApplication;
import com.hfad.mvplogin.ui.activity.Interactor.LoginInteractor;
import com.hfad.mvplogin.ui.activity.View.Credentials.Credentials;
import com.hfad.mvplogin.ui.activity.View.LoginView;

import javax.inject.Inject;


public class LoginPresenter implements LoginInteractor.OnLoginFinishedListener{

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    @Inject
    public LoginPresenter(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }

        loginInteractor.login(username, password, this);
    }

    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onEmailError(String error) {
        if (loginView != null) {
            loginView.setEmailError(error);
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess(String username) {
        if (loginView != null) {
            Credentials credentials = MVPLoginApplication
                    .plusAuthComponent()
                    .getCredentials();
            credentials.setLogin(username);
            loginView.navigateToHome();
        }
    }
}
