package com.hfad.mvplogin.ui.activity.View.Credentials;

public class CredentialsImpl implements Credentials {

    private String mLogin;

    public CredentialsImpl() {
    }

    @Override
    public String getLogin() {
        return mLogin;
    }

    @Override
    public void setLogin(String login) {
        mLogin = login;
    }

    @Override
    public String getPersonalizedGreeting() {
        return "Welcome" + ' ' + mLogin;
    }

}
