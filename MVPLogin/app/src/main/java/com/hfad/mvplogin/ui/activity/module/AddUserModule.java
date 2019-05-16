package com.hfad.mvplogin.ui.activity.module;

import com.hfad.mvplogin.ui.activity.Interactor.AddUserInteractor;
import com.hfad.mvplogin.ui.activity.Interactor.LoginInteractor;
import com.hfad.mvplogin.ui.activity.Presenter.AddUserPresenter;
import com.hfad.mvplogin.ui.activity.Presenter.LoginPresenter;
import com.hfad.mvplogin.ui.activity.Scope.AddUserScope;
import com.hfad.mvplogin.ui.activity.View.AddUserView;
import com.hfad.mvplogin.ui.activity.View.LoginView;

import dagger.Module;
import dagger.Provides;

@Module
public class AddUserModule {

    private AddUserView addUserView;

    public AddUserModule(AddUserView addUserView) {
        this.addUserView = addUserView;
    }

    @AddUserScope
    @Provides
    public AddUserView provideAddUserView() {
        return addUserView;
    }


    @AddUserScope
    @Provides
    AddUserPresenter provideAddUserPresenter(AddUserInteractor addUserInteractor) {
        return new AddUserPresenter(this.addUserView, addUserInteractor);
    }
}
