package com.lucky.demo.view.home;

import android.support.annotation.NonNull;

import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

public class HomePresenter implements HomeContract.Presenter {
    HomeContract.View mHomeView;

    public HomePresenter(@NonNull HomeContract.View homeView) {
        mHomeView = homeView;
    }

    @Override
    public void getsUserState() {

    }
}
