package com.hfad.bossapplication.Model.Cache;


import android.content.Context;

import com.google.common.reflect.TypeToken;
import com.hfad.bossapplication.Model.Entity.CachedData;
import com.hfad.bossapplication.Model.Entity.Employee;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCache extends BaseCache {

    private static final String LIST_ID = "LIST";
    private static final String CACHE_EMPLOYEE_FILE_NAME = "Employee.json";

    public EmployeeCache(Context context) {
        super(context, CACHE_EMPLOYEE_FILE_NAME);
    }

    public void saveList(List<Employee> employeeList) {
        String responseJson = gson.toJson(employeeList);
        CachedData cachedData = find(LIST_ID);
        if (cachedData == null) {
            cachedData = new CachedData(LIST_ID);
        }
        cachedData.saveResponse(responseJson);
        save(cachedData);
    }

    public boolean savedListIsValid() {
        CachedData foundCachedData = find(LIST_ID);
        return foundCachedData != null && System.currentTimeMillis() - foundCachedData.savedTimestamp < 5000;
    }

    public List<Employee> getList() {
        List<Employee> employees = null;

        CachedData foundCachedData = find(LIST_ID);
        if (foundCachedData != null && System.currentTimeMillis() - foundCachedData.savedTimestamp < 5000) {
            Type listType = new TypeToken<ArrayList<Employee>>() {
            }.getType();
            employees = gson.fromJson(foundCachedData.responseJson, listType);
        }

        return employees;
    }

}
