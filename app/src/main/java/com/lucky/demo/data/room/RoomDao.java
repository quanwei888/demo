package com.lucky.demo.data.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.lucky.demo.data.room.RoomEntity.*;

import java.util.List;

/**
 * Created by qw on 18-12-2.
 */
@Dao
public interface RoomDao {

    /********User表操作***/
    @Insert
    void insertUsers(User... users);

    @Update
    void updateUsers(User... users);

    @Delete
    void deleteUsers(User... users);

    @Query("SELECT * FROM User WHERE userId=:userId")
    User getUser(int userId);

    /********Word表操作***/
    @Insert
    void insertWords(Word... words);

    @Update
    void updateWords(Word... words);

    @Delete
    void deleteWords(Word... words);

    @Query("SELECT * FROM Word WHERE word=:word")
    Word getWord(String word);

    @Query("SELECT * FROM Word WHERE word in (:words)")
    List<Word> getWord(List<String> words);


    @Query("SELECT * FROM Mean WHERE word=:word")
    List<Mean> getMeans(String word);

    /********Mean表操作***/
    @Insert
    void insertMeans(Mean... means);

    @Update
    void updateMeans(Mean... means);

    @Delete
    void deleteMeans(Mean... means);

    /********Example表操作***/
    @Insert
    void insertExamples(Example... examples);

    @Update
    void updateExamples(Example... examples);

    @Delete
    void deleteExamples(Example... examples);

    /********Book表操作***/
    @Insert
    void insertBooks(Book... books);

    @Update
    void updateBooks(Book... books);

    @Delete
    void deleteBooks(Book... books);

    @Query("SELECT * FROM Book WHERE bookId=:bookId")
    Book getBook(int bookId);

    /********BookWord***/
    @Insert
    void insertBookWords(BookWord... bookWords);

    @Update
    void updateBookWords(BookWord... bookWords);

    @Delete
    void deleteBookWords(BookWord... bookWords);

    /********UserWord***/
    @Insert
    void insertUserWords(UserWord... userWords);

    @Update
    void updateUserWords(UserWord... userWords);

    @Delete
    void deleteUserWords(UserWord... userWords);
}
