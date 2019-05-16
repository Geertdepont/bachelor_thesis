package com.hfad.bossapplication.View.Module;

import android.content.Context;

import com.hfad.bossapplication.ApplicationContext;
import com.hfad.bossapplication.Model.EmployeeRepository;
import com.hfad.bossapplication.Presenter.MainPresenter;
import com.hfad.bossapplication.View.MainView;
import com.hfad.bossapplication.View.Scope.EmployeeScope;

import dagger.Module;
import dagger.Provides;

@Module
public class EmployeeModule {

    private MainView mainView;

    public EmployeeModule(MainView mainView) {
        this.mainView = mainView;
    }

    @EmployeeScope
    @Provides
    MainView provideMainView() {
        return mainView;
    }

    @EmployeeScope
    @Provides
    MainPresenter provideMainPresenter(EmployeeRepository employeeRepository) {
        return new MainPresenter(mainView, employeeRepository);
    }

}
