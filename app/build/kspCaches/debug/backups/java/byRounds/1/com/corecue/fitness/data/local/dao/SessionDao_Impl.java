package com.corecue.fitness.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.corecue.fitness.data.local.entity.SessionEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class SessionDao_Impl implements SessionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SessionEntity> __insertionAdapterOfSessionEntity;

  public SessionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSessionEntity = new EntityInsertionAdapter<SessionEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `sessions` (`sessionId`,`exerciseId`,`timestamp`,`overallScore`,`firstHalfScore`,`secondHalfScore`,`postureStability`,`repScoresCsv`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SessionEntity entity) {
        statement.bindString(1, entity.getSessionId());
        statement.bindString(2, entity.getExerciseId());
        statement.bindLong(3, entity.getTimestamp());
        statement.bindLong(4, entity.getOverallScore());
        statement.bindLong(5, entity.getFirstHalfScore());
        statement.bindLong(6, entity.getSecondHalfScore());
        statement.bindDouble(7, entity.getPostureStability());
        statement.bindString(8, entity.getRepScoresCsv());
      }
    };
  }

  @Override
  public Object insertSession(final SessionEntity sessionEntity,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSessionEntity.insert(sessionEntity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<SessionEntity>> observeRecentSessions() {
    final String _sql = "SELECT * FROM sessions ORDER BY timestamp DESC LIMIT 20";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"sessions"}, new Callable<List<SessionEntity>>() {
      @Override
      @NonNull
      public List<SessionEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSessionId = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionId");
          final int _cursorIndexOfExerciseId = CursorUtil.getColumnIndexOrThrow(_cursor, "exerciseId");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfOverallScore = CursorUtil.getColumnIndexOrThrow(_cursor, "overallScore");
          final int _cursorIndexOfFirstHalfScore = CursorUtil.getColumnIndexOrThrow(_cursor, "firstHalfScore");
          final int _cursorIndexOfSecondHalfScore = CursorUtil.getColumnIndexOrThrow(_cursor, "secondHalfScore");
          final int _cursorIndexOfPostureStability = CursorUtil.getColumnIndexOrThrow(_cursor, "postureStability");
          final int _cursorIndexOfRepScoresCsv = CursorUtil.getColumnIndexOrThrow(_cursor, "repScoresCsv");
          final List<SessionEntity> _result = new ArrayList<SessionEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SessionEntity _item;
            final String _tmpSessionId;
            _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
            final String _tmpExerciseId;
            _tmpExerciseId = _cursor.getString(_cursorIndexOfExerciseId);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final int _tmpOverallScore;
            _tmpOverallScore = _cursor.getInt(_cursorIndexOfOverallScore);
            final int _tmpFirstHalfScore;
            _tmpFirstHalfScore = _cursor.getInt(_cursorIndexOfFirstHalfScore);
            final int _tmpSecondHalfScore;
            _tmpSecondHalfScore = _cursor.getInt(_cursorIndexOfSecondHalfScore);
            final float _tmpPostureStability;
            _tmpPostureStability = _cursor.getFloat(_cursorIndexOfPostureStability);
            final String _tmpRepScoresCsv;
            _tmpRepScoresCsv = _cursor.getString(_cursorIndexOfRepScoresCsv);
            _item = new SessionEntity(_tmpSessionId,_tmpExerciseId,_tmpTimestamp,_tmpOverallScore,_tmpFirstHalfScore,_tmpSecondHalfScore,_tmpPostureStability,_tmpRepScoresCsv);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
