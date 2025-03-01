// Generated by view binder compiler. Do not edit!
package com.agvahealthcare.ventilator_ext.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.agvahealthcare.ventilator_ext.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutDesignAlertBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final AppCompatButton btnOk;

  @NonNull
  public final TextView tvDesc;

  @NonNull
  public final TextView tvHead;

  private LayoutDesignAlertBinding(@NonNull CardView rootView, @NonNull AppCompatButton btnOk,
      @NonNull TextView tvDesc, @NonNull TextView tvHead) {
    this.rootView = rootView;
    this.btnOk = btnOk;
    this.tvDesc = tvDesc;
    this.tvHead = tvHead;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutDesignAlertBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutDesignAlertBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_design_alert, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutDesignAlertBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnOk;
      AppCompatButton btnOk = ViewBindings.findChildViewById(rootView, id);
      if (btnOk == null) {
        break missingId;
      }

      id = R.id.tvDesc;
      TextView tvDesc = ViewBindings.findChildViewById(rootView, id);
      if (tvDesc == null) {
        break missingId;
      }

      id = R.id.tvHead;
      TextView tvHead = ViewBindings.findChildViewById(rootView, id);
      if (tvHead == null) {
        break missingId;
      }

      return new LayoutDesignAlertBinding((CardView) rootView, btnOk, tvDesc, tvHead);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
