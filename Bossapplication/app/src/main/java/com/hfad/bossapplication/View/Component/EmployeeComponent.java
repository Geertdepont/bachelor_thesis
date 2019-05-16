package com.hfad.bossapplication.View.Component;


import com.hfad.bossapplication.View.Activity.MainActivity;
import com.hfad.bossapplication.View.Module.EmployeeModule;
import com.hfad.bossapplication.View.Scope.EmployeeScope;

import dagger.Subcomponent;

@EmployeeScope
@Subcomponent(modules = EmployeeModule.class)
public interface EmployeeComponent {

    void inject(MainActivity mainActivity);

}