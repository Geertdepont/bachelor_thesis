package com.hfad.mvvmrxjava.viewmodel;


import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.hfad.mvvmrxjava.service.model.Note;
import com.hfad.mvvmrxjava.service.repository.NoteRepository;

public class AddNoteViewModel extends ViewModel {

    private NoteRepository repository;

    public AddNoteViewModel(@NonNull Application application) {
        repository = new NoteRepository(application);
    }

    public void insert(Note note) {
        repository.insert(note);
    }
}
