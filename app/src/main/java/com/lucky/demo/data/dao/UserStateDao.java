package com.lucky.demo.data.dao;

import android.content.Context;

import com.lucky.demo.data.UserState;
import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

public class UserStateDao {
    static String DB_NAME="UserState";
    Context context;
    DB db;
    public UserStateDao(Context context) throws SnappydbException {
        context = context;
        db = DBFactory.open(context,DB_NAME);
    }
    public UserState get(int userId) {
        UserState state = null;

        try {
            state = db.getObject(String.valueOf(userId),UserState.class);
        } catch (SnappydbException e) {
            e.printStackTrace();
        }

        return state;
    }
    public void insertUserSta(int userId) {

    }
}
