package com.hfad.bossapplication.View.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hfad.bossapplication.Model.Entity.Employee;
import com.hfad.bossapplication.R;

public class EmployeeActivity extends AppCompatActivity {

    public static final String EMPLOYEE_ID = "employeeId";
    public static final String EMPLOYEE_NAME = "employeeName";
    public static final String EMPLOYEE_SALARY = "employeeSalary";

    public static final Employee[] employees = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        String name = (String)getIntent().getExtras().get(EMPLOYEE_NAME);
        TextView nameView = findViewById(R.id.name);
        nameView.setText("Employee name: " + name);

        String salary = (String)getIntent().getExtras().get(EMPLOYEE_SALARY);
        TextView salaryView = findViewById(R.id.salary);
        salaryView.setText("Employee salary: $" +salary);
    }
}
