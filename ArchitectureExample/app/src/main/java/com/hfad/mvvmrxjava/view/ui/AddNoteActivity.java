package com.hfad.mvvmrxjava.view.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.hfad.mvvmrxjava.R;
import com.hfad.mvvmrxjava.service.model.Note;
import com.hfad.mvvmrxjava.viewmodel.AddNoteViewModel;
import com.hfad.mvvmrxjava.viewmodel.Factories.AddNoteViewModelFactory;

public class AddNoteActivity extends AppCompatActivity {

    private AddNoteViewModel addNoteViewModel;
    private AddNoteViewModelFactory addNoteViewModelFactory;
    private EditText editTextTitle;
    private EditText editTextTitleDescription;
    private NumberPicker numberPickerPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextTitleDescription = findViewById(R.id.edit_text_description);
        numberPickerPriority = findViewById(R.id.number_picker_priority);
        setNumberPickerPriority();
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add note");
        setAddNoteViewModelAndFactory();
    }

    private void setAddNoteViewModelAndFactory(){
        addNoteViewModelFactory = new AddNoteViewModelFactory(getApplication());
        addNoteViewModel = ViewModelProviders.of(this, addNoteViewModelFactory).get(AddNoteViewModel.class);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    private void setNumberPickerPriority(){
        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);
    }

    private void saveNote() {
        String title = editTextTitle.getText().toString();
        String description = editTextTitleDescription.getText().toString();
        int priority = numberPickerPriority.getValue();

        if (title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }

        Note note = new Note(title, description, priority);
        addNoteViewModel.insert(note);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
