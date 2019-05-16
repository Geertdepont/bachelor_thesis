package com.hfad.mvplogin.data;

import android.content.Context;
import android.content.res.Resources;

import com.hfad.mvplogin.data.model.User;
import com.hfad.mvplogin.ui.activity.ApplicationContext;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager {

    private Context mContext;
    private DbHelper mDbHelper;
    private SharedPrefsHelper mSharedPrefsHelper;

    public DataManager(@ApplicationContext Context context,
                       DbHelper dbHelper,
                       SharedPrefsHelper sharedPrefsHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mSharedPrefsHelper = sharedPrefsHelper;
    }


    public Long createUser(User user) throws Exception {
        return mDbHelper.insertUser(user);
    }

    public List<User> getAllUsers() throws Resources.NotFoundException, NullPointerException {
        return mDbHelper.getAllUsers();
    }

    public User getUser(String email) throws Resources.NotFoundException, NullPointerException {
        return mDbHelper.getUser(email);
    }

}
