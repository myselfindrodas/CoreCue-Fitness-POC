package com.corecue.fitness.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.corecue.fitness.data.local.dao.ExerciseDao;
import com.corecue.fitness.data.local.dao.ExerciseDao_Impl;
import com.corecue.fitness.data.local.dao.SessionDao;
import com.corecue.fitness.data.local.dao.SessionDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ExerciseDao _exerciseDao;

  private volatile SessionDao _sessionDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `exercises` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `description` TEXT NOT NULL, `youtubeUrl` TEXT NOT NULL, `thumbnailUrl` TEXT NOT NULL, `durationSeconds` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `sessions` (`sessionId` TEXT NOT NULL, `exerciseId` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `overallScore` INTEGER NOT NULL, `firstHalfScore` INTEGER NOT NULL, `secondHalfScore` INTEGER NOT NULL, `postureStability` REAL NOT NULL, `repScoresCsv` TEXT NOT NULL, PRIMARY KEY(`sessionId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '281ef95a689ab659555b70a59bc21e62')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `exercises`");
        db.execSQL("DROP TABLE IF EXISTS `sessions`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsExercises = new HashMap<String, TableInfo.Column>(6);
        _columnsExercises.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExercises.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExercises.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExercises.put("youtubeUrl", new TableInfo.Column("youtubeUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExercises.put("thumbnailUrl", new TableInfo.Column("thumbnailUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExercises.put("durationSeconds", new TableInfo.Column("durationSeconds", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExercises = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesExercises = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoExercises = new TableInfo("exercises", _columnsExercises, _foreignKeysExercises, _indicesExercises);
        final TableInfo _existingExercises = TableInfo.read(db, "exercises");
        if (!_infoExercises.equals(_existingExercises)) {
          return new RoomOpenHelper.ValidationResult(false, "exercises(com.corecue.fitness.data.local.entity.ExerciseEntity).\n"
                  + " Expected:\n" + _infoExercises + "\n"
                  + " Found:\n" + _existingExercises);
        }
        final HashMap<String, TableInfo.Column> _columnsSessions = new HashMap<String, TableInfo.Column>(8);
        _columnsSessions.put("sessionId", new TableInfo.Column("sessionId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSessions.put("exerciseId", new TableInfo.Column("exerciseId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSessions.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSessions.put("overallScore", new TableInfo.Column("overallScore", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSessions.put("firstHalfScore", new TableInfo.Column("firstHalfScore", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSessions.put("secondHalfScore", new TableInfo.Column("secondHalfScore", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSessions.put("postureStability", new TableInfo.Column("postureStability", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSessions.put("repScoresCsv", new TableInfo.Column("repScoresCsv", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSessions = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSessions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSessions = new TableInfo("sessions", _columnsSessions, _foreignKeysSessions, _indicesSessions);
        final TableInfo _existingSessions = TableInfo.read(db, "sessions");
        if (!_infoSessions.equals(_existingSessions)) {
          return new RoomOpenHelper.ValidationResult(false, "sessions(com.corecue.fitness.data.local.entity.SessionEntity).\n"
                  + " Expected:\n" + _infoSessions + "\n"
                  + " Found:\n" + _existingSessions);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "281ef95a689ab659555b70a59bc21e62", "5b0b282747af33df3d906f8cdc553a43");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "exercises","sessions");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `exercises`");
      _db.execSQL("DELETE FROM `sessions`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ExerciseDao.class, ExerciseDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SessionDao.class, SessionDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ExerciseDao exerciseDao() {
    if (_exerciseDao != null) {
      return _exerciseDao;
    } else {
      synchronized(this) {
        if(_exerciseDao == null) {
          _exerciseDao = new ExerciseDao_Impl(this);
        }
        return _exerciseDao;
      }
    }
  }

  @Override
  public SessionDao sessionDao() {
    if (_sessionDao != null) {
      return _sessionDao;
    } else {
      synchronized(this) {
        if(_sessionDao == null) {
          _sessionDao = new SessionDao_Impl(this);
        }
        return _sessionDao;
      }
    }
  }
}
