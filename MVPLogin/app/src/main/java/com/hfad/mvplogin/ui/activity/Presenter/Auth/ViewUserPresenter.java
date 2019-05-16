package com.hfad.mvplogin.ui.activity.Presenter.Auth;

import com.hfad.mvplogin.data.model.User;
import com.hfad.mvplogin.ui.activity.Interactor.ViewUserInteractor;
import com.hfad.mvplogin.ui.activity.View.ViewUsersView;

import java.util.List;

import javax.inject.Inject;

public class ViewUserPresenter implements ViewUserInteractor.OnViewUserFinishedListener{

    private ViewUsersView mViewUsersView;
    private ViewUserInteractor mViewUserInteractor;

    @Inject
    public ViewUserPresenter(ViewUsersView viewUsersView, ViewUserInteractor viewUserInteractor) {
        this.mViewUsersView = viewUsersView;
        this.mViewUserInteractor = viewUserInteractor;
    }

    public void showUsers() {
        if (mViewUsersView != null) {
            mViewUsersView.showProgress();
        }

        mViewUserInteractor.showUsers(this);
    }

    @Override
    public void onError() {
        if (mViewUsersView != null) {
            mViewUsersView.hideProgress();
            mViewUsersView.showErrorMessage();
        }
    }

    @Override
    public void onSuccess(List<User> userAray) {
        if (mViewUsersView != null) {
            mViewUsersView.hideProgress();
            mViewUsersView.showUsers(userAray);
        }
    }
}
