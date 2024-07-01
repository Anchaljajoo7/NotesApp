package com.example.notesapp.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.notesapp.databinding.ActivityHomeBinding;
import com.example.notesapp.dialog.PopUpDialog;
import com.example.notesapp.dialog.onClickHandle;
import com.example.notesapp.room.DatabaseBuilder;
import com.example.notesapp.room.DatabaseHelperImpl;
import com.example.notesapp.room.model.NotesModel;
import com.example.notesapp.ui.adapter.NotesAdapter;
import com.example.notesapp.ui.viewmodel.AddNotesViewModel;
import com.example.notesapp.utils.ItemListner;
import com.google.android.material.snackbar.Snackbar;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\b\u0010\'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020%H\u0016J\b\u0010)\u001a\u00020%H\u0002J\b\u0010*\u001a\u00020%H\u0016J\b\u0010+\u001a\u00020%H\u0002J\u0012\u0010,\u001a\u00020%2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020%H\u0014J\u0018\u00100\u001a\u00020%2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u00065"}, d2 = {"Lcom/example/notesapp/ui/view/HomeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/notesapp/utils/ItemListner;", "Lcom/example/notesapp/dialog/onClickHandle;", "()V", "adapter", "Lcom/example/notesapp/ui/adapter/NotesAdapter;", "getAdapter", "()Lcom/example/notesapp/ui/adapter/NotesAdapter;", "binding", "Lcom/example/notesapp/databinding/ActivityHomeBinding;", "getBinding", "()Lcom/example/notesapp/databinding/ActivityHomeBinding;", "setBinding", "(Lcom/example/notesapp/databinding/ActivityHomeBinding;)V", "dbHelper", "Lcom/example/notesapp/room/DatabaseHelperImpl;", "getDbHelper", "()Lcom/example/notesapp/room/DatabaseHelperImpl;", "setDbHelper", "(Lcom/example/notesapp/room/DatabaseHelperImpl;)V", "dialog", "Lcom/example/notesapp/dialog/PopUpDialog;", "getDialog", "()Lcom/example/notesapp/dialog/PopUpDialog;", "setDialog", "(Lcom/example/notesapp/dialog/PopUpDialog;)V", "list", "", "Lcom/example/notesapp/room/model/NotesModel;", "viewModel", "Lcom/example/notesapp/ui/viewmodel/AddNotesViewModel;", "getViewModel", "()Lcom/example/notesapp/ui/viewmodel/AddNotesViewModel;", "setViewModel", "(Lcom/example/notesapp/ui/viewmodel/AddNotesViewModel;)V", "adapterSetup", "", "clickEvent", "deleteData", "deleteNotes", "deleteSingle", "discardPopup", "getData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onSelectedItemClicks", "position", "", "type", "", "app_debug"})
public final class HomeActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.notesapp.utils.ItemListner, com.example.notesapp.dialog.onClickHandle {
    public com.example.notesapp.ui.viewmodel.AddNotesViewModel viewModel;
    public com.example.notesapp.databinding.ActivityHomeBinding binding;
    public com.example.notesapp.room.DatabaseHelperImpl dbHelper;
    @org.jetbrains.annotations.NotNull
    private com.example.notesapp.dialog.PopUpDialog dialog;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.example.notesapp.room.model.NotesModel> list;
    @org.jetbrains.annotations.NotNull
    private final com.example.notesapp.ui.adapter.NotesAdapter adapter = null;
    
    public HomeActivity() {
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
    public final com.example.notesapp.databinding.ActivityHomeBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.example.notesapp.databinding.ActivityHomeBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.notesapp.room.DatabaseHelperImpl getDbHelper() {
        return null;
    }
    
    public final void setDbHelper(@org.jetbrains.annotations.NotNull
    com.example.notesapp.room.DatabaseHelperImpl p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.notesapp.dialog.PopUpDialog getDialog() {
        return null;
    }
    
    public final void setDialog(@org.jetbrains.annotations.NotNull
    com.example.notesapp.dialog.PopUpDialog p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.notesapp.ui.adapter.NotesAdapter getAdapter() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getData() {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void adapterSetup() {
    }
    
    private final void deleteSingle() {
    }
    
    private final void clickEvent() {
    }
    
    private final void deleteData() {
    }
    
    @java.lang.Override
    public void onSelectedItemClicks(int position, @org.jetbrains.annotations.NotNull
    java.lang.String type) {
    }
    
    @java.lang.Override
    public void discardPopup() {
    }
    
    @java.lang.Override
    public void deleteNotes() {
    }
}