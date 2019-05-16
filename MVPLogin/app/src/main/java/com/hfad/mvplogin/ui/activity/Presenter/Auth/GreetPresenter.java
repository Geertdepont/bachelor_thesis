package com.hfad.mvplogin.ui.activity.Presenter.Auth;

import com.hfad.mvplogin.data.model.User;
import com.hfad.mvplogin.ui.activity.Interactor.ViewUserInteractor;
import com.hfad.mvplogin.ui.activity.View.Credentials.Credentials;
import com.hfad.mvplogin.ui.activity.View.GreetView;
import com.hfad.mvplogin.ui.activity.View.ViewUsersView;

import java.util.List;

import javax.inject.Inject;

public class GreetPresenter {

    private GreetView mGreetView;
    private Credentials mCredentials;

    @Inject
    public GreetPresenter(GreetView greetView, Credentials credentials) {
        this.mGreetView = greetView;
        this.mCredentials = credentials;
    }

    public void greet() {
        mGreetView.showMessage(mCredentials.getPersonalizedGreeting());
    }

}
