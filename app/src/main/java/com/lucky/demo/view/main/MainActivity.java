package com.lucky.demo.view.main;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lucky.demo.R;
import com.lucky.demo.data.room.RoomDb;
import com.lucky.demo.data.room.RoomEntity.*;
import com.lucky.demo.data.room.RoomDataSource;
import com.lucky.demo.databinding.ActivityMainBinding;
import com.lucky.demo.util.AppExecutors;
import com.lucky.demo.util.Session;
import com.lucky.demo.util.TestDataUtil;
import com.lucky.demo.view.login.LoginActivity;
import com.lucky.demo.view.main.MainContract.Presenter;
import com.lucky.demo.view.main.MainContract.View;

public class MainActivity extends AppCompatActivity implements View {
    MainContract.Presenter presenter;
    ActivityMainBinding bindding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //测试数据
        TestDataUtil.initDataBase(this);

        presenter = new MainPresenter(RoomDataSource.getInstance(new AppExecutors(),
                RoomDb.getInstance(this).dao()), this);
        presenter.login();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onLoginComplate() {
        if (Session.loginUser == null) {
            startActivity(new Intent(this, LoginActivity.class));
        }
        bindding.setUser(Session.loginUser);
        presenter.loadBook();

    }

    @Override
    public void onLoadBookComplate() {
        bindding.setBook(Session.book);
    }
}
