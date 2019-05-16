package com.hfad.bossapplication.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hfad.bossapplication.BossApplication;
import com.hfad.bossapplication.Model.Entity.Employee;
import com.hfad.bossapplication.Presenter.MainPresenter;
import com.hfad.bossapplication.R;
import com.hfad.bossapplication.View.MainView;
import com.hfad.bossapplication.View.Module.EmployeeModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainView {

    @Inject
    MainPresenter mainPresenter;

    private ArrayList<Employee> arrayList;
    private ArrayAdapter<Employee> listAdapter;
    private ListView listView;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress);
        arrayList = new ArrayList<Employee>();
        listAdapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, arrayList);
        setListener();
    }

    @Override
    protected void setupComponent() {
        BossApplication.get(this)
                .getAppComponent()
                .plus(new EmployeeModule(this))
                .inject(this);
    }

    public void onClick(View view){
        mainPresenter.showEmployees();
    }

    public void setListener (){
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> listView,
                                            View v,
                                            int position,
                                            long id) {
                        Intent intent = new Intent(MainActivity.this,
                                EmployeeActivity.class);
                        Employee selectedEmployee = (Employee) listView.getItemAtPosition(position);
                        intent.putExtra(EmployeeActivity.EMPLOYEE_NAME,  selectedEmployee.getName());
                        intent.putExtra(EmployeeActivity.EMPLOYEE_SALARY,  selectedEmployee.getSalary());
                        startActivity(intent);
                    }
                };

        listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
        listView.setAdapter(listAdapter);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showUsers(List<Employee> employees) {
        arrayList.clear();
        for (int i= 0; i< 10; i++){
            arrayList.add(new Employee(
                    employees.get(i).getId(),
                    employees.get(i).getName(),
                    employees.get(i).getSalary()
            ));
        }
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "There was an error", Toast.LENGTH_SHORT).show();
    }
}
