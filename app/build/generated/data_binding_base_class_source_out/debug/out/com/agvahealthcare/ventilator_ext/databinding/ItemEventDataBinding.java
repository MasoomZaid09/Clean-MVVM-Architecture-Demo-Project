// Generated by view binder compiler. Do not edit!
package com.agvahealthcare.ventilator_ext.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.agvahealthcare.ventilator_ext.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemEventDataBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final LinearLayoutCompat layoutid;

  @NonNull
  public final AppCompatTextView textViewDateTime;

  @NonNull
  public final AppCompatTextView textViewEventsData;

  @NonNull
  public final AppCompatTextView textViewTime;

  @NonNull
  public final AppCompatTextView textViewUHID;

  private ItemEventDataBinding(@NonNull LinearLayoutCompat rootView,
      @NonNull LinearLayoutCompat layoutid, @NonNull AppCompatTextView textViewDateTime,
      @NonNull AppCompatTextView textViewEventsData, @NonNull AppCompatTextView textViewTime,
      @NonNull AppCompatTextView textViewUHID) {
    this.rootView = rootView;
    this.layoutid = layoutid;
    this.textViewDateTime = textViewDateTime;
    this.textViewEventsData = textViewEventsData;
    this.textViewTime = textViewTime;
    this.textViewUHID = textViewUHID;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemEventDataBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemEventDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_event_data, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemEventDataBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      LinearLayoutCompat layoutid = (LinearLayoutCompat) rootView;

      id = R.id.textViewDateTime;
      AppCompatTextView textViewDateTime = ViewBindings.findChildViewById(rootView, id);
      if (textViewDateTime == null) {
        break missingId;
      }

      id = R.id.textViewEventsData;
      AppCompatTextView textViewEventsData = ViewBindings.findChildViewById(rootView, id);
      if (textViewEventsData == null) {
        break missingId;
      }

      id = R.id.textViewTime;
      AppCompatTextView textViewTime = ViewBindings.findChildViewById(rootView, id);
      if (textViewTime == null) {
        break missingId;
      }

      id = R.id.textViewUHID;
      AppCompatTextView textViewUHID = ViewBindings.findChildViewById(rootView, id);
      if (textViewUHID == null) {
        break missingId;
      }

      return new ItemEventDataBinding((LinearLayoutCompat) rootView, layoutid, textViewDateTime,
          textViewEventsData, textViewTime, textViewUHID);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
