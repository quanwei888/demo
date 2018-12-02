package com.lucky.demo.view.booklist;

import com.lucky.demo.data.room.RoomDao;
import com.lucky.demo.data.room.RoomEntity.Book;
import com.lucky.demo.data.room.RoomEntity.UserWord;
import com.lucky.demo.util.AppExecutors;
import com.lucky.demo.util.Session;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.annotations.NonNull;

/**
 * Created by qw on 18-12-1.
 */

public class BookListPresenter implements BookListContract.Presenter {
    final BookListContract.View view;
    RoomDao dao;
    AppExecutors appExecutors;

    public BookListPresenter(AppExecutors appExecutors, @NonNull RoomDao dao, BookListContract.View view) {
        this.appExecutors = appExecutors;
        this.dao = dao;
        this.view = view;
    }

    @Override
    public void start() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                view.onInitDataSuccess(initData());
            }
        };

        appExecutors.diskIO().execute(runnable);
    }

    Map<String, Object> initData() {
        Map<String, Object> data = new HashMap<String, Object>();
        if (Session.loginUser == null) {
            int userId = 1;
            Session.loginUser = dao.getUser(userId);
        }
        data.put("user", Session.loginUser);

        Book book = dao.getBook(Session.loginUser.bookId);
        data.put("book", book);

        Map<String, Integer> statInfo = new HashMap<String, Integer>();
        int doingCount = dao.getUserWordsCount(UserWord.TAG_DOING);
        int doneCount = dao.getUserWordsCount(UserWord.TAG_DONE);
        statInfo.put("doingCount", doingCount);
        statInfo.put("doneCount", doneCount);

        int bookDoingCount = dao.getBookWordsCount(UserWord.TAG_DOING);
        int bookDoneCount = dao.getBookWordsCount(UserWord.TAG_DONE);
        statInfo.put("bookDoingCount", bookDoingCount);
        statInfo.put("bookDoneCount", bookDoneCount);

        data.put("statInfo", statInfo);

        return data;
    }
}
