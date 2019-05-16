package com.hfad.bossapplication.Model;

import com.hfad.bossapplication.Model.Entity.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("employees")
    Call<List<Employee>> getEmployees();
}
