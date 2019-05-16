package com.hfad.mvplogin.ui.activity.Presenter;


import android.widget.Toast;

import com.hfad.mvplogin.MVPLoginApplication;
import com.hfad.mvplogin.ui.activity.Interactor.AddUserInteractor;
import com.hfad.mvplogin.ui.activity.Interactor.LoginInteractor;
import com.hfad.mvplogin.ui.activity.View.AddUserView;
import com.hfad.mvplogin.ui.activity.View.Credentials.Credentials;
import com.hfad.mvplogin.ui.activity.View.LoginView;

import javax.inject.Inject;

import es.dmoral.toasty.Toasty;


public class AddUserPresenter implements AddUserInteractor.OnAddUserFinishedListener{

    private AddUserView addUserView;
    private AddUserInteractor addUserInteractor;

    @Inject
    public AddUserPresenter(AddUserView addUserView, AddUserInteractor addUserInteractor) {
        this.addUserView = addUserView;
        this.addUserInteractor = addUserInteractor;
    }

    public void addUser(String username, String password) {
        if (addUserView != null) {
            addUserView.showProgress();
        }

        addUserInteractor.saveUser(username, password, this);
    }

    public void onDestroy() {
        addUserView = null;
    }


    @Override
    public void onEmailError(String error) {
        if (addUserView != null) {
            addUserView.setEmailError(error);
            addUserView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (addUserView != null) {
            addUserView.setPasswordError();
            addUserView.hideProgress();
        }
    }

    @Override
    public void onSuccess(String username) {
        if (addUserView != null) {
            addUserView.navigateToHome();
        }
    }
}
