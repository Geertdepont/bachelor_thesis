package com.hfad.mvvmrxjava.viewmodel;

import android.app.Application;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.hfad.mvvmrxjava.service.model.Note;
import com.hfad.mvvmrxjava.service.repository.NoteRepository;

import java.util.List;

public class NoteViewModel extends ViewModel {

    private NoteRepository repository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        repository = new NoteRepository(application);
        allNotes = repository.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

}
