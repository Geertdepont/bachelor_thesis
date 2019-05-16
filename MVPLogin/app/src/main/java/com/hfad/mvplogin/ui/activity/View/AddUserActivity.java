package com.hfad.mvplogin.ui.activity.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hfad.mvplogin.MVPLoginApplication;
import com.hfad.mvplogin.R;
import com.hfad.mvplogin.ui.BaseActivity;
import com.hfad.mvplogin.ui.activity.Presenter.AddUserPresenter;
import com.hfad.mvplogin.ui.activity.Presenter.LoginPresenter;
import com.hfad.mvplogin.ui.activity.module.AddUserModule;
import com.hfad.mvplogin.ui.activity.module.LogInModule;

import javax.inject.Inject;

import es.dmoral.toasty.Toasty;


public class AddUserActivity extends BaseActivity implements AddUserView{

    private EditText editEmail;
    private EditText editPassword;
    private ProgressBar progressBar;


    @Inject
    AddUserPresenter addUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        editEmail = findViewById(R.id.email);
        editPassword = findViewById(R.id.password);
        progressBar = findViewById(R.id.progress);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add user");
    }

    @Override
    protected void setupComponent() {
        MVPLoginApplication.get(this)
                .getAppComponent()
                .plus(new AddUserModule(this))
                .inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_user_menu, menu);
        return true;
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
    public void saveUser() {
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();
        addUserPresenter.addUser(email, password);
    }

    @Override
    public void setEmailError(String error) {
        editEmail.setError(error);
    }

    @Override
    public void setPasswordError() {
        editPassword.setError("Password cannot be null");
    }

    @Override
    public void navigateToHome() {
        Toast.makeText(this, "User has been added", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, LogInActivity.class));
        finish();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_user:
                saveUser();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
