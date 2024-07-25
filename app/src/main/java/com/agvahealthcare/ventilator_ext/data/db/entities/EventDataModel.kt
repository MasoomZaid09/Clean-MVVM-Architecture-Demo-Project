package com.agvahealthcare.ventilator_ext.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.agvahealthcare.ventilator_ext.data.db.DateConverter
import com.agvahealthcare.ventilator_ext.presentation.utils.AppUtils

@Entity(tableName = "event_table") // User Entity represents a table within the database.
data class EventDataModel(
    @ColumnInfo(name = "Events")
    var event: String,
    @ColumnInfo(name = "Uhid") var uhid:String

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var id: Int? = null

    @TypeConverters(DateConverter::class)
    @ColumnInfo(name = "DatetimeStamp")
    var timeStamp: String = AppUtils.getCurrentDateTime()!!
}

