package com.hfad.mvplogin.ui.activity.component;


import com.hfad.mvplogin.ui.activity.Scope.AddUserScope;
import com.hfad.mvplogin.ui.activity.View.AddUserActivity;
import com.hfad.mvplogin.ui.activity.module.AddUserModule;

import dagger.Subcomponent;

@AddUserScope
@Subcomponent(modules = AddUserModule.class)
public interface AddUserComponent {

    void inject(AddUserActivity addUserActivity);
}
