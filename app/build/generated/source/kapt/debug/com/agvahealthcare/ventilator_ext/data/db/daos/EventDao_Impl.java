package com.agvahealthcare.ventilator_ext.data.db.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel;
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
public final class EventDao_Impl implements EventDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EventDataModel> __insertionAdapterOfEventDataModel;

  private final EntityDeletionOrUpdateAdapter<EventDataModel> __deletionAdapterOfEventDataModel;

  private final EntityDeletionOrUpdateAdapter<EventDataModel> __updateAdapterOfEventDataModel;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllEvents;

  private final SharedSQLiteStatement __preparedStmtOfDeleteEvents;

  public EventDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEventDataModel = new EntityInsertionAdapter<EventDataModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `event_table` (`Events`,`Uhid`,`Id`,`DatetimeStamp`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EventDataModel value) {
        if (value.getEvent() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getEvent());
        }
        if (value.getUhid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUhid());
        }
        if (value.getId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getId());
        }
        if (value.getTimeStamp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStamp());
        }
      }
    };
    this.__deletionAdapterOfEventDataModel = new EntityDeletionOrUpdateAdapter<EventDataModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `event_table` WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EventDataModel value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfEventDataModel = new EntityDeletionOrUpdateAdapter<EventDataModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `event_table` SET `Events` = ?,`Uhid` = ?,`Id` = ?,`DatetimeStamp` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EventDataModel value) {
        if (value.getEvent() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getEvent());
        }
        if (value.getUhid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUhid());
        }
        if (value.getId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getId());
        }
        if (value.getTimeStamp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStamp());
        }
        if (value.getId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteAllEvents = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM event_table";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteEvents = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM event_table WHERE id < ?";
        return _query;
      }
    };
  }

  @Override
  public Object addEventData(final EventDataModel eventDataModel,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfEventDataModel.insert(eventDataModel);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteEventData(final EventDataModel eventDataModel,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfEventDataModel.handle(eventDataModel);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateEventData(final EventDataModel eventDataModel,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfEventDataModel.handle(eventDataModel);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAllEvents(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllEvents.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllEvents.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteEvents(final int id1, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteEvents.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id1);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteEvents.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<EventDataModel>> readAllEvents() {
    final String _sql = "SELECT * FROM event_table ORDER BY id DESC LIMIT 11";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"event_table"}, false, new Callable<List<EventDataModel>>() {
      @Override
      public List<EventDataModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEvent = CursorUtil.getColumnIndexOrThrow(_cursor, "Events");
          final int _cursorIndexOfUhid = CursorUtil.getColumnIndexOrThrow(_cursor, "Uhid");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final int _cursorIndexOfTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "DatetimeStamp");
          final List<EventDataModel> _result = new ArrayList<EventDataModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EventDataModel _item;
            final String _tmpEvent;
            if (_cursor.isNull(_cursorIndexOfEvent)) {
              _tmpEvent = null;
            } else {
              _tmpEvent = _cursor.getString(_cursorIndexOfEvent);
            }
            final String _tmpUhid;
            if (_cursor.isNull(_cursorIndexOfUhid)) {
              _tmpUhid = null;
            } else {
              _tmpUhid = _cursor.getString(_cursorIndexOfUhid);
            }
            _item = new EventDataModel(_tmpEvent,_tmpUhid);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpTimeStamp;
            if (_cursor.isNull(_cursorIndexOfTimeStamp)) {
              _tmpTimeStamp = null;
            } else {
              _tmpTimeStamp = _cursor.getString(_cursorIndexOfTimeStamp);
            }
            _item.setTimeStamp(_tmpTimeStamp);
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
  public Object readEventsByNew(final int id1,
      final Continuation<? super List<EventDataModel>> continuation) {
    final String _sql = "SELECT * FROM event_table WHERE id > ? LIMIT 11";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id1);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<EventDataModel>>() {
      @Override
      public List<EventDataModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEvent = CursorUtil.getColumnIndexOrThrow(_cursor, "Events");
          final int _cursorIndexOfUhid = CursorUtil.getColumnIndexOrThrow(_cursor, "Uhid");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final int _cursorIndexOfTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "DatetimeStamp");
          final List<EventDataModel> _result = new ArrayList<EventDataModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EventDataModel _item;
            final String _tmpEvent;
            if (_cursor.isNull(_cursorIndexOfEvent)) {
              _tmpEvent = null;
            } else {
              _tmpEvent = _cursor.getString(_cursorIndexOfEvent);
            }
            final String _tmpUhid;
            if (_cursor.isNull(_cursorIndexOfUhid)) {
              _tmpUhid = null;
            } else {
              _tmpUhid = _cursor.getString(_cursorIndexOfUhid);
            }
            _item = new EventDataModel(_tmpEvent,_tmpUhid);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpTimeStamp;
            if (_cursor.isNull(_cursorIndexOfTimeStamp)) {
              _tmpTimeStamp = null;
            } else {
              _tmpTimeStamp = _cursor.getString(_cursorIndexOfTimeStamp);
            }
            _item.setTimeStamp(_tmpTimeStamp);
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
  public Object readEventsByOld(final int id1,
      final Continuation<? super List<EventDataModel>> continuation) {
    final String _sql = "SELECT * FROM (SELECT * FROM event_table ORDER BY id DESC) WHERE id < ? LIMIT 11";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id1);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<EventDataModel>>() {
      @Override
      public List<EventDataModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEvent = CursorUtil.getColumnIndexOrThrow(_cursor, "Events");
          final int _cursorIndexOfUhid = CursorUtil.getColumnIndexOrThrow(_cursor, "Uhid");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final int _cursorIndexOfTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "DatetimeStamp");
          final List<EventDataModel> _result = new ArrayList<EventDataModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EventDataModel _item;
            final String _tmpEvent;
            if (_cursor.isNull(_cursorIndexOfEvent)) {
              _tmpEvent = null;
            } else {
              _tmpEvent = _cursor.getString(_cursorIndexOfEvent);
            }
            final String _tmpUhid;
            if (_cursor.isNull(_cursorIndexOfUhid)) {
              _tmpUhid = null;
            } else {
              _tmpUhid = _cursor.getString(_cursorIndexOfUhid);
            }
            _item = new EventDataModel(_tmpEvent,_tmpUhid);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpTimeStamp;
            if (_cursor.isNull(_cursorIndexOfTimeStamp)) {
              _tmpTimeStamp = null;
            } else {
              _tmpTimeStamp = _cursor.getString(_cursorIndexOfTimeStamp);
            }
            _item.setTimeStamp(_tmpTimeStamp);
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
    final String _sql = "SELECT DISTINCT Uhid FROM event_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"event_table"}, false, new Callable<List<String>>() {
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
  public LiveData<List<EventDataModel>> readAllEventsUhid(final String uhid) {
    final String _sql = "SELECT * FROM event_table WHERE Uhid= ? ORDER BY id DESC LIMIT 11";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uhid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uhid);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"event_table"}, false, new Callable<List<EventDataModel>>() {
      @Override
      public List<EventDataModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEvent = CursorUtil.getColumnIndexOrThrow(_cursor, "Events");
          final int _cursorIndexOfUhid = CursorUtil.getColumnIndexOrThrow(_cursor, "Uhid");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final int _cursorIndexOfTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "DatetimeStamp");
          final List<EventDataModel> _result = new ArrayList<EventDataModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EventDataModel _item;
            final String _tmpEvent;
            if (_cursor.isNull(_cursorIndexOfEvent)) {
              _tmpEvent = null;
            } else {
              _tmpEvent = _cursor.getString(_cursorIndexOfEvent);
            }
            final String _tmpUhid;
            if (_cursor.isNull(_cursorIndexOfUhid)) {
              _tmpUhid = null;
            } else {
              _tmpUhid = _cursor.getString(_cursorIndexOfUhid);
            }
            _item = new EventDataModel(_tmpEvent,_tmpUhid);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpTimeStamp;
            if (_cursor.isNull(_cursorIndexOfTimeStamp)) {
              _tmpTimeStamp = null;
            } else {
              _tmpTimeStamp = _cursor.getString(_cursorIndexOfTimeStamp);
            }
            _item.setTimeStamp(_tmpTimeStamp);
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
  public Object readEventsByUhidNew(final String uhid, final int id1,
      final Continuation<? super List<EventDataModel>> continuation) {
    final String _sql = "SELECT * FROM event_table WHERE Uhid= ? AND id > ? LIMIT 11";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uhid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uhid);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, id1);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<EventDataModel>>() {
      @Override
      public List<EventDataModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEvent = CursorUtil.getColumnIndexOrThrow(_cursor, "Events");
          final int _cursorIndexOfUhid = CursorUtil.getColumnIndexOrThrow(_cursor, "Uhid");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final int _cursorIndexOfTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "DatetimeStamp");
          final List<EventDataModel> _result = new ArrayList<EventDataModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EventDataModel _item;
            final String _tmpEvent;
            if (_cursor.isNull(_cursorIndexOfEvent)) {
              _tmpEvent = null;
            } else {
              _tmpEvent = _cursor.getString(_cursorIndexOfEvent);
            }
            final String _tmpUhid;
            if (_cursor.isNull(_cursorIndexOfUhid)) {
              _tmpUhid = null;
            } else {
              _tmpUhid = _cursor.getString(_cursorIndexOfUhid);
            }
            _item = new EventDataModel(_tmpEvent,_tmpUhid);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpTimeStamp;
            if (_cursor.isNull(_cursorIndexOfTimeStamp)) {
              _tmpTimeStamp = null;
            } else {
              _tmpTimeStamp = _cursor.getString(_cursorIndexOfTimeStamp);
            }
            _item.setTimeStamp(_tmpTimeStamp);
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
  public Object readEventsByUhidOld(final String uhid, final int id1,
      final Continuation<? super List<EventDataModel>> continuation) {
    final String _sql = "SELECT * FROM (SELECT * FROM event_table ORDER BY id DESC) WHERE Uhid= ? AND id < ? LIMIT 11";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uhid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uhid);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, id1);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<EventDataModel>>() {
      @Override
      public List<EventDataModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEvent = CursorUtil.getColumnIndexOrThrow(_cursor, "Events");
          final int _cursorIndexOfUhid = CursorUtil.getColumnIndexOrThrow(_cursor, "Uhid");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final int _cursorIndexOfTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "DatetimeStamp");
          final List<EventDataModel> _result = new ArrayList<EventDataModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EventDataModel _item;
            final String _tmpEvent;
            if (_cursor.isNull(_cursorIndexOfEvent)) {
              _tmpEvent = null;
            } else {
              _tmpEvent = _cursor.getString(_cursorIndexOfEvent);
            }
            final String _tmpUhid;
            if (_cursor.isNull(_cursorIndexOfUhid)) {
              _tmpUhid = null;
            } else {
              _tmpUhid = _cursor.getString(_cursorIndexOfUhid);
            }
            _item = new EventDataModel(_tmpEvent,_tmpUhid);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpTimeStamp;
            if (_cursor.isNull(_cursorIndexOfTimeStamp)) {
              _tmpTimeStamp = null;
            } else {
              _tmpTimeStamp = _cursor.getString(_cursorIndexOfTimeStamp);
            }
            _item.setTimeStamp(_tmpTimeStamp);
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
  public LiveData<List<EventDataModel>> getAllEvents() {
    final String _sql = "SELECT * FROM event_table ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"event_table"}, false, new Callable<List<EventDataModel>>() {
      @Override
      public List<EventDataModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEvent = CursorUtil.getColumnIndexOrThrow(_cursor, "Events");
          final int _cursorIndexOfUhid = CursorUtil.getColumnIndexOrThrow(_cursor, "Uhid");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final int _cursorIndexOfTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "DatetimeStamp");
          final List<EventDataModel> _result = new ArrayList<EventDataModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EventDataModel _item;
            final String _tmpEvent;
            if (_cursor.isNull(_cursorIndexOfEvent)) {
              _tmpEvent = null;
            } else {
              _tmpEvent = _cursor.getString(_cursorIndexOfEvent);
            }
            final String _tmpUhid;
            if (_cursor.isNull(_cursorIndexOfUhid)) {
              _tmpUhid = null;
            } else {
              _tmpUhid = _cursor.getString(_cursorIndexOfUhid);
            }
            _item = new EventDataModel(_tmpEvent,_tmpUhid);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpTimeStamp;
            if (_cursor.isNull(_cursorIndexOfTimeStamp)) {
              _tmpTimeStamp = null;
            } else {
              _tmpTimeStamp = _cursor.getString(_cursorIndexOfTimeStamp);
            }
            _item.setTimeStamp(_tmpTimeStamp);
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
