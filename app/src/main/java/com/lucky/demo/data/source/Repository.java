package com.lucky.demo.data.source;

import android.support.annotation.NonNull;

import com.lucky.demo.data.Book;
import com.lucky.demo.data.BookSetting;
import com.lucky.demo.data.User;
import com.lucky.demo.data.Word;

import java.util.List;
import java.util.Map;

/**
 * Created by qw on 18-11-29.
 */

public  class Repository implements DataSource {
    private static Repository INSTANCE = null;

    private final DataSource mRemoteDataSource;

    private final DataSource mLocalDataSource;

    // Prevent direct instantiation.
    private Repository(@NonNull DataSource remoteDataSource,
                            @NonNull DataSource localDataSource) {
        mRemoteDataSource = remoteDataSource;
        mLocalDataSource = localDataSource;
    }

    public static Repository getInstance(DataSource tasksRemoteDataSource,
                                         DataSource tasksLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new Repository(tasksRemoteDataSource, tasksLocalDataSource);
        }
        return INSTANCE;
    }

    @Override
    public User getUser(int userId) {
        return null;
    }

    @Override
    public Book getBook(int bookId) {
        return null;
    }

    @Override
    public List<Book> getBookList(int userId) {
        return null;
    }

    @Override
    public Word getWord(int wordId) {
        return null;
    }

    @Override
    public List<Word> getWordList(int bookId) {
        return null;
    }

    @Override
    public List<Word> getWordList(int bookId, int tag) {
        return null;
    }

    @Override
    public List<Word> getWordList(int bookId, List<Integer> tags) {
        return null;
    }

    @Override
    public BookSetting getBookSetting(int userId, int bookId) {
        return null;
    }

    @Override
    public Map<Integer, Integer> getBookWordTags(int userId, int bookId) {
        return null;
    }
}
