// Generated by view binder compiler. Do not edit!
package com.example.notesapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.notesapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PopupDeleteDialogBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final LinearLayout llCancel;

  @NonNull
  public final LinearLayout llYes;

  @NonNull
  public final TextView tvTitle;

  private PopupDeleteDialogBinding(@NonNull CardView rootView, @NonNull LinearLayout llCancel,
      @NonNull LinearLayout llYes, @NonNull TextView tvTitle) {
    this.rootView = rootView;
    this.llCancel = llCancel;
    this.llYes = llYes;
    this.tvTitle = tvTitle;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static PopupDeleteDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PopupDeleteDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.popup_delete_dialog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PopupDeleteDialogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ll_cancel;
      LinearLayout llCancel = ViewBindings.findChildViewById(rootView, id);
      if (llCancel == null) {
        break missingId;
      }

      id = R.id.ll_yes;
      LinearLayout llYes = ViewBindings.findChildViewById(rootView, id);
      if (llYes == null) {
        break missingId;
      }

      id = R.id.tv_title;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      return new PopupDeleteDialogBinding((CardView) rootView, llCancel, llYes, tvTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
