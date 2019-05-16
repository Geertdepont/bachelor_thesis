package com.hfad.bossapplication.Model;

import android.content.Context;
import android.support.annotation.NonNull;

import com.hfad.bossapplication.ApplicationContext;
import com.hfad.bossapplication.Model.Cache.EmployeeCache;
import com.hfad.bossapplication.Model.Entity.Employee;

import java.util.List;

import javax.inject.Inject;

public class EmployeeRepository {

    private static final String TAG = EmployeeRepository.class.getName();

    private EmployeeService service;
    private EmployeeCache cache;

    @Inject
    public EmployeeRepository(@ApplicationContext Context context) {
        service = new EmployeeService();
        cache = new EmployeeCache(context);
    }

    public void getList(@NonNull final OnViewEmployeesFinishedListener callback) {
        if (cache.savedListIsValid()) {
            callback.onSuccess(cache.getList());
        } else {
            OnViewEmployeesFinishedListener listener = new OnViewEmployeesFinishedListener() {
                @Override
                public void onError() {
                    callback.onError();
                }
                @Override
                public void onSuccess(List<Employee> employees) {
                    cache.saveList(employees);
                    callback.onSuccess(employees);
                }
            };
            service.listEmployees(listener);
        }
    }


    public interface OnViewEmployeesFinishedListener {
        void onError();

        void onSuccess(List<Employee> employees);
    }

}
