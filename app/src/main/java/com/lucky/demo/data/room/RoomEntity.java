package com.lucky.demo.data.room;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;
import android.support.annotation.NonNull;

import java.util.List;

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


        public int bookId = 0;

    }

    @Entity(tableName = "Word")
    public static class Word {

        @PrimaryKey
        @NonNull
        public String word;
        public String pt;
        public String ptMp3;
    }

    @Entity(tableName = "Mean")
    public static class Mean {
        @PrimaryKey(autoGenerate = true)
        @NonNull
        public int meanId;
        public String word;
        public String pos;
        public String value;
    }

    @Entity(tableName = "Example")
    public static class Example {
        @PrimaryKey(autoGenerate = true)
        @NonNull
        public int exampleId;


        public String word;
        public String en;
        public String cn;
        public String mp3;
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
        @PrimaryKey(autoGenerate = true)
        @NonNull
        public int id;
        public int userId;
        public String word;
        public int tag;
        public int favor;
    }
}
