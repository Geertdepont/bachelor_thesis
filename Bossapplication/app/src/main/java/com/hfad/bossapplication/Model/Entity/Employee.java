package com.hfad.bossapplication.Model.Entity;

import com.google.gson.annotations.SerializedName;

public class Employee {

    private int id;

    @SerializedName("employee_name")
    private String name;

    @SerializedName("employee_salary")
    private String salary;

    //Each employee has a name and salary
    public Employee(int id, String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSalary() {
        return salary;
    }

    public String toString() {
        return this.name;
    }
}
