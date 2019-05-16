package com.hfad.mvplogin.ui.activity.module.Auth;

import com.hfad.mvplogin.ui.activity.Interactor.ViewUserInteractor;
import com.hfad.mvplogin.ui.activity.Presenter.Auth.ViewUserPresenter;
import com.hfad.mvplogin.ui.activity.Scope.Auth.ViewUserScope;
import com.hfad.mvplogin.ui.activity.View.ViewUsersView;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewUserModule {

    private ViewUsersView viewUsersView;

    public ViewUserModule(ViewUsersView viewUsersView) {
        this.viewUsersView = viewUsersView;
    }

    @ViewUserScope
    @Provides
    ViewUsersView provideViewUsersView() {
        return viewUsersView;
    }

    @ViewUserScope
    @Provides
    ViewUserPresenter provideViewUserPresenter(ViewUserInteractor viewUserInteractor) {
        return new ViewUserPresenter(viewUsersView, viewUserInteractor);
    }
}
