package com.hfad.mvplogin.ui.activity.Interactor;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;

import com.hfad.mvplogin.MVPLoginApplication;
import com.hfad.mvplogin.data.DataManager;
import com.hfad.mvplogin.data.model.User;
import com.hfad.mvplogin.ui.activity.ApplicationContext;

import javax.inject.Inject;

public class AddUserInteractor {

    DataManager dataManager;

    @Inject
    public AddUserInteractor(@ApplicationContext Context context) {
        dataManager = MVPLoginApplication.getDataManager(context);
    }

    public interface OnAddUserFinishedListener {
        void onEmailError(String error);

        void onPasswordError();

        void onSuccess(String userName);
    }

    public void saveUser(final String email, final String password, final OnAddUserFinishedListener listener) {

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
                    if (user != null) {
                        listener.onEmailError("This user already exists");
                        return;
                    }
                } catch (Exception e) {

                }

                try {
                    dataManager.createUser(new User(email, password));
                    listener.onSuccess(email);
                }catch (Exception e){
                    e.printStackTrace();
                    listener.onEmailError("Something went wrong");
                }
            }
        }, 200);
    }
}
