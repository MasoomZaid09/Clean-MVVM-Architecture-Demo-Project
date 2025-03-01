// Generated by view binder compiler. Do not edit!
package com.agvahealthcare.ventilator_ext.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.agvahealthcare.ventilator_ext.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class RecoveryButtonsIncludeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView includeRecoveryBtn;

  @NonNull
  public final ConstraintLayout recoveryRootInclude;

  private RecoveryButtonsIncludeBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView includeRecoveryBtn, @NonNull ConstraintLayout recoveryRootInclude) {
    this.rootView = rootView;
    this.includeRecoveryBtn = includeRecoveryBtn;
    this.recoveryRootInclude = recoveryRootInclude;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RecoveryButtonsIncludeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RecoveryButtonsIncludeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.recovery_buttons_include, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RecoveryButtonsIncludeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.include_recovery_btn;
      TextView includeRecoveryBtn = ViewBindings.findChildViewById(rootView, id);
      if (includeRecoveryBtn == null) {
        break missingId;
      }

      ConstraintLayout recoveryRootInclude = (ConstraintLayout) rootView;

      return new RecoveryButtonsIncludeBinding((ConstraintLayout) rootView, includeRecoveryBtn,
          recoveryRootInclude);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
