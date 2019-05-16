package com.hfad.rxjavaretrofitgithub.Service;

import com.hfad.rxjavaretrofitgithub.Model.Contributor;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;

public class ApplicationRepository {

    private GithubAPI myAPI;

    public ApplicationRepository() {
        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(GithubAPI.class);
    }

    public Single<List<Contributor>> getContributorList() {
        return myAPI.getRepositories()
                .flatMapIterable(x -> x)
                .flatMap(repo -> myAPI.getContributors(repo.getName()))
                .flatMapIterable(x -> x)
                .sorted((a, b) -> b.getContributions() - a.getContributions())
                .distinct()
                .toList();
    }



}
