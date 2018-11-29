package com.lucky.demo.view.home;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.lucky.demo.R;

public class HomeActivity extends AppCompatActivity implements HomeContract.View{
    HomeContract.Presenter mPresenter;

    TextView mBookNameView;
    TextView mReadDaysView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mBookNameView = (TextView)findViewById(R.id.bookName);
        mReadDaysView = (TextView)findViewById(R.id.readDays);

        mPresenter = new HomePresenter(this);
        mPresenter.getsUserState();
    }

    @Override
    public void showUserState(HomeData data) {
    }
}
