package com.hfad.rxjavaretrofitgithub.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hfad.rxjavaretrofitgithub.Model.Contributor;
import com.hfad.rxjavaretrofitgithub.R;
import com.hfad.rxjavaretrofitgithub.View.Adapter.ContributorAdapter;
import com.hfad.rxjavaretrofitgithub.ViewModel.ContributorViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recycler_repositories;
    private ContributorViewModel contributorViewModel;
    private ContributorAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ContributorAdapter();

        recycler_repositories = (RecyclerView)findViewById(R.id.recycler_repositories);
        recycler_repositories.setHasFixedSize(true);
        recycler_repositories.setAdapter(adapter);
        recycler_repositories.setLayoutManager(new LinearLayoutManager(this));
        setViewModel();

        contributorViewModel.getContributors().observe(this, new Observer<List<Contributor>>() {
            @Override
            public void onChanged(@Nullable List<Contributor> contributors) {
                adapter.setContributors(contributors);
            }
        });
    }


    public void setViewModel(){
        contributorViewModel = ViewModelProviders.of(this).get(ContributorViewModel.class);
    }



}
