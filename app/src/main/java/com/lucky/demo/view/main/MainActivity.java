package com.lucky.demo.view.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lucky.demo.R;
import com.lucky.demo.data.room.RoomDb;
import com.lucky.demo.data.room.RoomEntity.Book;
import com.lucky.demo.data.room.RoomEntity.User;
import com.lucky.demo.databinding.ActivityMainBinding;
import com.lucky.demo.util.AppExecutors;
import com.lucky.demo.util.TestDataUtil;
import com.lucky.demo.view.main.MainContract.Presenter;
import com.lucky.demo.view.main.MainContract.View;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View {
    MainContract.Presenter presenter;
    ActivityMainBinding bindding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //测试数据
        TestDataUtil.initDataBase(this);

        presenter = new MainPresenter(new AppExecutors(),
                RoomDb.getInstance(this).dao(), this);
        presenter.start();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onInitDataSuccess(Map<String, Object> data) {
        bindding.setUser((User) data.get("user"));
        bindding.setBook((Book) data.get("book"));
        bindding.setStatInfo((Map<String, Integer>) data.get("statInfo"));
    }
}
