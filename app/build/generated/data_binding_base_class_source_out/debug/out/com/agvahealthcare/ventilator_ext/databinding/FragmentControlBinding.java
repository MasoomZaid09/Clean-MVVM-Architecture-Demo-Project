// Generated by view binder compiler. Do not edit!
package com.agvahealthcare.ventilator_ext.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.agvahealthcare.ventilator_ext.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentControlBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout btnStartSedation;

  @NonNull
  public final FragmentContainerView container;

  @NonNull
  public final RecyclerView controlOptionsRecyclerView;

  @NonNull
  public final Guideline guidelineH2;

  @NonNull
  public final Guideline guidelineH3;

  @NonNull
  public final Guideline guidelineV1;

  @NonNull
  public final Guideline guidelineV2;

  @NonNull
  public final ImageView imgCross;

  @NonNull
  public final TextView txtCurrent;

  @NonNull
  public final TextView txtMode;

  @NonNull
  public final TextView txtStartSedation;

  private FragmentControlBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout btnStartSedation, @NonNull FragmentContainerView container,
      @NonNull RecyclerView controlOptionsRecyclerView, @NonNull Guideline guidelineH2,
      @NonNull Guideline guidelineH3, @NonNull Guideline guidelineV1,
      @NonNull Guideline guidelineV2, @NonNull ImageView imgCross, @NonNull TextView txtCurrent,
      @NonNull TextView txtMode, @NonNull TextView txtStartSedation) {
    this.rootView = rootView;
    this.btnStartSedation = btnStartSedation;
    this.container = container;
    this.controlOptionsRecyclerView = controlOptionsRecyclerView;
    this.guidelineH2 = guidelineH2;
    this.guidelineH3 = guidelineH3;
    this.guidelineV1 = guidelineV1;
    this.guidelineV2 = guidelineV2;
    this.imgCross = imgCross;
    this.txtCurrent = txtCurrent;
    this.txtMode = txtMode;
    this.txtStartSedation = txtStartSedation;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentControlBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentControlBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_control, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentControlBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnStartSedation;
      ConstraintLayout btnStartSedation = ViewBindings.findChildViewById(rootView, id);
      if (btnStartSedation == null) {
        break missingId;
      }

      id = R.id.container;
      FragmentContainerView container = ViewBindings.findChildViewById(rootView, id);
      if (container == null) {
        break missingId;
      }

      id = R.id.controlOptionsRecyclerView;
      RecyclerView controlOptionsRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (controlOptionsRecyclerView == null) {
        break missingId;
      }

      id = R.id.guidelineH2;
      Guideline guidelineH2 = ViewBindings.findChildViewById(rootView, id);
      if (guidelineH2 == null) {
        break missingId;
      }

      id = R.id.guidelineH3;
      Guideline guidelineH3 = ViewBindings.findChildViewById(rootView, id);
      if (guidelineH3 == null) {
        break missingId;
      }

      id = R.id.guidelineV1;
      Guideline guidelineV1 = ViewBindings.findChildViewById(rootView, id);
      if (guidelineV1 == null) {
        break missingId;
      }

      id = R.id.guidelineV2;
      Guideline guidelineV2 = ViewBindings.findChildViewById(rootView, id);
      if (guidelineV2 == null) {
        break missingId;
      }

      id = R.id.imgCross;
      ImageView imgCross = ViewBindings.findChildViewById(rootView, id);
      if (imgCross == null) {
        break missingId;
      }

      id = R.id.txtCurrent;
      TextView txtCurrent = ViewBindings.findChildViewById(rootView, id);
      if (txtCurrent == null) {
        break missingId;
      }

      id = R.id.txtMode;
      TextView txtMode = ViewBindings.findChildViewById(rootView, id);
      if (txtMode == null) {
        break missingId;
      }

      id = R.id.txtStartSedation;
      TextView txtStartSedation = ViewBindings.findChildViewById(rootView, id);
      if (txtStartSedation == null) {
        break missingId;
      }

      return new FragmentControlBinding((ConstraintLayout) rootView, btnStartSedation, container,
          controlOptionsRecyclerView, guidelineH2, guidelineH3, guidelineV1, guidelineV2, imgCross,
          txtCurrent, txtMode, txtStartSedation);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
