package com.lucky.demo.data.room;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.util.List;
import java.util.Map;

/**
 * Created by qw on 18-12-2.
 */

public class RoomEntity {
    @Entity(tableName = "User")
    public static class User {
        @PrimaryKey
        @NonNull
        public int userId;
        public String name;
        public String headPic;
        public int bookId = 0;

    }

    @Entity(tableName = "Word")
    public static class Word {

        @PrimaryKey
        @NonNull
        public String word;
        public String pt;
        public String ptMp3;

        @TypeConverters(RoomConvert.class)
        public List<Map<String,String>> means;
        @TypeConverters(RoomConvert.class)
        public List<Map<String,String>> examples;
    }

    @Entity(tableName = "Book")
    public static class Book {
        @PrimaryKey
        @NonNull
        public int bookId;
        public String name;
        public int wordCount;
    }

    @Entity(tableName = "BookWord")
    public static class BookWord {
        @PrimaryKey(autoGenerate = true)
        @NonNull
        public int id;
        public int bookId;
        public String word;
    }

    @Entity(tableName = "UserWord")
    public static class UserWord {
        public static final int TAG_DOING = 1;
        public static final int TAG_DONE = 2;

        @PrimaryKey(autoGenerate = true)
        @NonNull
        public int id;
        public int userId;
        public String word;
        public int tag;
        public int favor;
    }
}
