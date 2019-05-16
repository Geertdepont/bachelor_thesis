package com.hfad.mvplogin.ui.activity.View;

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setEmailError(String error);

    void setPasswordError();

    void navigateToHome();
}
