package com.lucky.demo.data.source;

import com.lucky.demo.data.Book;
import com.lucky.demo.data.BookSetting;
import com.lucky.demo.data.User;
import com.lucky.demo.data.Word;

import java.util.List;
import java.util.Map;

/**
 * Created by qw on 18-11-29.
 */


public interface DataSource {
    User getUser(int userId);

    Book getBook(int bookId);
    List<Book> getBookList(int userId);

    Word getWord(int wordId);
    List<Word> getWordList(int bookId);
    List<Word> getWordList(int bookId,int tag);
    List<Word> getWordList(int bookId,List<Integer> tags);

    BookSetting getBookSetting(int userId, int bookId);

    Map<Integer,Integer> getBookWordTags(int userId,int bookId);
}
