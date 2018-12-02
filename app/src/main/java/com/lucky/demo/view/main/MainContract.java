package com.lucky.demo.view.main;

import com.lucky.demo.data.room.RoomEntity;
import com.lucky.demo.view.BasePresenter;
import com.lucky.demo.view.BaseView;

import java.util.Map;

/**
 * Created by qw on 18-12-1.
 */

interface MainContract {
    interface View extends BaseView<Presenter> {
        void onInitDataSuccess(Map<String, Object> data);
    }

    interface Presenter extends BasePresenter {
    }
}
