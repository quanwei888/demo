package com.lucky.demo.home;

import android.support.annotation.NonNull;

import com.lucky.demo.data.UserState;
import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

public class HomePresenter implements HomeContract.Presenter {
    HomeContract.View mHomeView;
    DB dao;

    public HomePresenter(@NonNull HomeContract.View homeView) {
        mHomeView = homeView;
        try {
            dao = DBFactory.open(mHomeView.context(), "ConfigDB");
        } catch (SnappydbException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadUserState() {
        UserState state = null;
        try {
            if (!dao.exists("UserState")) {
                state = new UserState();
                state.bookName = "大学英语四级";
                state.readDays = 10;
                state.avgReadWord = 78;
                state.remainDays = 13;
                dao.put("UserState", state);
            }

            state = dao.get("UserState", UserState.class);
            mHomeView.showUserState(state);
        } catch (SnappydbException e) {
            e.printStackTrace();
        }
    }
}
