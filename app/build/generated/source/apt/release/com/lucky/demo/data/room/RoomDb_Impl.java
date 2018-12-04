package com.lucky.demo.data.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;

public class RoomDb_Impl extends RoomDb {
  private volatile RoomDao _roomDao;

  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `User` (`userId` INTEGER NOT NULL, `name` TEXT, `headPic` TEXT, `bookId` INTEGER NOT NULL, PRIMARY KEY(`userId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Word` (`word` TEXT NOT NULL, `pt` TEXT, `ptMp3` TEXT, PRIMARY KEY(`word`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Mean` (`meanId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `word` TEXT, `pos` TEXT, `value` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Example` (`exampleId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `word` TEXT, `en` TEXT, `cn` TEXT, `mp3` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Book` (`bookId` INTEGER NOT NULL, `name` TEXT, `wordCount` INTEGER NOT NULL, PRIMARY KEY(`bookId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `BookWord` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `bookId` INTEGER NOT NULL, `word` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `UserWord` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` INTEGER NOT NULL, `word` TEXT, `tag` INTEGER NOT NULL, `favor` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"cdb4288c5c03598ba85da2f7e31428d5\")");
      }

      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `User`");
        _db.execSQL("DROP TABLE IF EXISTS `Word`");
        _db.execSQL("DROP TABLE IF EXISTS `Mean`");
        _db.execSQL("DROP TABLE IF EXISTS `Example`");
        _db.execSQL("DROP TABLE IF EXISTS `Book`");
        _db.execSQL("DROP TABLE IF EXISTS `BookWord`");
        _db.execSQL("DROP TABLE IF EXISTS `UserWord`");
      }

      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUser = new HashMap<String, TableInfo.Column>(4);
        _columnsUser.put("userId", new TableInfo.Column("userId", "INTEGER", true, 1));
        _columnsUser.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsUser.put("headPic", new TableInfo.Column("headPic", "TEXT", false, 0));
        _columnsUser.put("bookId", new TableInfo.Column("bookId", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUser = new TableInfo("User", _columnsUser, _foreignKeysUser, _indicesUser);
        final TableInfo _existingUser = TableInfo.read(_db, "User");
        if (! _infoUser.equals(_existingUser)) {
          throw new IllegalStateException("Migration didn't properly handle User(com.lucky.demo.data.room.RoomEntity.User).\n"
                  + " Expected:\n" + _infoUser + "\n"
                  + " Found:\n" + _existingUser);
        }
        final HashMap<String, TableInfo.Column> _columnsWord = new HashMap<String, TableInfo.Column>(3);
        _columnsWord.put("word", new TableInfo.Column("word", "TEXT", true, 1));
        _columnsWord.put("pt", new TableInfo.Column("pt", "TEXT", false, 0));
        _columnsWord.put("ptMp3", new TableInfo.Column("ptMp3", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWord = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWord = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWord = new TableInfo("Word", _columnsWord, _foreignKeysWord, _indicesWord);
        final TableInfo _existingWord = TableInfo.read(_db, "Word");
        if (! _infoWord.equals(_existingWord)) {
          throw new IllegalStateException("Migration didn't properly handle Word(com.lucky.demo.data.room.RoomEntity.Word).\n"
                  + " Expected:\n" + _infoWord + "\n"
                  + " Found:\n" + _existingWord);
        }
        final HashMap<String, TableInfo.Column> _columnsMean = new HashMap<String, TableInfo.Column>(4);
        _columnsMean.put("meanId", new TableInfo.Column("meanId", "INTEGER", true, 1));
        _columnsMean.put("word", new TableInfo.Column("word", "TEXT", false, 0));
        _columnsMean.put("pos", new TableInfo.Column("pos", "TEXT", false, 0));
        _columnsMean.put("value", new TableInfo.Column("value", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMean = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMean = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMean = new TableInfo("Mean", _columnsMean, _foreignKeysMean, _indicesMean);
        final TableInfo _existingMean = TableInfo.read(_db, "Mean");
        if (! _infoMean.equals(_existingMean)) {
          throw new IllegalStateException("Migration didn't properly handle Mean(com.lucky.demo.data.room.RoomEntity.Mean).\n"
                  + " Expected:\n" + _infoMean + "\n"
                  + " Found:\n" + _existingMean);
        }
        final HashMap<String, TableInfo.Column> _columnsExample = new HashMap<String, TableInfo.Column>(5);
        _columnsExample.put("exampleId", new TableInfo.Column("exampleId", "INTEGER", true, 1));
        _columnsExample.put("word", new TableInfo.Column("word", "TEXT", false, 0));
        _columnsExample.put("en", new TableInfo.Column("en", "TEXT", false, 0));
        _columnsExample.put("cn", new TableInfo.Column("cn", "TEXT", false, 0));
        _columnsExample.put("mp3", new TableInfo.Column("mp3", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExample = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesExample = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoExample = new TableInfo("Example", _columnsExample, _foreignKeysExample, _indicesExample);
        final TableInfo _existingExample = TableInfo.read(_db, "Example");
        if (! _infoExample.equals(_existingExample)) {
          throw new IllegalStateException("Migration didn't properly handle Example(com.lucky.demo.data.room.RoomEntity.Example).\n"
                  + " Expected:\n" + _infoExample + "\n"
                  + " Found:\n" + _existingExample);
        }
        final HashMap<String, TableInfo.Column> _columnsBook = new HashMap<String, TableInfo.Column>(3);
        _columnsBook.put("bookId", new TableInfo.Column("bookId", "INTEGER", true, 1));
        _columnsBook.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsBook.put("wordCount", new TableInfo.Column("wordCount", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBook = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBook = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBook = new TableInfo("Book", _columnsBook, _foreignKeysBook, _indicesBook);
        final TableInfo _existingBook = TableInfo.read(_db, "Book");
        if (! _infoBook.equals(_existingBook)) {
          throw new IllegalStateException("Migration didn't properly handle Book(com.lucky.demo.data.room.RoomEntity.Book).\n"
                  + " Expected:\n" + _infoBook + "\n"
                  + " Found:\n" + _existingBook);
        }
        final HashMap<String, TableInfo.Column> _columnsBookWord = new HashMap<String, TableInfo.Column>(3);
        _columnsBookWord.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsBookWord.put("bookId", new TableInfo.Column("bookId", "INTEGER", true, 0));
        _columnsBookWord.put("word", new TableInfo.Column("word", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBookWord = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBookWord = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBookWord = new TableInfo("BookWord", _columnsBookWord, _foreignKeysBookWord, _indicesBookWord);
        final TableInfo _existingBookWord = TableInfo.read(_db, "BookWord");
        if (! _infoBookWord.equals(_existingBookWord)) {
          throw new IllegalStateException("Migration didn't properly handle BookWord(com.lucky.demo.data.room.RoomEntity.BookWord).\n"
                  + " Expected:\n" + _infoBookWord + "\n"
                  + " Found:\n" + _existingBookWord);
        }
        final HashMap<String, TableInfo.Column> _columnsUserWord = new HashMap<String, TableInfo.Column>(5);
        _columnsUserWord.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsUserWord.put("userId", new TableInfo.Column("userId", "INTEGER", true, 0));
        _columnsUserWord.put("word", new TableInfo.Column("word", "TEXT", false, 0));
        _columnsUserWord.put("tag", new TableInfo.Column("tag", "INTEGER", true, 0));
        _columnsUserWord.put("favor", new TableInfo.Column("favor", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserWord = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserWord = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserWord = new TableInfo("UserWord", _columnsUserWord, _foreignKeysUserWord, _indicesUserWord);
        final TableInfo _existingUserWord = TableInfo.read(_db, "UserWord");
        if (! _infoUserWord.equals(_existingUserWord)) {
          throw new IllegalStateException("Migration didn't properly handle UserWord(com.lucky.demo.data.room.RoomEntity.UserWord).\n"
                  + " Expected:\n" + _infoUserWord + "\n"
                  + " Found:\n" + _existingUserWord);
        }
      }
    }, "cdb4288c5c03598ba85da2f7e31428d5");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "User","Word","Mean","Example","Book","BookWord","UserWord");
  }

  @Override
  public RoomDao dao() {
    if (_roomDao != null) {
      return _roomDao;
    } else {
      synchronized(this) {
        if(_roomDao == null) {
          _roomDao = new RoomDao_Impl(this);
        }
        return _roomDao;
      }
    }
  }
}
