package com.hfad.mvplogin.ui.activity.Interactor;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;

import com.hfad.mvplogin.MVPLoginApplication;
import com.hfad.mvplogin.data.DataManager;
import com.hfad.mvplogin.data.model.User;
import com.hfad.mvplogin.ui.activity.ApplicationContext;

import java.util.List;

import javax.inject.Inject;

public class ViewUserInteractor {

    DataManager dataManager;

    @Inject
    public ViewUserInteractor(@ApplicationContext Context context) {
        dataManager = MVPLoginApplication.getDataManager(context);
    }

    public interface OnViewUserFinishedListener {
        void onError();

        void onSuccess(List<User> userArray);
    }

    public void showUsers(final ViewUserInteractor.OnViewUserFinishedListener listener) {
        try {
            List<User> userList = dataManager.getAllUsers();
            listener.onSuccess(userList);
        }catch (Resources.NotFoundException | NullPointerException e){
            e.printStackTrace();
            listener.onError();
        }
    }

}
