package com.hfad.mvvmrxjava.viewmodel.Factories;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.hfad.mvvmrxjava.viewmodel.NoteViewModel;

public class NoteViewModelFactory implements ViewModelProvider.Factory {

    private Application application;

    public NoteViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(NoteViewModel.class)) {
            return (T) new NoteViewModel(application);
        }
        else {
            throw new IllegalArgumentException("Unknown class");
        }

    }
}
