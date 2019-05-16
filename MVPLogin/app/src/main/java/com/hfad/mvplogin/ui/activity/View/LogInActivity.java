package com.hfad.mvplogin.ui.activity.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.support.design.widget.FloatingActionButton;

import com.hfad.mvplogin.MVPLoginApplication;
import com.hfad.mvplogin.R;
//import com.hfad.mvplogin.data.DataManager;
import com.hfad.mvplogin.data.DataManager;
import com.hfad.mvplogin.data.model.User;
import com.hfad.mvplogin.ui.BaseActivity;
import com.hfad.mvplogin.ui.activity.Interactor.LoginInteractor;
import com.hfad.mvplogin.ui.activity.Presenter.LoginPresenter;
import com.hfad.mvplogin.ui.activity.component.LoginComponent;
import com.hfad.mvplogin.ui.activity.module.LogInModule;

import javax.inject.Inject;

public class LogInActivity extends BaseActivity implements LoginView {

    public static int ADD_USER_REQUEST = 1;

    private ProgressBar progressBar;
    EditText edit_email;
    EditText edit_password;
    Button btnLogin;
    FloatingActionButton buttonAddUser;

    @Inject
    LoginPresenter loginActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress);
        btnLogin = (Button) findViewById(R.id.btn_login);
        edit_email = (EditText) findViewById(R.id.edit_email);
        edit_password = (EditText)findViewById(R.id.edit_password);
        buttonAddUser = findViewById(R.id.button_add_user);
        setAddUserListener();
        setLoginListener();
    }

    protected void setupComponent() {
        MVPLoginApplication.get(this)
                .getAppComponent()
                .plus(new LogInModule(this))
                .inject(this);
    }

    private void setAddUserListener(){
        buttonAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this, AddUserActivity.class);
                startActivityForResult(intent, ADD_USER_REQUEST);
            }
        });
    }

    private void setLoginListener(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateCredentials();
            }
        });
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setEmailError(String error) {
        edit_email.setError(error);
    }

    @Override
    public void setPasswordError() {
        edit_password.setError("Password is not correct");
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, GreetActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        loginActivityPresenter.onDestroy();
        super.onDestroy();
    }

    private void validateCredentials() {
        loginActivityPresenter.validateCredentials(edit_email.getText().toString(), edit_password.getText().toString());
    }


}
