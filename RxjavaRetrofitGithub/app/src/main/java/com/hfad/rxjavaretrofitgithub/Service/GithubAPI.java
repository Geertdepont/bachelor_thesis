package com.hfad.rxjavaretrofitgithub.Service;



import com.hfad.rxjavaretrofitgithub.Model.Contributor;
import com.hfad.rxjavaretrofitgithub.Model.Repository;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubAPI
{
    @GET("users/geertdepont/repos")
    Observable<List<Repository>> getRepositories();

    @GET("repos/geertdepont/{repo}/contributors")
    Observable<List<Contributor>> getContributors(@Path("repo") String repo);
}
