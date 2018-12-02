package com.lucky.demo.data.source;


import android.support.annotation.NonNull;

import com.lucky.demo.data.room.RoomEntity.*;

import java.util.List;


/**
 * Created by qw on 18-11-29.
 */


public interface DataSource {
    void saveUser(@NonNull User user);

    void getUser(@NonNull int userId, @NonNull LoadCallback<User> callback);

    void getBook(@NonNull int bookId, @NonNull LoadCallback<Book> callback);

    int getUserIdBySessionId(String sessionId);

    interface LoadCallback<T> {
        void onDataLoaded(T obj);

        void onDataNotAvailable();
    }

    interface LoadListCallback<T> {
        void onDataLoaded(List<T> data);

        void onDataNotAvailable();
    }


}
