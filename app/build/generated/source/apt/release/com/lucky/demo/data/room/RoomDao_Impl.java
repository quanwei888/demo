package com.lucky.demo.data.room;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.util.StringUtil;
import android.database.Cursor;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.List;

public class RoomDao_Impl implements RoomDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUser;

  private final EntityInsertionAdapter __insertionAdapterOfWord;

  private final EntityInsertionAdapter __insertionAdapterOfMean;

  private final EntityInsertionAdapter __insertionAdapterOfExample;

  private final EntityInsertionAdapter __insertionAdapterOfBook;

  private final EntityInsertionAdapter __insertionAdapterOfBookWord;

  private final EntityInsertionAdapter __insertionAdapterOfUserWord;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfWord;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfMean;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfExample;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfBook;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfBookWord;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfUserWord;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfWord;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfMean;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfExample;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfBook;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfBookWord;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfUserWord;

  public RoomDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<RoomEntity.User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `User`(`userId`,`name`,`headPic`,`bookId`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.User value) {
        stmt.bindLong(1, value.userId);
        if (value.name == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.name);
        }
        if (value.headPic == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.headPic);
        }
        stmt.bindLong(4, value.bookId);
      }
    };
    this.__insertionAdapterOfWord = new EntityInsertionAdapter<RoomEntity.Word>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Word`(`word`,`pt`,`ptMp3`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.Word value) {
        if (value.word == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.word);
        }
        if (value.pt == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.pt);
        }
        if (value.ptMp3 == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.ptMp3);
        }
      }
    };
    this.__insertionAdapterOfMean = new EntityInsertionAdapter<RoomEntity.Mean>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Mean`(`meanId`,`word`,`pos`,`value`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.Mean value) {
        stmt.bindLong(1, value.meanId);
        if (value.word == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.word);
        }
        if (value.pos == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.pos);
        }
        if (value.value == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.value);
        }
      }
    };
    this.__insertionAdapterOfExample = new EntityInsertionAdapter<RoomEntity.Example>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Example`(`exampleId`,`word`,`en`,`cn`,`mp3`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.Example value) {
        stmt.bindLong(1, value.exampleId);
        if (value.word == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.word);
        }
        if (value.en == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.en);
        }
        if (value.cn == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.cn);
        }
        if (value.mp3 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.mp3);
        }
      }
    };
    this.__insertionAdapterOfBook = new EntityInsertionAdapter<RoomEntity.Book>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Book`(`bookId`,`name`,`wordCount`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.Book value) {
        stmt.bindLong(1, value.bookId);
        if (value.name == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.name);
        }
        stmt.bindLong(3, value.wordCount);
      }
    };
    this.__insertionAdapterOfBookWord = new EntityInsertionAdapter<RoomEntity.BookWord>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `BookWord`(`id`,`bookId`,`word`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.BookWord value) {
        stmt.bindLong(1, value.id);
        stmt.bindLong(2, value.bookId);
        if (value.word == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.word);
        }
      }
    };
    this.__insertionAdapterOfUserWord = new EntityInsertionAdapter<RoomEntity.UserWord>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `UserWord`(`id`,`userId`,`word`,`tag`,`favor`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.UserWord value) {
        stmt.bindLong(1, value.id);
        stmt.bindLong(2, value.userId);
        if (value.word == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.word);
        }
        stmt.bindLong(4, value.tag);
        stmt.bindLong(5, value.favor);
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<RoomEntity.User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `User` WHERE `userId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.User value) {
        stmt.bindLong(1, value.userId);
      }
    };
    this.__deletionAdapterOfWord = new EntityDeletionOrUpdateAdapter<RoomEntity.Word>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Word` WHERE `word` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.Word value) {
        if (value.word == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.word);
        }
      }
    };
    this.__deletionAdapterOfMean = new EntityDeletionOrUpdateAdapter<RoomEntity.Mean>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Mean` WHERE `meanId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.Mean value) {
        stmt.bindLong(1, value.meanId);
      }
    };
    this.__deletionAdapterOfExample = new EntityDeletionOrUpdateAdapter<RoomEntity.Example>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Example` WHERE `exampleId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.Example value) {
        stmt.bindLong(1, value.exampleId);
      }
    };
    this.__deletionAdapterOfBook = new EntityDeletionOrUpdateAdapter<RoomEntity.Book>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Book` WHERE `bookId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.Book value) {
        stmt.bindLong(1, value.bookId);
      }
    };
    this.__deletionAdapterOfBookWord = new EntityDeletionOrUpdateAdapter<RoomEntity.BookWord>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `BookWord` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.BookWord value) {
        stmt.bindLong(1, value.id);
      }
    };
    this.__deletionAdapterOfUserWord = new EntityDeletionOrUpdateAdapter<RoomEntity.UserWord>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `UserWord` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.UserWord value) {
        stmt.bindLong(1, value.id);
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<RoomEntity.User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `User` SET `userId` = ?,`name` = ?,`headPic` = ?,`bookId` = ? WHERE `userId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.User value) {
        stmt.bindLong(1, value.userId);
        if (value.name == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.name);
        }
        if (value.headPic == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.headPic);
        }
        stmt.bindLong(4, value.bookId);
        stmt.bindLong(5, value.userId);
      }
    };
    this.__updateAdapterOfWord = new EntityDeletionOrUpdateAdapter<RoomEntity.Word>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Word` SET `word` = ?,`pt` = ?,`ptMp3` = ? WHERE `word` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.Word value) {
        if (value.word == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.word);
        }
        if (value.pt == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.pt);
        }
        if (value.ptMp3 == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.ptMp3);
        }
        if (value.word == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.word);
        }
      }
    };
    this.__updateAdapterOfMean = new EntityDeletionOrUpdateAdapter<RoomEntity.Mean>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Mean` SET `meanId` = ?,`word` = ?,`pos` = ?,`value` = ? WHERE `meanId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.Mean value) {
        stmt.bindLong(1, value.meanId);
        if (value.word == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.word);
        }
        if (value.pos == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.pos);
        }
        if (value.value == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.value);
        }
        stmt.bindLong(5, value.meanId);
      }
    };
    this.__updateAdapterOfExample = new EntityDeletionOrUpdateAdapter<RoomEntity.Example>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Example` SET `exampleId` = ?,`word` = ?,`en` = ?,`cn` = ?,`mp3` = ? WHERE `exampleId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.Example value) {
        stmt.bindLong(1, value.exampleId);
        if (value.word == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.word);
        }
        if (value.en == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.en);
        }
        if (value.cn == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.cn);
        }
        if (value.mp3 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.mp3);
        }
        stmt.bindLong(6, value.exampleId);
      }
    };
    this.__updateAdapterOfBook = new EntityDeletionOrUpdateAdapter<RoomEntity.Book>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Book` SET `bookId` = ?,`name` = ?,`wordCount` = ? WHERE `bookId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.Book value) {
        stmt.bindLong(1, value.bookId);
        if (value.name == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.name);
        }
        stmt.bindLong(3, value.wordCount);
        stmt.bindLong(4, value.bookId);
      }
    };
    this.__updateAdapterOfBookWord = new EntityDeletionOrUpdateAdapter<RoomEntity.BookWord>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `BookWord` SET `id` = ?,`bookId` = ?,`word` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.BookWord value) {
        stmt.bindLong(1, value.id);
        stmt.bindLong(2, value.bookId);
        if (value.word == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.word);
        }
        stmt.bindLong(4, value.id);
      }
    };
    this.__updateAdapterOfUserWord = new EntityDeletionOrUpdateAdapter<RoomEntity.UserWord>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `UserWord` SET `id` = ?,`userId` = ?,`word` = ?,`tag` = ?,`favor` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomEntity.UserWord value) {
        stmt.bindLong(1, value.id);
        stmt.bindLong(2, value.userId);
        if (value.word == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.word);
        }
        stmt.bindLong(4, value.tag);
        stmt.bindLong(5, value.favor);
        stmt.bindLong(6, value.id);
      }
    };
  }

  @Override
  public void insertUsers(RoomEntity.User... users) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWords(RoomEntity.Word... words) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfWord.insert(words);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertMeans(RoomEntity.Mean... means) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfMean.insert(means);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertExamples(RoomEntity.Example... examples) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfExample.insert(examples);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBooks(RoomEntity.Book... books) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfBook.insert(books);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBookWords(RoomEntity.BookWord... bookWords) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfBookWord.insert(bookWords);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertUserWords(RoomEntity.UserWord... userWords) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUserWord.insert(userWords);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteUsers(RoomEntity.User... users) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handleMultiple(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteWords(RoomEntity.Word... words) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfWord.handleMultiple(words);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteMeans(RoomEntity.Mean... means) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfMean.handleMultiple(means);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteExamples(RoomEntity.Example... examples) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfExample.handleMultiple(examples);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteBooks(RoomEntity.Book... books) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfBook.handleMultiple(books);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteBookWords(RoomEntity.BookWord... bookWords) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfBookWord.handleMultiple(bookWords);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteUserWords(RoomEntity.UserWord... userWords) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfUserWord.handleMultiple(userWords);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUsers(RoomEntity.User... users) {
    __db.beginTransaction();
    try {
      __updateAdapterOfUser.handleMultiple(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateWords(RoomEntity.Word... words) {
    __db.beginTransaction();
    try {
      __updateAdapterOfWord.handleMultiple(words);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateMeans(RoomEntity.Mean... means) {
    __db.beginTransaction();
    try {
      __updateAdapterOfMean.handleMultiple(means);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateExamples(RoomEntity.Example... examples) {
    __db.beginTransaction();
    try {
      __updateAdapterOfExample.handleMultiple(examples);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateBooks(RoomEntity.Book... books) {
    __db.beginTransaction();
    try {
      __updateAdapterOfBook.handleMultiple(books);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateBookWords(RoomEntity.BookWord... bookWords) {
    __db.beginTransaction();
    try {
      __updateAdapterOfBookWord.handleMultiple(bookWords);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUserWords(RoomEntity.UserWord... userWords) {
    __db.beginTransaction();
    try {
      __updateAdapterOfUserWord.handleMultiple(userWords);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public RoomEntity.User getUser(int userId) {
    final String _sql = "SELECT * FROM User WHERE userId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfUserId = _cursor.getColumnIndexOrThrow("userId");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfHeadPic = _cursor.getColumnIndexOrThrow("headPic");
      final int _cursorIndexOfBookId = _cursor.getColumnIndexOrThrow("bookId");
      final RoomEntity.User _result;
      if(_cursor.moveToFirst()) {
        _result = new RoomEntity.User();
        _result.userId = _cursor.getInt(_cursorIndexOfUserId);
        _result.name = _cursor.getString(_cursorIndexOfName);
        _result.headPic = _cursor.getString(_cursorIndexOfHeadPic);
        _result.bookId = _cursor.getInt(_cursorIndexOfBookId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public RoomEntity.Word getWord(String word) {
    final String _sql = "SELECT * FROM Word WHERE word=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (word == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, word);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfWord = _cursor.getColumnIndexOrThrow("word");
      final int _cursorIndexOfPt = _cursor.getColumnIndexOrThrow("pt");
      final int _cursorIndexOfPtMp3 = _cursor.getColumnIndexOrThrow("ptMp3");
      final RoomEntity.Word _result;
      if(_cursor.moveToFirst()) {
        _result = new RoomEntity.Word();
        _result.word = _cursor.getString(_cursorIndexOfWord);
        _result.pt = _cursor.getString(_cursorIndexOfPt);
        _result.ptMp3 = _cursor.getString(_cursorIndexOfPtMp3);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<RoomEntity.Word> getWord(List<String> words) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM Word WHERE word in (");
    final int _inputSize = words.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : words) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfWord = _cursor.getColumnIndexOrThrow("word");
      final int _cursorIndexOfPt = _cursor.getColumnIndexOrThrow("pt");
      final int _cursorIndexOfPtMp3 = _cursor.getColumnIndexOrThrow("ptMp3");
      final List<RoomEntity.Word> _result = new ArrayList<RoomEntity.Word>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final RoomEntity.Word _item_1;
        _item_1 = new RoomEntity.Word();
        _item_1.word = _cursor.getString(_cursorIndexOfWord);
        _item_1.pt = _cursor.getString(_cursorIndexOfPt);
        _item_1.ptMp3 = _cursor.getString(_cursorIndexOfPtMp3);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<RoomEntity.Mean> getMeans(String word) {
    final String _sql = "SELECT * FROM Mean WHERE word=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (word == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, word);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfMeanId = _cursor.getColumnIndexOrThrow("meanId");
      final int _cursorIndexOfWord = _cursor.getColumnIndexOrThrow("word");
      final int _cursorIndexOfPos = _cursor.getColumnIndexOrThrow("pos");
      final int _cursorIndexOfValue = _cursor.getColumnIndexOrThrow("value");
      final List<RoomEntity.Mean> _result = new ArrayList<RoomEntity.Mean>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final RoomEntity.Mean _item;
        _item = new RoomEntity.Mean();
        _item.meanId = _cursor.getInt(_cursorIndexOfMeanId);
        _item.word = _cursor.getString(_cursorIndexOfWord);
        _item.pos = _cursor.getString(_cursorIndexOfPos);
        _item.value = _cursor.getString(_cursorIndexOfValue);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public RoomEntity.Book getBook(int bookId) {
    final String _sql = "SELECT * FROM Book WHERE bookId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, bookId);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfBookId = _cursor.getColumnIndexOrThrow("bookId");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfWordCount = _cursor.getColumnIndexOrThrow("wordCount");
      final RoomEntity.Book _result;
      if(_cursor.moveToFirst()) {
        _result = new RoomEntity.Book();
        _result.bookId = _cursor.getInt(_cursorIndexOfBookId);
        _result.name = _cursor.getString(_cursorIndexOfName);
        _result.wordCount = _cursor.getInt(_cursorIndexOfWordCount);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getBookWordsCount(int tag) {
    final String _sql = "SELECT COUNT(1) FROM BookWord INNER JOIN UserWord on BookWord.word=UserWord.word WHERE tag=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, tag);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getUserWordsCount(int tag) {
    final String _sql = "SELECT COUNT(1) FROM UserWord WHERE tag=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, tag);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
