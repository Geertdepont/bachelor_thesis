package com.hfad.mvplogin;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

//import com.hfad.mvplogin.data.DataManager;
import com.hfad.mvplogin.ui.DatabaseInfo;
import com.hfad.mvplogin.ui.activity.ApplicationContext;
import com.hfad.mvplogin.ui.activity.Interactor.LoginInteractor;
import com.hfad.mvplogin.ui.activity.Presenter.AddUserPresenter;
import com.hfad.mvplogin.ui.activity.Presenter.LoginPresenter;
import com.hfad.mvplogin.ui.activity.Scope.ActivityScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

}
