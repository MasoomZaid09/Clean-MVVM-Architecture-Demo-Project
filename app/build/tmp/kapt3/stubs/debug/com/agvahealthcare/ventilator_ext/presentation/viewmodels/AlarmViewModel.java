package com.agvahealthcare.ventilator_ext.presentation.viewmodels;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/AlarmViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "repository", "Lcom/agvahealthcare/ventilator_ext/data/db/repository/AlarmRepository;", "addAlarm", "", "ctx", "Landroid/content/Context;", "alarmDBModel", "Lcom/agvahealthcare/ventilator_ext/database/entities/AlarmDBModel;", "app_debug"})
public final class AlarmViewModel extends androidx.lifecycle.AndroidViewModel {
    private final com.agvahealthcare.ventilator_ext.data.db.repository.AlarmRepository repository = null;
    
    @javax.inject.Inject
    public AlarmViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    public final void addAlarm(@org.jetbrains.annotations.NotNull
    android.content.Context ctx, @org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel alarmDBModel) {
    }
}