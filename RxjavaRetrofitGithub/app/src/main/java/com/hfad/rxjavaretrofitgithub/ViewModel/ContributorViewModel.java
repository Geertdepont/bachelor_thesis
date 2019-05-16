package com.hfad.rxjavaretrofitgithub.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.hfad.rxjavaretrofitgithub.View.Adapter.ContributorAdapter;
import com.hfad.rxjavaretrofitgithub.Model.Contributor;
import com.hfad.rxjavaretrofitgithub.Service.ApplicationRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ContributorViewModel extends ViewModel {

    private ApplicationRepository repository;
    CompositeDisposable compositeDisposable;

    private final MutableLiveData<List<Contributor>> mutableContributors = new MutableLiveData<>();
    private final MutableLiveData<Boolean> contributorsLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public ContributorViewModel() {
        this.repository = new ApplicationRepository();
        this.compositeDisposable = new CompositeDisposable();
        fetchUsers();
    }

    public void fetchUsers() {
        loading.setValue(true);
        compositeDisposable.add(repository.getContributorList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Contributor>>(){

                    @Override
                    public void onSuccess(List<Contributor> contributors) {
                        System.out.println("no error");
                        contributorsLoadError.setValue(false);
                        loading.setValue(false);
                        mutableContributors.setValue(contributors);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e);
                        loading.setValue(false);
                        contributorsLoadError.setValue(true);
                    }
                })
        );
    }

    public LiveData<List<Contributor>> getContributors() {
        return mutableContributors;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        if (compositeDisposable != null) {
            compositeDisposable.clear();
            compositeDisposable = null;
        }
    }

}
