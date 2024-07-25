package com.agvahealthcare.ventilator_ext.presentation.ui.activities;

import java.lang.System;

/**
 * Created by MASOOM ZAID on 20-04-2023.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u00a2\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b)\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002\u00d8\u0001B\u0005\u00a2\u0006\u0002\u0010\u0007J%\u0010\u0085\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u0087\u0001\u001a\u00020\u000b2\u0007\u0010\u0088\u0001\u001a\u00020\u000b2\u0007\u0010\u0089\u0001\u001a\u00020\u000bH\u0002J\u001c\u0010\u008a\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u008b\u0001\u001a\u00020\u000b2\u0007\u0010\u0089\u0001\u001a\u00020\u000bH\u0002J\n\u0010\u008c\u0001\u001a\u00030\u0086\u0001H\u0002J\n\u0010\u008d\u0001\u001a\u00030\u0086\u0001H\u0002J\n\u0010\u008e\u0001\u001a\u00030\u0086\u0001H\u0002J\u0013\u0010\u008f\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u0090\u0001\u001a\u00020\u000bH\u0003J\n\u0010\u0091\u0001\u001a\u00030\u0086\u0001H\u0002J\n\u0010\u0092\u0001\u001a\u00030\u0086\u0001H\u0002J\u001c\u0010\u0093\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u0094\u0001\u001a\u00020G2\u0007\u0010\u0095\u0001\u001a\u00020GH\u0002J\n\u0010\u0096\u0001\u001a\u00030\u0086\u0001H\u0002J\n\u0010\u0097\u0001\u001a\u00030\u0086\u0001H\u0002J\n\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0002J0\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u00012\u0013\u0010\u009c\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0_2\u0007\u0010\u009d\u0001\u001a\u00020\u000bH\u0002\u00a2\u0006\u0003\u0010\u009e\u0001J/\u0010\u009f\u0001\u001a\u0004\u0018\u00010/2\u0013\u0010\u009c\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0_2\u0007\u0010\u009d\u0001\u001a\u00020\u000bH\u0002\u00a2\u0006\u0003\u0010\u00a0\u0001J\u001b\u0010\u00a1\u0001\u001a\u00030\u0086\u00012\t\u0010\u00a2\u0001\u001a\u0004\u0018\u00010/H\u0002\u00a2\u0006\u0003\u0010\u00a3\u0001J\u0013\u0010\u00a4\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u00a5\u0001\u001a\u00020\u000bH\u0002J+\u0010\u00a6\u0001\u001a\u00030\u0086\u00012\n\u0010\u00a7\u0001\u001a\u0005\u0018\u00010\u00a8\u00012\t\u0010\u00a9\u0001\u001a\u0004\u0018\u00010i2\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J \u0010\u00aa\u0001\u001a\u00030\u0086\u00012\t\u0010\u00a7\u0001\u001a\u0004\u0018\u00010k2\t\u0010\u00a9\u0001\u001a\u0004\u0018\u00010iH\u0002J\n\u0010\u00ab\u0001\u001a\u00030\u0086\u0001H\u0002J\n\u0010\u00ac\u0001\u001a\u00030\u0086\u0001H\u0002J\u0015\u0010\u00ad\u0001\u001a\u00030\u0086\u00012\t\u0010\u00a7\u0001\u001a\u0004\u0018\u00010kH\u0016J\u0016\u0010\u00ae\u0001\u001a\u00030\u0086\u00012\n\u0010\u00af\u0001\u001a\u0005\u0018\u00010\u00b0\u0001H\u0014J\n\u0010\u00b1\u0001\u001a\u00030\u0086\u0001H\u0002J\n\u0010\u00b2\u0001\u001a\u00030\u0086\u0001H\u0002J\n\u0010\u00b3\u0001\u001a\u00030\u0086\u0001H\u0016J\n\u0010\u00b4\u0001\u001a\u00030\u0086\u0001H\u0014J\n\u0010\u00b5\u0001\u001a\u00030\u0086\u0001H\u0002J\n\u0010\u00b6\u0001\u001a\u00030\u0086\u0001H\u0014J\n\u0010\u00b7\u0001\u001a\u00030\u0086\u0001H\u0016J\u0013\u0010\u00b8\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u00a2\u0001\u001a\u00020/H\u0016J\n\u0010\u00b9\u0001\u001a\u00030\u0086\u0001H\u0016J\n\u0010\u00ba\u0001\u001a\u00030\u0086\u0001H\u0002J\u0013\u0010\u00bb\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u00a5\u0001\u001a\u00020\u000bH\u0002J\b\u0010\u00bc\u0001\u001a\u00030\u0086\u0001J\u0013\u0010\u00bd\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u00a2\u0001\u001a\u00020/H\u0002J\n\u0010\u00be\u0001\u001a\u00030\u0086\u0001H\u0002J-\u0010\u00bf\u0001\u001a\u00030\u0086\u00012!\u0010\u00c0\u0001\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0_\u0018\u00010_H\u0002J\n\u0010\u00c1\u0001\u001a\u00030\u0086\u0001H\u0002J\u001b\u0010\u00c2\u0001\u001a\u00030\u0086\u00012\t\u0010\u00c3\u0001\u001a\u0004\u0018\u00010GH\u0002\u00a2\u0006\u0003\u0010\u00c4\u0001J\u0013\u0010\u00c5\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u00c3\u0001\u001a\u00020GH\u0002J\n\u0010\u00c6\u0001\u001a\u00030\u0086\u0001H\u0002J\n\u0010\u00c7\u0001\u001a\u00030\u0086\u0001H\u0002J\u0013\u0010\u00c8\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u00a2\u0001\u001a\u00020/H\u0002J\n\u0010\u00c9\u0001\u001a\u00030\u0086\u0001H\u0002J\n\u0010\u00ca\u0001\u001a\u00030\u0086\u0001H\u0002J\n\u0010\u00cb\u0001\u001a\u00030\u0086\u0001H\u0002J\b\u0010\u00cc\u0001\u001a\u00030\u0086\u0001J\n\u0010\u00cd\u0001\u001a\u00030\u0086\u0001H\u0002J\n\u0010\u00ce\u0001\u001a\u00030\u0086\u0001H\u0002J\u0014\u0010\u0083\u0001\u001a\u00030\u0086\u00012\b\u0010\u00cf\u0001\u001a\u00030\u0082\u0001H\u0002J\u0013\u0010\u00d0\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u00d1\u0001\u001a\u00020/H\u0002J(\u0010\u00d2\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u00d3\u0001\u001a\u00020\u000b2\u0013\u0010\u009c\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0_H\u0002J\n\u0010\u00d4\u0001\u001a\u00030\u0086\u0001H\u0002J\u001c\u0010\u00d5\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u00d6\u0001\u001a\u00020\u000b2\u0007\u0010\u00d7\u0001\u001a\u00020/H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\'\u0010\u001b\u001a\u0004\b%\u0010&R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020/X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020/X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00101\"\u0004\b8\u00103R\u000e\u00109\u001a\u00020:X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020/X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010\u001b\u001a\u0004\b>\u0010?R\u000e\u0010A\u001a\u00020/X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000b0EX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010H\u001a\u00020GX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u000e\u0010L\u001a\u00020GX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010M\u001a\u00020GX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010I\"\u0004\bN\u0010KR\u000e\u0010O\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010SX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010WX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010X\u001a\u000205X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u000e\u0010]\u001a\u00020/X\u0082\u000e\u00a2\u0006\u0002\n\u0000R(\u0010^\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0_\u0018\u00010_X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u0004\u0018\u00010cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010d\u001a\u0004\u0018\u00010eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010f\u001a\u0004\u0018\u00010gX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u0004\u0018\u00010iX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u00010kX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010l\u001a\u0004\u0018\u00010mX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010n\u001a\b\u0018\u00010oR\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010p\u001a\u00020/X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bq\u00101\"\u0004\br\u00103R\u001a\u0010s\u001a\u00020/X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bt\u00101\"\u0004\bu\u00103R\u001a\u0010v\u001a\u00020/X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u00101\"\u0004\bx\u00103R\u001a\u0010y\u001a\u00020/X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bz\u00101\"\u0004\b{\u00103R\u0016\u0010|\u001a\b\u0012\u0004\u0012\u00020/0}X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010~R\u000e\u0010\u007f\u001a\u00020/X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0081\u0001\u001a\u00030\u0082\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0083\u0001\u001a\u0004\u0018\u000105X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020GX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00d9\u0001"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/ui/activities/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnStandbyCLickListener;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnTherapyEndListener;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/DialogCloseListener;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnStartSedationListener;", "()V", "ackVisibilities", "", "alarmBarColor", "", "getAlarmBarColor", "()Ljava/lang/String;", "setAlarmBarColor", "(Ljava/lang/String;)V", "alarmStringBuffer", "getAlarmStringBuffer", "setAlarmStringBuffer", "alarmTextColor", "getAlarmTextColor", "setAlarmTextColor", "alarmVIewModel", "Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/AlarmViewModel;", "getAlarmVIewModel", "()Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/AlarmViewModel;", "alarmVIewModel$delegate", "Lkotlin/Lazy;", "alarmsMap", "", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/models/AlarmModel;", "binding", "Lcom/agvahealthcare/ventilator_ext/databinding/ActivityMainBinding;", "commonFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/CommonFragment;", "commonViewModel", "Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/CommonViewModel;", "getCommonViewModel", "()Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/CommonViewModel;", "commonViewModel$delegate", "communicationService", "Lcom/agvahealthcare/ventilator_ext/domain/support/service/CommunicationService;", "connReceiver", "Landroid/content/BroadcastReceiver;", "controlFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/ControlFragment;", "count", "", "getCount", "()I", "setCount", "(I)V", "countDownTimer", "Landroid/os/CountDownTimer;", "currentMode", "getCurrentMode$app_debug", "setCurrentMode$app_debug", "currentPriority", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$AlarmType;", "currentSoundIndex", "eventViewModel", "Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/EventViewModel;", "getEventViewModel", "()Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/EventViewModel;", "eventViewModel$delegate", "fCount", "infoAdapter", "Lcom/agvahealthcare/ventilator_ext/presentation/adapters/InfoAdapter;", "infoList", "Ljava/util/ArrayList;", "isAlarmMuted", "", "isAlarmPlaying", "()Z", "setAlarmPlaying", "(Z)V", "isReadingFromConnection", "isServiceBound", "setServiceBound", "lastUhidAlarms", "mServiceConnection", "Landroid/content/ServiceConnection;", "mediaPlayer", "Landroid/media/MediaPlayer;", "menuFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/MenuFragment;", "modeFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/ModeFragment;", "muteUnMuteTimer", "getMuteUnMuteTimer", "()Landroid/os/CountDownTimer;", "setMuteUnMuteTimer", "(Landroid/os/CountDownTimer;)V", "pCount", "parseMap", "", "pingingTask", "Lcom/agvahealthcare/ventilator_ext/domain/support/PingingTask;", "preferenceManager", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/PreferenceManager;", "raspiParser", "Lcom/agvahealthcare/ventilator_ext/connection/parser/RaspiParser;", "selectedMenuType", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$AllMenuType;", "selectedTextView", "Landroid/widget/TextView;", "selectedView", "Landroid/view/View;", "serviceIntent", "Landroid/content/Intent;", "settingsCountDownTimer", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/activities/MainActivity$SettingsCountDownTimer;", "sizeOfCritical", "getSizeOfCritical", "setSizeOfCritical", "sizeOfHigh", "getSizeOfHigh", "setSizeOfHigh", "sizeOfLow", "getSizeOfLow", "setSizeOfLow", "sizeOfMedium", "getSizeOfMedium", "setSizeOfMedium", "soundResources", "", "[Ljava/lang/Integer;", "testCount", "text", "therapyEndTime", "", "therapyEndTimer", "zeroN2o", "addAlarm", "", "alarmKey", "alarmMsg", "uhid", "addEvents", "eventMsg", "alarmMute", "alarmMuteUnMuteVisibility", "alarmUnMute", "callRunningStatusApi", "status", "changeMediaInMediaPlayer", "closeAllFragment", "disableAllMenuButtons", "isO2Flush", "isDisable", "doBindService", "doUnbindService", "getIntentFilter", "Landroid/content/IntentFilter;", "getMapValueFromLabelIntoFloat", "", "map", "lbl", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Float;", "getMapValueFromLabelIntoInteger", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Integer;", "getModeName", "mode", "(Ljava/lang/Integer;)V", "handleAcknowledgements", "ackValue", "highLightTile", "view", "Landroidx/constraintlayout/widget/ConstraintLayout;", "textView", "normaliseTile", "o2FlushTimer", "observeAlarmsAndEventData", "onClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDeviceConnect", "onDeviceDisconnect", "onHandleDialogClose", "onPause", "onPlayAlarm", "onResume", "onStandby", "onStartSedation", "onTherapyEnd", "openAlertDialog", "removeAlarm", "sendConfigurationToVentilatorWithWatchDog", "sendControlModeToVentilator", "sendStandbyCommandToVentilator", "setDataOnScreen", "dataMap", "setOnClickListeners", "setupAlertDialogForOxygen", "isO2Failure", "(Ljava/lang/Boolean;)V", "setupInfoAdapter", "setupView", "showCommonFragment", "showControlFragment", "showMenuFragment", "showModeFragment", "startPinging", "stopO2Flush", "stopPinging", "stopTherapyEnd", "time", "updateBatteryImage", "batteryLevel", "updateData", "label", "validateErrorBar", "validateRangeLimits", "key", "value", "SettingsCountDownTimer", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener, com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnStandbyCLickListener, com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnTherapyEndListener, com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener, com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnStartSedationListener {
    public android.os.CountDownTimer muteUnMuteTimer;
    private boolean isAlarmPlaying = false;
    @org.jetbrains.annotations.NotNull
    private java.lang.String alarmBarColor = "";
    @org.jetbrains.annotations.NotNull
    private java.lang.String alarmTextColor = "";
    @org.jetbrains.annotations.NotNull
    private java.lang.String alarmStringBuffer = "";
    private int sizeOfLow = 0;
    private int sizeOfMedium = 0;
    private int sizeOfHigh = 0;
    private int sizeOfCritical = 0;
    private com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AlarmType currentPriority;
    private long therapyEndTime = 0L;
    private com.agvahealthcare.ventilator_ext.presentation.ui.activities.MainActivity.SettingsCountDownTimer settingsCountDownTimer;
    private java.lang.String lastUhidAlarms = "";
    private com.agvahealthcare.ventilator_ext.databinding.ActivityMainBinding binding;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.CommonFragment commonFragment;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.ModeFragment modeFragment;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.MenuFragment menuFragment;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.ControlFragment controlFragment;
    private int currentMode = 0;
    private com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AllMenuType selectedMenuType;
    private android.view.View selectedView;
    private android.widget.TextView selectedTextView;
    private android.os.CountDownTimer countDownTimer;
    private boolean zeroN2o = false;
    private android.os.CountDownTimer therapyEndTimer;
    private java.lang.String text = "";
    private java.util.ArrayList<java.lang.String> infoList;
    private com.agvahealthcare.ventilator_ext.presentation.adapters.InfoAdapter infoAdapter;
    private com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager preferenceManager;
    private java.util.Map<java.lang.String, ? extends java.util.Map<java.lang.String, java.lang.String>> parseMap;
    private java.util.Map<java.lang.String, com.agvahealthcare.ventilator_ext.presentation.ui.models.AlarmModel> alarmsMap;
    private boolean[] ackVisibilities;
    private com.agvahealthcare.ventilator_ext.connection.parser.RaspiParser raspiParser;
    private int testCount = 100;
    private int pCount = 0;
    private int fCount = 0;
    private android.media.MediaPlayer mediaPlayer;
    private boolean isAlarmMuted = false;
    private android.content.Intent serviceIntent;
    private com.agvahealthcare.ventilator_ext.domain.support.service.CommunicationService communicationService;
    private com.agvahealthcare.ventilator_ext.domain.support.PingingTask pingingTask;
    private final kotlin.Lazy commonViewModel$delegate = null;
    private final kotlin.Lazy alarmVIewModel$delegate = null;
    private final kotlin.Lazy eventViewModel$delegate = null;
    private boolean isServiceBound = false;
    private boolean isReadingFromConnection = false;
    private final android.content.ServiceConnection mServiceConnection = null;
    private int count = 0;
    private final android.content.BroadcastReceiver connReceiver = null;
    private int currentSoundIndex = 0;
    private final java.lang.Integer[] soundResources = {com.agvahealthcare.ventilator_ext.R.raw.warning_low_level, com.agvahealthcare.ventilator_ext.R.raw.warning_high_level};
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.os.CountDownTimer getMuteUnMuteTimer() {
        return null;
    }
    
    public final void setMuteUnMuteTimer(@org.jetbrains.annotations.NotNull
    android.os.CountDownTimer p0) {
    }
    
    public final boolean isAlarmPlaying() {
        return false;
    }
    
    public final void setAlarmPlaying(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAlarmBarColor() {
        return null;
    }
    
    public final void setAlarmBarColor(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAlarmTextColor() {
        return null;
    }
    
    public final void setAlarmTextColor(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAlarmStringBuffer() {
        return null;
    }
    
    public final void setAlarmStringBuffer(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int getSizeOfLow() {
        return 0;
    }
    
    public final void setSizeOfLow(int p0) {
    }
    
    public final int getSizeOfMedium() {
        return 0;
    }
    
    public final void setSizeOfMedium(int p0) {
    }
    
    public final int getSizeOfHigh() {
        return 0;
    }
    
    public final void setSizeOfHigh(int p0) {
    }
    
    public final int getSizeOfCritical() {
        return 0;
    }
    
    public final void setSizeOfCritical(int p0) {
    }
    
    public final int getCurrentMode$app_debug() {
        return 0;
    }
    
    public final void setCurrentMode$app_debug(int p0) {
    }
    
    private final com.agvahealthcare.ventilator_ext.presentation.viewmodels.CommonViewModel getCommonViewModel() {
        return null;
    }
    
    private final com.agvahealthcare.ventilator_ext.presentation.viewmodels.AlarmViewModel getAlarmVIewModel() {
        return null;
    }
    
    private final com.agvahealthcare.ventilator_ext.presentation.viewmodels.EventViewModel getEventViewModel() {
        return null;
    }
    
    public final boolean isServiceBound() {
        return false;
    }
    
    public final void setServiceBound(boolean p0) {
    }
    
    private final void onDeviceConnect() {
    }
    
    private final void doBindService() {
    }
    
    private final void doUnbindService() {
    }
    
    @java.lang.Override
    public void onHandleDialogClose() {
    }
    
    private final void showCommonFragment() {
    }
    
    private final void showMenuFragment() {
    }
    
    private final void showControlFragment(int mode) {
    }
    
    private final void sendControlModeToVentilator(int mode) {
    }
    
    @java.lang.Override
    public void onStartSedation(int mode) {
    }
    
    private final void showModeFragment() {
    }
    
    @java.lang.Override
    protected void onPause() {
    }
    
    @android.annotation.SuppressLint(value = {"HardwareIds"})
    private final void callRunningStatusApi(java.lang.String status) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void updateBatteryImage(int batteryLevel) {
    }
    
    private final void validateErrorBar() {
    }
    
    private final void setupView() {
    }
    
    private final void setupAlertDialogForOxygen(java.lang.Boolean isO2Failure) {
    }
    
    private final void setupInfoAdapter(boolean isO2Failure) {
    }
    
    private final android.content.IntentFilter getIntentFilter() {
        return null;
    }
    
    public final int getCount() {
        return 0;
    }
    
    public final void setCount(int p0) {
    }
    
    private final void addAlarm(java.lang.String alarmKey, java.lang.String alarmMsg, java.lang.String uhid) {
    }
    
    private final void addEvents(java.lang.String eventMsg, java.lang.String uhid) {
    }
    
    private final void removeAlarm(java.lang.String ackValue) {
    }
    
    private final void handleAcknowledgements(java.lang.String ackValue) {
    }
    
    private final void observeAlarmsAndEventData() {
    }
    
    public final void sendConfigurationToVentilatorWithWatchDog() {
    }
    
    private final void onDeviceDisconnect() {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void startPinging() {
    }
    
    private final void stopPinging() {
    }
    
    private final void setDataOnScreen(java.util.Map<java.lang.String, ? extends java.util.Map<java.lang.String, java.lang.String>> dataMap) {
    }
    
    private final void validateRangeLimits(java.lang.String key, int value) {
    }
    
    private final java.lang.Float getMapValueFromLabelIntoFloat(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String lbl) {
        return null;
    }
    
    private final java.lang.Integer getMapValueFromLabelIntoInteger(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String lbl) {
        return null;
    }
    
    private final void updateData(java.lang.String label, java.util.Map<java.lang.String, java.lang.String> map) {
    }
    
    private final void setOnClickListeners() {
    }
    
    private final void normaliseTile(android.view.View view, android.widget.TextView textView) {
    }
    
    private final void highLightTile(androidx.constraintlayout.widget.ConstraintLayout view, android.widget.TextView textView, com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AllMenuType selectedMenuType) {
    }
    
    @java.lang.Override
    public void onStandby() {
    }
    
    private final void sendStandbyCommandToVentilator() {
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.Nullable
    android.view.View view) {
    }
    
    private final void getModeName(java.lang.Integer mode) {
    }
    
    private final void closeAllFragment() {
    }
    
    public final void stopO2Flush() {
    }
    
    private final void stopTherapyEnd() {
    }
    
    private final void o2FlushTimer() {
    }
    
    private final void therapyEndTimer(long time) {
    }
    
    private final void disableAllMenuButtons(boolean isO2Flush, boolean isDisable) {
    }
    
    private final void openAlertDialog() {
    }
    
    @java.lang.Override
    public void onTherapyEnd() {
    }
    
    private final void changeMediaInMediaPlayer() {
    }
    
    private final void alarmMuteUnMuteVisibility() {
    }
    
    private final void alarmMute() {
    }
    
    private final void alarmUnMute() {
    }
    
    private final void onPlayAlarm() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0096\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/ui/activities/MainActivity$SettingsCountDownTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Lcom/agvahealthcare/ventilator_ext/presentation/ui/activities/MainActivity;JJ)V", "isFirstCallElapsed", "", "isRunning", "isSafeStop", "onFinish", "", "onTick", "millis", "safeStop", "startRunning", "app_debug"})
    public class SettingsCountDownTimer extends android.os.CountDownTimer {
        private boolean isSafeStop = false;
        private boolean isRunning = false;
        private boolean isFirstCallElapsed = false;
        
        public SettingsCountDownTimer(long millisInFuture, long countDownInterval) {
            super(0L, 0L);
        }
        
        public final void startRunning() {
        }
        
        public final void safeStop() {
        }
        
        @java.lang.Override
        public void onTick(long millis) {
        }
        
        @java.lang.Override
        public void onFinish() {
        }
    }
}