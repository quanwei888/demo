package com.lucky.demo.data.room;

import android.support.annotation.NonNull;

import com.lucky.demo.data.room.RoomEntity.*;
import com.lucky.demo.util.AppExecutors;

/**
 * Created by qw on 18-11-29.
 */

public class RoomDataSource  {
    private static volatile RoomDataSource INSTANCE;
    AppExecutors appExecutors;
    RoomDao dao;

    private RoomDataSource(@NonNull AppExecutors appExecutors,
                           @NonNull RoomDao dao) {
        this.appExecutors = appExecutors;
        this.dao = dao;
    }

    public static RoomDataSource getInstance(@NonNull AppExecutors appExecutors,
                                             @NonNull RoomDao dao) {
        if (INSTANCE == null) {
            synchronized (RoomDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RoomDataSource(appExecutors, dao);
                }
            }
        }
        return INSTANCE;
    }


    public void saveUser(@NonNull final User user) {
        Runnable saveRunnable = new Runnable() {
            @Override
            public void run() {
                dao.insertUsers(user);
            }
        };
        appExecutors.diskIO().execute(saveRunnable);
    }

    public int getUserIdBySessionId(String sessionId) {
        return 1;
    }

}
