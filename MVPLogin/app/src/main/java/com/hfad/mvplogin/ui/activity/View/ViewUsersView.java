package com.hfad.mvplogin.ui.activity.View;

import com.hfad.mvplogin.data.model.User;

import java.util.List;

public interface ViewUsersView {
    void showProgress();

    void hideProgress();

    void showUsers(List<User> userArray);

    void showErrorMessage();
}
