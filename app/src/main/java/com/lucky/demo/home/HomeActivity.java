package com.lucky.demo.home;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.lucky.demo.R;
import com.lucky.demo.data.UserState;

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
        mPresenter.loadUserState();
    }

    @Override
    public void showUserState(UserState state) {
        mBookNameView.setText(state.bookName);
        mReadDaysView.setText(String.valueOf(state.readDays));
    }

    @Override
    public Context context() {
        return getBaseContext();
    }
}
