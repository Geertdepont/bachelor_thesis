package com.hfad.mvvmrxjava.view.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hfad.mvvmrxjava.R;
import com.hfad.mvvmrxjava.service.model.Note;
import com.hfad.mvvmrxjava.view.adapter.NoteAdapter;
import com.hfad.mvvmrxjava.viewmodel.Factories.NoteViewModelFactory;
import com.hfad.mvvmrxjava.viewmodel.NoteViewModel;

import java.util.List;



public class MainActivity extends AppCompatActivity {

    private NoteViewModel noteViewModel;
    private NoteViewModelFactory noteViewModelFactory;
    private FloatingActionButton buttonAdddNote;
    private NoteAdapter adapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdddNote = findViewById(R.id.button_add_note);
        setButtonAddNoteListener();
        adapter = new NoteAdapter();
        setRecyclerView();
        setNoteViewModelAndFactory();
    }


    private void setRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    private void setNoteViewModelAndFactory(){
        noteViewModelFactory = new NoteViewModelFactory(getApplication());
        noteViewModel = ViewModelProviders.of(this, noteViewModelFactory).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                adapter.setNotes(notes);
            }
        });
    }

    private void setButtonAddNoteListener(){
        buttonAdddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddNoteActivity.class));
            }
        });
    }

}
