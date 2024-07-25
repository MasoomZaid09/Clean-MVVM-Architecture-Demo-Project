package com.agvahealthcare.ventilator_ext.presentation.ui.models;


import com.agvahealthcare.ventilator_ext.data.api.model.alarmDataModel.Ack;
import com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel;
import com.agvahealthcare.ventilator_ext.presentation.utils.AppUtils;
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants;
import com.agvahealthcare.ventilator_ext.utility.utils.AlarmConfiguration;

import java.util.Objects;

public class AlarmModel {

    private String message;

    private String code;
    private String createdAt;
    private String Uhid;


    public AlarmModel(String message, String code, String createdAt,String uhid) {
        this.message = message;
        this.code = code;
        this.createdAt = createdAt;
        this.Uhid = uhid;
    }

    public AlarmModel(AlarmDBModel model){
        this.code = model.getKey();
        this.message = model.getMessage();
        this.createdAt = model.getCreatedAt();
        this.Uhid = model.getUhid();
    }

    public String getUhid() {
        return Uhid;
    }

    public void setUhid(String uhid) {
        Uhid = uhid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Constants.Companion.AlarmType getPriority() { return AlarmConfiguration.getPriority(this.code); }

    public int getColor() { return AlarmConfiguration.getColor(this.code); }

    public AlarmDBModel toDBModel(){
        return new AlarmDBModel(
                getCode(),
                getMessage(),
                getCreatedAt(),
                getUhid()
        );
    }

    public Ack toAckModel(){
        String dateTime = null;
        try{
            dateTime = AppUtils.INSTANCE.getErrorDateTimeFormatter().format(Objects.requireNonNull(AppUtils.INSTANCE.getDateTimeFormatter().parse(this.createdAt)));
        }
        catch(Exception e){
            dateTime = AppUtils.INSTANCE.getCurrentDateReverse();
        }

        return new Ack(
                this.message,
                this.code,
                dateTime,
                getPriority().toString()
        );
    }


}
