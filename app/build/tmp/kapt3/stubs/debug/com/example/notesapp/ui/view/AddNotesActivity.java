package com.example.notesapp.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.notesapp.databinding.ActivityAddNotesBinding;
import com.example.notesapp.room.DatabaseBuilder;
import com.example.notesapp.room.DatabaseHelperImpl;
import com.example.notesapp.room.model.NotesModel;
import com.example.notesapp.ui.viewmodel.AddNotesViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020 H\u0002J\u0012\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006&"}, d2 = {"Lcom/example/notesapp/ui/view/AddNotesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/notesapp/databinding/ActivityAddNotesBinding;", "getBinding", "()Lcom/example/notesapp/databinding/ActivityAddNotesBinding;", "setBinding", "(Lcom/example/notesapp/databinding/ActivityAddNotesBinding;)V", "content", "", "dbHelper", "Lcom/example/notesapp/room/DatabaseHelperImpl;", "getDbHelper", "()Lcom/example/notesapp/room/DatabaseHelperImpl;", "setDbHelper", "(Lcom/example/notesapp/room/DatabaseHelperImpl;)V", "id", "", "getId", "()I", "setId", "(I)V", "text", "type", "viewModel", "Lcom/example/notesapp/ui/viewmodel/AddNotesViewModel;", "getViewModel", "()Lcom/example/notesapp/ui/viewmodel/AddNotesViewModel;", "setViewModel", "(Lcom/example/notesapp/ui/viewmodel/AddNotesViewModel;)V", "checkText", "", "checking", "clickEvent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class AddNotesActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.example.notesapp.ui.viewmodel.AddNotesViewModel viewModel;
    public com.example.notesapp.databinding.ActivityAddNotesBinding binding;
    public com.example.notesapp.room.DatabaseHelperImpl dbHelper;
    @org.jetbrains.annotations.Nullable
    private java.lang.String type;
    @org.jetbrains.annotations.Nullable
    private java.lang.String text;
    @org.jetbrains.annotations.Nullable
    private java.lang.String content;
    private int id = 0;
    
    public AddNotesActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.notesapp.ui.viewmodel.AddNotesViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.example.notesapp.ui.viewmodel.AddNotesViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.notesapp.databinding.ActivityAddNotesBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.example.notesapp.databinding.ActivityAddNotesBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.notesapp.room.DatabaseHelperImpl getDbHelper() {
        return null;
    }
    
    public final void setDbHelper(@org.jetbrains.annotations.NotNull
    com.example.notesapp.room.DatabaseHelperImpl p0) {
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void checking() {
    }
    
    private final void clickEvent() {
    }
    
    private final void checkText() {
    }
}