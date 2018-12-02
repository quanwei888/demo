package com.lucky.demo.view.main;

import com.lucky.demo.data.room.RoomEntity.*;
import com.lucky.demo.data.source.DataSource;
import com.lucky.demo.util.Session;
import com.lucky.demo.view.main.MainContract.*;

import io.reactivex.annotations.NonNull;

/**
 * Created by qw on 18-12-1.
 */

public class MainPresenter implements Presenter {
    View view;
    DataSource ds;

    public MainPresenter(@NonNull DataSource ds, View view) {
        this.ds = ds;
        this.view = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void login() {
        if (Session.loginUser == null) {
            int userId = ds.getUserIdBySessionId(Session.sessionId);
            ds.getUser(userId, new DataSource.LoadCallback<User>() {

                @Override
                public void onDataLoaded(User user) {
                    Session.loginUser = user;
                    view.onLoginComplate();
                }

                @Override
                public void onDataNotAvailable() {

                }
            });
        } else {
            view.onLoginComplate();
        }
    }

    @Override
    public void loadBook() {
        if (Session.book == null) {
            int bookId = Session.loginUser.bookId;
            ds.getBook(bookId, new DataSource.LoadCallback<Book>() {

                @Override
                public void onDataLoaded(Book book) {
                    Session.book = book;
                    view.onLoadBookComplate();
                }

                @Override
                public void onDataNotAvailable() {

                }
            });
        } else {
            view.onLoadBookComplate();
        }
    }

}
