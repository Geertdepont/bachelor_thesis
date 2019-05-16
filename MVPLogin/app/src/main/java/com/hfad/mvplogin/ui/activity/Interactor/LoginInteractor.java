package com.hfad.mvplogin.ui.activity.Interactor;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;

import com.hfad.mvplogin.MVPLoginApplication;
import com.hfad.mvplogin.data.DataManager;
import com.hfad.mvplogin.data.model.User;
import com.hfad.mvplogin.ui.activity.ApplicationContext;

import javax.inject.Inject;

public class LoginInteractor {

    DataManager dataManager;

    @Inject
    public LoginInteractor(@ApplicationContext Context context) {
        dataManager = MVPLoginApplication.getDataManager(context);
    }

    public interface OnLoginFinishedListener {
        void onEmailError(String error);

        void onPasswordError();

        void onSuccess(String userName);
    }

    public void login(final String email, final String password, final OnLoginFinishedListener listener) {
        System.out.println(dataManager);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(email)) {
                    listener.onEmailError("Email cannot be Empty");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    listener.onPasswordError();
                    return;
                }

                try {
                    User user = dataManager.getUser(email);
                    if (user.getPassword().equals(password)) {
                        listener.onSuccess(email);
                    } else {
                        listener.onPasswordError();
                    }
                } catch (Exception e) {
                    listener.onEmailError("This user was not found");
                }
            }
        }, 1000);
    }
}
