// Generated by view binder compiler. Do not edit!
package com.example.notesapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class RvNotesBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final CardView cv;

  @NonNull
  public final TextView tvContent;

  @NonNull
  public final TextView tvTitle;

  private RvNotesBinding(@NonNull CardView rootView, @NonNull CardView cv,
      @NonNull TextView tvContent, @NonNull TextView tvTitle) {
    this.rootView = rootView;
    this.cv = cv;
    this.tvContent = tvContent;
    this.tvTitle = tvTitle;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static RvNotesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RvNotesBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.rv_notes, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RvNotesBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      CardView cv = (CardView) rootView;

      id = R.id.tv_content;
      TextView tvContent = ViewBindings.findChildViewById(rootView, id);
      if (tvContent == null) {
        break missingId;
      }

      id = R.id.tv_title;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      return new RvNotesBinding((CardView) rootView, cv, tvContent, tvTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
