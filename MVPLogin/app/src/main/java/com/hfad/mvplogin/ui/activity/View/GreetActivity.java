package com.hfad.mvplogin.ui.activity.View;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.hfad.mvplogin.MVPLoginApplication;
import com.hfad.mvplogin.R;
import com.hfad.mvplogin.ui.BaseActivity;
import com.hfad.mvplogin.ui.activity.Presenter.Auth.GreetPresenter;
import com.hfad.mvplogin.ui.activity.Presenter.Auth.ViewUserPresenter;
import com.hfad.mvplogin.ui.activity.View.Credentials.Credentials;
import com.hfad.mvplogin.ui.activity.module.Auth.GreetModule;
import com.hfad.mvplogin.ui.activity.module.Auth.ViewUserModule;

import javax.inject.Inject;

public class GreetActivity extends BaseActivity implements GreetView{

    Button logoutButton;
    Button nextButton;
    TextView personalGreetingTextView;

    @Inject
    GreetPresenter greetPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet);
        logoutButton = findViewById(R.id.btnLogout);
        nextButton = findViewById(R.id.btnNext);
        personalGreetingTextView = findViewById(R.id.tvPersonalGreeting);
        greetPresenter.greet();
        setLogoutButton();
        setNextButton();
    }

    private void setLogoutButton(){
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MVPLoginApplication.clearAuthComponent();
                startActivity(new Intent(v.getContext(), LogInActivity.class));
                finish();
            }
        });
    }

    private void setNextButton(){
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), ViewUsersActivity.class));
                finish();
            }
        });
    }

    @Override
    protected void setupComponent() {
        MVPLoginApplication.get(this)
                .getAuthComponent()
                .plus(new GreetModule(this))
                .inject(this);
    }

    @Override
    public void showMessage(String message) {
        personalGreetingTextView.setText(message);
    }
}
