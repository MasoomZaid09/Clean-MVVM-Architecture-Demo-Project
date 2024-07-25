package com.agvahealthcare.ventilator_ext.data.db.daos;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.agvahealthcare.ventilator_ext.database.entities.ServiceDataModel;
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
public final class ServiceDao_Impl implements ServiceDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ServiceDataModel> __insertionAdapterOfServiceDataModel;

  public ServiceDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfServiceDataModel = new EntityInsertionAdapter<ServiceDataModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `service_table` (`desc`,`name`,`department`,`ward_no`,`hospital_name`,`email_id`,`contactNo`,`date`,`Id`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ServiceDataModel value) {
        if (value.getDesc() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getDesc());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getDeparment() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDeparment());
        }
        if (value.getWard_no() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getWard_no());
        }
        if (value.getHospital_name() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getHospital_name());
        }
        if (value.getEmail_id() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getEmail_id());
        }
        if (value.getContactNo() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getContactNo());
        }
        if (value.getDate() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDate());
        }
        if (value.getId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getId());
        }
      }
    };
  }

  @Override
  public Object addService(final ServiceDataModel serviceDataModel,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfServiceDataModel.insert(serviceDataModel);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<ServiceDataModel>> readAllServices() {
    final String _sql = "SELECT * FROM service_table ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"service_table"}, false, new Callable<List<ServiceDataModel>>() {
      @Override
      public List<ServiceDataModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "desc");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDeparment = CursorUtil.getColumnIndexOrThrow(_cursor, "department");
          final int _cursorIndexOfWardNo = CursorUtil.getColumnIndexOrThrow(_cursor, "ward_no");
          final int _cursorIndexOfHospitalName = CursorUtil.getColumnIndexOrThrow(_cursor, "hospital_name");
          final int _cursorIndexOfEmailId = CursorUtil.getColumnIndexOrThrow(_cursor, "email_id");
          final int _cursorIndexOfContactNo = CursorUtil.getColumnIndexOrThrow(_cursor, "contactNo");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final List<ServiceDataModel> _result = new ArrayList<ServiceDataModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ServiceDataModel _item;
            final String _tmpDesc;
            if (_cursor.isNull(_cursorIndexOfDesc)) {
              _tmpDesc = null;
            } else {
              _tmpDesc = _cursor.getString(_cursorIndexOfDesc);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDeparment;
            if (_cursor.isNull(_cursorIndexOfDeparment)) {
              _tmpDeparment = null;
            } else {
              _tmpDeparment = _cursor.getString(_cursorIndexOfDeparment);
            }
            final String _tmpWard_no;
            if (_cursor.isNull(_cursorIndexOfWardNo)) {
              _tmpWard_no = null;
            } else {
              _tmpWard_no = _cursor.getString(_cursorIndexOfWardNo);
            }
            final String _tmpHospital_name;
            if (_cursor.isNull(_cursorIndexOfHospitalName)) {
              _tmpHospital_name = null;
            } else {
              _tmpHospital_name = _cursor.getString(_cursorIndexOfHospitalName);
            }
            final String _tmpEmail_id;
            if (_cursor.isNull(_cursorIndexOfEmailId)) {
              _tmpEmail_id = null;
            } else {
              _tmpEmail_id = _cursor.getString(_cursorIndexOfEmailId);
            }
            final String _tmpContactNo;
            if (_cursor.isNull(_cursorIndexOfContactNo)) {
              _tmpContactNo = null;
            } else {
              _tmpContactNo = _cursor.getString(_cursorIndexOfContactNo);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            _item = new ServiceDataModel(_tmpDesc,_tmpName,_tmpDeparment,_tmpWard_no,_tmpHospital_name,_tmpEmail_id,_tmpContactNo,_tmpDate);
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
