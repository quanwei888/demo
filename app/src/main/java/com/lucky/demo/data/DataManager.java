package com.lucky.demo.data;

import android.content.Context;
import android.database.Cursor;

import com.lucky.demo.data.room.RoomDao;
import com.lucky.demo.data.room.RoomDb;
import com.lucky.demo.data.room.RoomEntity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataManager {
    static DataManager instance;

    RoomDao dao;
    RoomDb db;


    public static DataManager instance(Context context) {
        if (instance == null) {
            instance = new DataManager(context);
        }
        return instance;
    }

    protected DataManager(Context context) {
        db = RoomDb.getInstance(context);
        dao = db.dao();
    }

    public User getUser(int userId) {
        return dao.getUser(userId);
    }

    public void saveUser(User user) {
        dao.updateUsers(user);
    }

    protected int fetchIntOne(String sql, Object[] args) {
        String data = fetchOne(sql, args);
        if (data == null) {
            return 0;
        }
        return Integer.parseInt(data);
    }

    protected String fetchOne(String sql, Object[] args) {
        List<List<String>> data = fetchData(sql, args);
        if (data.size() == 0) {
            return null;
        }
        return data.get(0).get(0);
    }

    protected List<List<String>> fetchData(String sql, Object[] args) {
        List<List<String>> result = new ArrayList<List<String>>();
        Cursor cursor = db.query(sql, args);
        while (cursor.moveToNext()) {
            List<String> row = new ArrayList<String>();
            for (int i = 0; i < cursor.getColumnCount(); i++) {
                row.add(cursor.getString(i));
            }
            result.add(row);
        }
        cursor.close();
        return result;
    }

    protected List<Map<String, String>> fetchDataWithCol(String sql, Object[] args) {
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        Cursor cursor = db.query(sql, args);
        while (cursor.moveToNext()) {
            Map<String, String> row = new HashMap<String, String>();
            for (String col : cursor.getColumnNames()) {
                row.put(col, cursor.getString(cursor.getColumnIndex(col)));
            }
            result.add(row);
        }
        cursor.close();
        return result;
    }
}
