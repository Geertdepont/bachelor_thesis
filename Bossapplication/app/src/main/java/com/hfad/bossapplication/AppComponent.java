package com.hfad.bossapplication;

import android.app.Application;

import com.hfad.bossapplication.View.Component.EmployeeComponent;
import com.hfad.bossapplication.View.Module.EmployeeModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    Application getApplication();

    void inject(BossApplication bossApplication);

    EmployeeComponent plus(EmployeeModule module);

}