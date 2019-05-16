package com.hfad.mvplogin.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hfad.mvplogin.AppComponent;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent();
    }

    protected abstract void setupComponent();
}
