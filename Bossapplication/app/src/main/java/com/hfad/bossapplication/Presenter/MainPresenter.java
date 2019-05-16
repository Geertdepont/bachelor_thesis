package com.hfad.bossapplication.Presenter;

import com.hfad.bossapplication.Model.EmployeeRepository;
import com.hfad.bossapplication.Model.Entity.Employee;
import com.hfad.bossapplication.View.MainView;

import java.util.List;

import javax.inject.Inject;

public class MainPresenter implements EmployeeRepository.OnViewEmployeesFinishedListener {

    private MainView mainView;
    private EmployeeRepository employeeRepository;

    @Inject
    public MainPresenter(MainView mainView, EmployeeRepository employeeRepository) {
        this.mainView = mainView;
        this.employeeRepository = employeeRepository;
    }

    public void showEmployees() {
        if (mainView != null) {
            mainView.showProgress();
        }

        employeeRepository.getList(this);
    }

    @Override
    public void onError() {
        mainView.hideProgress();
        mainView.showErrorMessage();
    }

    @Override
    public void onSuccess(List<Employee> employees) {
        mainView.hideProgress();
        mainView.showUsers(employees);
    }
}
