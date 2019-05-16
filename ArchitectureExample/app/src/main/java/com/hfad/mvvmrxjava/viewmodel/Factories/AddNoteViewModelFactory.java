package com.hfad.mvvmrxjava.viewmodel.Factories;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.hfad.mvvmrxjava.viewmodel.AddNoteViewModel;


public class AddNoteViewModelFactory implements ViewModelProvider.Factory {

    private Application application;

    public AddNoteViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(AddNoteViewModel.class)) {
            return (T) new AddNoteViewModel(application);
        }
        else {
            throw new IllegalArgumentException("Unknown class");
        }

    }
}
