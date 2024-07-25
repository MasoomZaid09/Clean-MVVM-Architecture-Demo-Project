package com.agvahealthcare.ventilator_ext.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.agvahealthcare.ventilator_ext.data.db.daos.AlarmDao;
import com.agvahealthcare.ventilator_ext.data.db.daos.AlarmDao_Impl;
import com.agvahealthcare.ventilator_ext.data.db.daos.EventDao;
import com.agvahealthcare.ventilator_ext.data.db.daos.EventDao_Impl;
import com.agvahealthcare.ventilator_ext.data.db.daos.ServiceDao;
import com.agvahealthcare.ventilator_ext.data.db.daos.ServiceDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AgVaDatabase_Impl extends AgVaDatabase {
  private volatile EventDao _eventDao;

  private volatile AlarmDao _alarmDao;

  private volatile ServiceDao _serviceDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `event_table` (`Events` TEXT NOT NULL, `Uhid` TEXT NOT NULL, `Id` INTEGER PRIMARY KEY AUTOINCREMENT, `DatetimeStamp` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `alarm_table` (`key` TEXT NOT NULL, `message` TEXT NOT NULL, `createdAt` TEXT NOT NULL, `Uhid` TEXT NOT NULL, `Id` INTEGER PRIMARY KEY AUTOINCREMENT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `service_table` (`desc` TEXT NOT NULL, `name` TEXT NOT NULL, `department` TEXT NOT NULL, `ward_no` TEXT NOT NULL, `hospital_name` TEXT NOT NULL, `email_id` TEXT NOT NULL, `contactNo` TEXT NOT NULL, `date` TEXT NOT NULL, `Id` INTEGER PRIMARY KEY AUTOINCREMENT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'e04e6318e0ce04813e6860b7b35cda7c')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `event_table`");
        _db.execSQL("DROP TABLE IF EXISTS `alarm_table`");
        _db.execSQL("DROP TABLE IF EXISTS `service_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsEventTable = new HashMap<String, TableInfo.Column>(4);
        _columnsEventTable.put("Events", new TableInfo.Column("Events", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEventTable.put("Uhid", new TableInfo.Column("Uhid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEventTable.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEventTable.put("DatetimeStamp", new TableInfo.Column("DatetimeStamp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEventTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEventTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEventTable = new TableInfo("event_table", _columnsEventTable, _foreignKeysEventTable, _indicesEventTable);
        final TableInfo _existingEventTable = TableInfo.read(_db, "event_table");
        if (! _infoEventTable.equals(_existingEventTable)) {
          return new RoomOpenHelper.ValidationResult(false, "event_table(com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel).\n"
                  + " Expected:\n" + _infoEventTable + "\n"
                  + " Found:\n" + _existingEventTable);
        }
        final HashMap<String, TableInfo.Column> _columnsAlarmTable = new HashMap<String, TableInfo.Column>(5);
        _columnsAlarmTable.put("key", new TableInfo.Column("key", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmTable.put("message", new TableInfo.Column("message", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmTable.put("createdAt", new TableInfo.Column("createdAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmTable.put("Uhid", new TableInfo.Column("Uhid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmTable.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAlarmTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAlarmTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAlarmTable = new TableInfo("alarm_table", _columnsAlarmTable, _foreignKeysAlarmTable, _indicesAlarmTable);
        final TableInfo _existingAlarmTable = TableInfo.read(_db, "alarm_table");
        if (! _infoAlarmTable.equals(_existingAlarmTable)) {
          return new RoomOpenHelper.ValidationResult(false, "alarm_table(com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel).\n"
                  + " Expected:\n" + _infoAlarmTable + "\n"
                  + " Found:\n" + _existingAlarmTable);
        }
        final HashMap<String, TableInfo.Column> _columnsServiceTable = new HashMap<String, TableInfo.Column>(9);
        _columnsServiceTable.put("desc", new TableInfo.Column("desc", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsServiceTable.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsServiceTable.put("department", new TableInfo.Column("department", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsServiceTable.put("ward_no", new TableInfo.Column("ward_no", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsServiceTable.put("hospital_name", new TableInfo.Column("hospital_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsServiceTable.put("email_id", new TableInfo.Column("email_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsServiceTable.put("contactNo", new TableInfo.Column("contactNo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsServiceTable.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsServiceTable.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysServiceTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesServiceTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoServiceTable = new TableInfo("service_table", _columnsServiceTable, _foreignKeysServiceTable, _indicesServiceTable);
        final TableInfo _existingServiceTable = TableInfo.read(_db, "service_table");
        if (! _infoServiceTable.equals(_existingServiceTable)) {
          return new RoomOpenHelper.ValidationResult(false, "service_table(com.agvahealthcare.ventilator_ext.database.entities.ServiceDataModel).\n"
                  + " Expected:\n" + _infoServiceTable + "\n"
                  + " Found:\n" + _existingServiceTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "e04e6318e0ce04813e6860b7b35cda7c", "99bcb88926cfad99f9d4f61c98e6dff7");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "event_table","alarm_table","service_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `event_table`");
      _db.execSQL("DELETE FROM `alarm_table`");
      _db.execSQL("DELETE FROM `service_table`");
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
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(EventDao.class, EventDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AlarmDao.class, AlarmDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ServiceDao.class, ServiceDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public EventDao eventDao() {
    if (_eventDao != null) {
      return _eventDao;
    } else {
      synchronized(this) {
        if(_eventDao == null) {
          _eventDao = new EventDao_Impl(this);
        }
        return _eventDao;
      }
    }
  }

  @Override
  public AlarmDao alarmDao() {
    if (_alarmDao != null) {
      return _alarmDao;
    } else {
      synchronized(this) {
        if(_alarmDao == null) {
          _alarmDao = new AlarmDao_Impl(this);
        }
        return _alarmDao;
      }
    }
  }

  @Override
  public ServiceDao serviceDao() {
    if (_serviceDao != null) {
      return _serviceDao;
    } else {
      synchronized(this) {
        if(_serviceDao == null) {
          _serviceDao = new ServiceDao_Impl(this);
        }
        return _serviceDao;
      }
    }
  }
}
