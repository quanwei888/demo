package com.lucky.demo.data.source;

import android.support.annotation.NonNull;

import com.lucky.demo.data.BookSetting;
import com.lucky.demo.data.Task;
import com.lucky.demo.data.Word;
import com.lucky.demo.data.room.RoomEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by qw on 18-11-29.
 */

public abstract  class Repository implements DataSource {
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
        return INSTANCE;
    }


    public Task getCurrentTask() {
        Task task = new Task();
        task.words = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            task.words.add("aaa_" + i);
        }
        return task;
    }

    public Word getWord(String word) {
        Word wordObj = new Word();
        wordObj.word = word;
        wordObj.pt = "[abc]" + word;
        Word.Example example = new Word.Example();
        example.en = "enenene_" + word;
        example.cn = "cncncnc_" + word;
        wordObj.examples = new ArrayList<Word.Example>();
        wordObj.examples.add(example);
        return wordObj;
    }




    public List<Word> getWordList(int bookId) {
        return null;
    }

    public List<Word> getWordList(int bookId, int tag) {
        return null;
    }

    public List<Word> getWordList(int bookId, List<Integer> tags) {
        return null;
    }

    public BookSetting getBookSetting(int userId, int bookId) {
        return null;
    }

    public Map<Integer, Integer> getBookWordTags(int userId, int bookId) {
        return null;
    }

    @Override
    public void saveUser(RoomEntity.User user) {

    }
}
