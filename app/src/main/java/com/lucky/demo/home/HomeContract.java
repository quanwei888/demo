package com.lucky.demo.home;

import android.content.Context;

import com.lucky.demo.data.UserState;

public interface HomeContract {
    interface View {
        void showUserState(UserState state);
        Context context();

    }
    interface Presenter {
        void loadUserState();
    }
}
