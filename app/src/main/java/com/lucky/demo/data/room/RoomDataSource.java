package com.lucky.demo.data.room;

import android.support.annotation.NonNull;

import com.lucky.demo.data.room.RoomEntity.*;
import com.lucky.demo.data.source.DataSource;
import com.lucky.demo.util.AppExecutors;

/**
 * Created by qw on 18-11-29.
 */

public class RoomDataSource implements DataSource {
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


    @Override
    public void saveUser(@NonNull final User user) {
        Runnable saveRunnable = new Runnable() {
            @Override
            public void run() {
                dao.insertUsers(user);
            }
        };
        appExecutors.diskIO().execute(saveRunnable);
    }

    @Override
    public void getUser(@NonNull final int userId, @NonNull final LoadCallback<User> callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final User user = dao.getUser(userId);
                appExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (user != null) {
                            callback.onDataLoaded(user);
                        } else {
                            callback.onDataNotAvailable();
                        }
                    }
                });
            }
        };

        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public void getBook(@NonNull final int bookId, @NonNull final LoadCallback<Book> callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final Book book = dao.getBook(bookId);
                appExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (book != null) {
                            callback.onDataLoaded(book);
                        } else {
                            callback.onDataNotAvailable();
                        }
                    }
                });
            }
        };

        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public int getUserIdBySessionId(String sessionId) {
        return 1;
    }

}
