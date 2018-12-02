package com.lucky.demo.util;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.lucky.demo.data.room.RoomDao;
import com.lucky.demo.data.room.RoomDataSource;
import com.lucky.demo.data.room.RoomDb;
import com.lucky.demo.data.room.RoomEntity.*;

import java.util.Random;

/**
 * Created by qw on 18-12-2.
 */

public class TestDataUtil {
    static RoomDao dao;

    public static void initDataBase(Context context) {
        if (dao == null) {
            dao = RoomDb.getInstance(context).dao();
        }
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final User user = dao.getUser(1);
                if (user == null) {
                    createTestData(dao);
                }
            }
        };
        Thread th = new Thread(runnable);
        th.start();
        try {
            th.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void createTestData(RoomDao dao) {
        int COUNT = 100;
        Random random = new Random();
        //User
        for (int i = 1; i < COUNT; i++) {
            User user = new User();
            user.userId = i;
            user.name = "user_" + i;
            user.bookId = 1;
            dao.insertUsers(user);
            user = dao.getUser(i);
            int aaa=12;
            aaa+=123;
        }

        //Word
        for (int i = 1; i < COUNT; i++) {
            Word word = new Word();
            word.word = "word_" + i;
            word.pt = "[pt" + i + "]";
            word.ptMp3 = "/path/to/a.mp3";
            dao.insertWords(word);

            int meanCount = random.nextInt(3) + 2;
            for (int j = 1; j < meanCount; j++) {
                Mean mean = new Mean();
                mean.word = "word_" + i;
                mean.pos = "pos_" + j;
                mean.value = "mean_" + j;
                dao.insertMeans(mean);
            }
            int exampleCount = random.nextInt(5) + 2;
            for (int j = 1; j < exampleCount; j++) {
                Example example = new Example();
                example.word = "word_" + i;
                example.en = "en_" + j;
                example.cn = "中文_" + j;
                example.mp3 = "/path/to/a.mp3";
                dao.insertExamples(example);
            }
        }

        //Book
        COUNT = 10;
        for (int i = 1; i < COUNT; i++) {
            Book book = new Book();
            book.bookId = i;
            book.name = "book_" + i;
            int bookWordCountCount = random.nextInt(50) + 2;
            book.wordCount = bookWordCountCount - 1;
            dao.insertBooks(book);

            for (int j = 1; j < bookWordCountCount; j++) {
                BookWord word = new BookWord();
                word.word = "word_" + j;
                word.bookId = i;
                dao.insertBookWords(word);
            }
        }

        //UserWord
        COUNT = 100;
        for (int i = 1; i < COUNT; i += 3) {
            UserWord word = new UserWord();
            word.userId = 1;
            word.tag = random.nextInt(3);
            word.favor = random.nextInt(2);
            word.word = "word_" + i;
            dao.insertUserWords(word);
        }

    }
}
