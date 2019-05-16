package com.hfad.mvplogin.ui.activity.View;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.hfad.mvplogin.MVPLoginApplication;
import com.hfad.mvplogin.R;
import com.hfad.mvplogin.data.model.User;
import com.hfad.mvplogin.ui.BaseActivity;
import com.hfad.mvplogin.ui.activity.Presenter.Auth.ViewUserPresenter;
import com.hfad.mvplogin.ui.activity.View.Credentials.Credentials;
import com.hfad.mvplogin.ui.activity.module.Auth.ViewUserModule;
import com.hfad.mvplogin.ui.adapter.UserAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ViewUsersActivity extends BaseActivity implements ViewUsersView{

    private ProgressBar progressBar;
    private ArrayList<User> arrayList;
    private ArrayAdapter<User> listAdapter;
    RecyclerView recyclerView;
    TextView errorView;

    @Inject
    ViewUserPresenter viewUserPresenter;

    @Inject
    Credentials mCredentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);
        errorView = findViewById(R.id.error_message);
        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progress);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        viewUserPresenter.showUsers();
    }

    @Override
    protected void setupComponent() {
        MVPLoginApplication.get(this)
                .getAuthComponent()
                .plus(new ViewUserModule(this))
                .inject(this);
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
    public void showUsers(List<User> userArray) {
        final UserAdapter adapter = new UserAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setUsers(userArray);
    }

    @Override
    public void showErrorMessage() {
        errorView.setVisibility(View.VISIBLE);
    }
}
