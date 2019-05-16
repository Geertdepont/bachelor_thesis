package com.hfad.mvplogin.ui.activity.View;

public interface AddUserView {
    void showProgress();

    void hideProgress();

    void saveUser();

    void setEmailError(String error);

    void setPasswordError();

    void navigateToHome();
}
