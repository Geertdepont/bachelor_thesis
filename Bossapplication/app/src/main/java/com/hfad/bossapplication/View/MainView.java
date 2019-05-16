package com.hfad.bossapplication.View;

import com.hfad.bossapplication.Model.Entity.Employee;

import java.util.List;

public interface MainView {
    void showProgress();

    void hideProgress();

    void showUsers(List<Employee> employees);

    void showErrorMessage();
}
