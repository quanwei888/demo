package com.lucky.demo.view.home;

public interface HomeContract {
    interface View {
        void showUserState(HomeData data);
    }
    interface Presenter {
        void getsUserState();
    }
}
