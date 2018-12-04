package com.lucky.demo.view.main;

import android.content.Context;

import com.lucky.demo.data.DataManager;
import com.lucky.demo.data.room.RoomEntity.*;
import com.lucky.demo.util.AppExecutors;
import com.lucky.demo.util.Session;
import com.lucky.demo.view.main.MainContract.*;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.annotations.NonNull;

/**
 * Created by qw on 18-12-1.
 */

public class MainPresenter implements Presenter {
    final View view;
    DataManager dm;
    AppExecutors appExecutors;

    public MainPresenter(AppExecutors appExecutors, @NonNull Context context, View view) {
        this.appExecutors = appExecutors;
        this.dm = DataManager.instance(context);
        this.view = view;
    }

    @Override
    public void prepareData() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                view.onDataReady(getData());
            }
        };

        appExecutors.diskIO().execute(runnable);
    }

    Map<String, Object> getData() {
        Map<String, Object> data = new HashMap<String, Object>();
        if (Session.loginUser == null) {
            int userId = 1;
            Session.loginUser = dm.getUser(userId);
        }
        data.put("user", Session.loginUser);

        return data;
    }
}
