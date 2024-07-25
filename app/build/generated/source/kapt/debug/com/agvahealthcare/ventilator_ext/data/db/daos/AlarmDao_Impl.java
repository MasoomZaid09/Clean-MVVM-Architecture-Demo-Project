package com.agvahealthcare.ventilator_ext.data.db.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AlarmDao_Impl implements AlarmDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AlarmDBModel> __insertionAdapterOfAlarmDBModel;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAlarms;

  public AlarmDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAlarmDBModel = new EntityInsertionAdapter<AlarmDBModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `alarm_table` (`key`,`message`,`createdAt`,`Uhid`,`Id`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AlarmDBModel value) {
        if (value.getKey() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getKey());
        }
        if (value.getMessage() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMessage());
        }
        if (value.getCreatedAt() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCreatedAt());
        }
        if (value.getUhid() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUhid());
        }
        if (value.getId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteAlarms = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM alarm_table WHERE id < ?";
        return _query;
      }
    };
  }

  @Override
  public Object addAlarmData(final AlarmDBModel alarmDBModel,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAlarmDBModel.insert(alarmDBModel);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAlarms(final int id1, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAlarms.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id1);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAlarms.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<AlarmDBModel>> readAllAlarms() {
    final String _sql = "SELECT * FROM alarm_table ORDER BY id DESC LIMIT 12";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"alarm_table"}, false, new Callable<List<AlarmDBModel>>() {
      @Override
      public List<AlarmDBModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfKey = CursorUtil.getColumnIndexOrThrow(_cursor, "key");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUhid = CursorUtil.getColumnIndexOrThrow(_cursor, "Uhid");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final List<AlarmDBModel> _result = new ArrayList<AlarmDBModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AlarmDBModel _item;
            final String _tmpKey;
            if (_cursor.isNull(_cursorIndexOfKey)) {
              _tmpKey = null;
            } else {
              _tmpKey = _cursor.getString(_cursorIndexOfKey);
            }
            final String _tmpMessage;
            if (_cursor.isNull(_cursorIndexOfMessage)) {
              _tmpMessage = null;
            } else {
              _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUhid;
            if (_cursor.isNull(_cursorIndexOfUhid)) {
              _tmpUhid = null;
            } else {
              _tmpUhid = _cursor.getString(_cursorIndexOfUhid);
            }
            _item = new AlarmDBModel(_tmpKey,_tmpMessage,_tmpCreatedAt,_tmpUhid);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
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

  @Override
  public Object readAlarmsByOld(final int id1,
      final Continuation<? super List<AlarmDBModel>> continuation) {
    final String _sql = "SELECT * FROM (SELECT * FROM alarm_table ORDER BY id DESC) WHERE id < ? LIMIT 12";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id1);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<AlarmDBModel>>() {
      @Override
      public List<AlarmDBModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfKey = CursorUtil.getColumnIndexOrThrow(_cursor, "key");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUhid = CursorUtil.getColumnIndexOrThrow(_cursor, "Uhid");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final List<AlarmDBModel> _result = new ArrayList<AlarmDBModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AlarmDBModel _item;
            final String _tmpKey;
            if (_cursor.isNull(_cursorIndexOfKey)) {
              _tmpKey = null;
            } else {
              _tmpKey = _cursor.getString(_cursorIndexOfKey);
            }
            final String _tmpMessage;
            if (_cursor.isNull(_cursorIndexOfMessage)) {
              _tmpMessage = null;
            } else {
              _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUhid;
            if (_cursor.isNull(_cursorIndexOfUhid)) {
              _tmpUhid = null;
            } else {
              _tmpUhid = _cursor.getString(_cursorIndexOfUhid);
            }
            _item = new AlarmDBModel(_tmpKey,_tmpMessage,_tmpCreatedAt,_tmpUhid);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object readAlarmsByNew(final int id1,
      final Continuation<? super List<AlarmDBModel>> continuation) {
    final String _sql = "SELECT * FROM alarm_table WHERE id > ? LIMIT 12";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id1);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<AlarmDBModel>>() {
      @Override
      public List<AlarmDBModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfKey = CursorUtil.getColumnIndexOrThrow(_cursor, "key");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUhid = CursorUtil.getColumnIndexOrThrow(_cursor, "Uhid");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final List<AlarmDBModel> _result = new ArrayList<AlarmDBModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AlarmDBModel _item;
            final String _tmpKey;
            if (_cursor.isNull(_cursorIndexOfKey)) {
              _tmpKey = null;
            } else {
              _tmpKey = _cursor.getString(_cursorIndexOfKey);
            }
            final String _tmpMessage;
            if (_cursor.isNull(_cursorIndexOfMessage)) {
              _tmpMessage = null;
            } else {
              _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUhid;
            if (_cursor.isNull(_cursorIndexOfUhid)) {
              _tmpUhid = null;
            } else {
              _tmpUhid = _cursor.getString(_cursorIndexOfUhid);
            }
            _item = new AlarmDBModel(_tmpKey,_tmpMessage,_tmpCreatedAt,_tmpUhid);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<String>> readAllUhid() {
    final String _sql = "SELECT DISTINCT Uhid FROM alarm_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"alarm_table"}, false, new Callable<List<String>>() {
      @Override
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final String _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getString(0);
            }
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

  @Override
  public LiveData<List<AlarmDBModel>> readAllAlarmsUhid(final String uhid1) {
    final String _sql = "SELECT * FROM alarm_table WHERE Uhid= ? ORDER BY id DESC LIMIT 12";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uhid1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uhid1);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"alarm_table"}, false, new Callable<List<AlarmDBModel>>() {
      @Override
      public List<AlarmDBModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfKey = CursorUtil.getColumnIndexOrThrow(_cursor, "key");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUhid = CursorUtil.getColumnIndexOrThrow(_cursor, "Uhid");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final List<AlarmDBModel> _result = new ArrayList<AlarmDBModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AlarmDBModel _item;
            final String _tmpKey;
            if (_cursor.isNull(_cursorIndexOfKey)) {
              _tmpKey = null;
            } else {
              _tmpKey = _cursor.getString(_cursorIndexOfKey);
            }
            final String _tmpMessage;
            if (_cursor.isNull(_cursorIndexOfMessage)) {
              _tmpMessage = null;
            } else {
              _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUhid;
            if (_cursor.isNull(_cursorIndexOfUhid)) {
              _tmpUhid = null;
            } else {
              _tmpUhid = _cursor.getString(_cursorIndexOfUhid);
            }
            _item = new AlarmDBModel(_tmpKey,_tmpMessage,_tmpCreatedAt,_tmpUhid);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
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

  @Override
  public Object readAlarmsByUhidNew(final String uhid1, final int id1,
      final Continuation<? super List<AlarmDBModel>> continuation) {
    final String _sql = "SELECT * FROM alarm_table WHERE Uhid= ? AND id > ? LIMIT 12";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uhid1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uhid1);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, id1);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<AlarmDBModel>>() {
      @Override
      public List<AlarmDBModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfKey = CursorUtil.getColumnIndexOrThrow(_cursor, "key");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUhid = CursorUtil.getColumnIndexOrThrow(_cursor, "Uhid");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final List<AlarmDBModel> _result = new ArrayList<AlarmDBModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AlarmDBModel _item;
            final String _tmpKey;
            if (_cursor.isNull(_cursorIndexOfKey)) {
              _tmpKey = null;
            } else {
              _tmpKey = _cursor.getString(_cursorIndexOfKey);
            }
            final String _tmpMessage;
            if (_cursor.isNull(_cursorIndexOfMessage)) {
              _tmpMessage = null;
            } else {
              _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUhid;
            if (_cursor.isNull(_cursorIndexOfUhid)) {
              _tmpUhid = null;
            } else {
              _tmpUhid = _cursor.getString(_cursorIndexOfUhid);
            }
            _item = new AlarmDBModel(_tmpKey,_tmpMessage,_tmpCreatedAt,_tmpUhid);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object readAlarmsByUhidOld(final String uhid1, final int id1,
      final Continuation<? super List<AlarmDBModel>> continuation) {
    final String _sql = "SELECT * FROM (SELECT * FROM alarm_table ORDER BY id DESC) WHERE Uhid= ? AND id < ? LIMIT 12";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uhid1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uhid1);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, id1);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<AlarmDBModel>>() {
      @Override
      public List<AlarmDBModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfKey = CursorUtil.getColumnIndexOrThrow(_cursor, "key");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUhid = CursorUtil.getColumnIndexOrThrow(_cursor, "Uhid");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final List<AlarmDBModel> _result = new ArrayList<AlarmDBModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AlarmDBModel _item;
            final String _tmpKey;
            if (_cursor.isNull(_cursorIndexOfKey)) {
              _tmpKey = null;
            } else {
              _tmpKey = _cursor.getString(_cursorIndexOfKey);
            }
            final String _tmpMessage;
            if (_cursor.isNull(_cursorIndexOfMessage)) {
              _tmpMessage = null;
            } else {
              _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUhid;
            if (_cursor.isNull(_cursorIndexOfUhid)) {
              _tmpUhid = null;
            } else {
              _tmpUhid = _cursor.getString(_cursorIndexOfUhid);
            }
            _item = new AlarmDBModel(_tmpKey,_tmpMessage,_tmpCreatedAt,_tmpUhid);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<AlarmDBModel>> getAllAlarms() {
    final String _sql = "SELECT * FROM alarm_table ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"alarm_table"}, false, new Callable<List<AlarmDBModel>>() {
      @Override
      public List<AlarmDBModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfKey = CursorUtil.getColumnIndexOrThrow(_cursor, "key");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUhid = CursorUtil.getColumnIndexOrThrow(_cursor, "Uhid");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final List<AlarmDBModel> _result = new ArrayList<AlarmDBModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AlarmDBModel _item;
            final String _tmpKey;
            if (_cursor.isNull(_cursorIndexOfKey)) {
              _tmpKey = null;
            } else {
              _tmpKey = _cursor.getString(_cursorIndexOfKey);
            }
            final String _tmpMessage;
            if (_cursor.isNull(_cursorIndexOfMessage)) {
              _tmpMessage = null;
            } else {
              _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUhid;
            if (_cursor.isNull(_cursorIndexOfUhid)) {
              _tmpUhid = null;
            } else {
              _tmpUhid = _cursor.getString(_cursorIndexOfUhid);
            }
            _item = new AlarmDBModel(_tmpKey,_tmpMessage,_tmpCreatedAt,_tmpUhid);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
