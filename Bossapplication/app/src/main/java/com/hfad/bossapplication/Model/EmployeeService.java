package com.hfad.bossapplication.Model;

import com.hfad.bossapplication.Model.Entity.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmployeeService {

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    public EmployeeService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
    }


    public void listEmployees(final EmployeeRepository.OnViewEmployeesFinishedListener listener) {
        Call<List<Employee>> call = jsonPlaceHolderApi.getEmployees();

        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {

                if (!response.isSuccessful()) {
                    System.out.println("error");
                    listener.onError();
                    return;
                }

                List<Employee> employees = response.body();
                listener.onSuccess(employees);
                System.out.println("No error");
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                System.out.println("On failure");
                listener.onError();
            }
        });
    }


}
