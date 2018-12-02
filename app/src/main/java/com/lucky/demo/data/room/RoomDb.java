package com.lucky.demo.data.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.lucky.demo.data.room.RoomEntity.*;

/**
 * Created by qw on 18-12-2.
 */

@Database(entities = {User.class,Word.class,Mean.class,Example.class,Book.class,BookWord.class,UserWord.class}, version = 1)
public abstract class RoomDb extends RoomDatabase {
    private static RoomDb INSTANCE;

    public abstract RoomDao dao();

    private static final Object sLock = new Object();

    public static RoomDb getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        RoomDb.class, "kanci.db")
                        .build();
            }
            return INSTANCE;
        }
    }
}
