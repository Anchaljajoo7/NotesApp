package com.example.notesapp.ui.viewmodel;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.notesapp.room.DatabaseBuilder;
import com.example.notesapp.room.DatabaseHelperImpl;
import com.example.notesapp.room.model.NotesModel;
import com.example.notesapp.ui.repository.AddNotesRepository;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 J\u001e\u0010!\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006$"}, d2 = {"Lcom/example/notesapp/ui/viewmodel/AddNotesViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_errorLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "all", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/notesapp/room/model/NotesModel;", "getAll", "()Landroidx/lifecycle/LiveData;", "allNotes", "dbHelper", "Lcom/example/notesapp/room/DatabaseHelperImpl;", "getDbHelper", "()Lcom/example/notesapp/room/DatabaseHelperImpl;", "errorLiveData", "getErrorLiveData", "repository", "Lcom/example/notesapp/ui/repository/AddNotesRepository;", "getRepository", "()Lcom/example/notesapp/ui/repository/AddNotesRepository;", "deleteAll", "", "getAllNotes", "insert", "list", "singleDelete", "id", "", "update", "title", "content", "app_debug"})
public final class AddNotesViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.notesapp.room.DatabaseHelperImpl dbHelper = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.notesapp.ui.repository.AddNotesRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.notesapp.room.model.NotesModel>> allNotes = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _errorLiveData = null;
    
    public AddNotesViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.notesapp.room.DatabaseHelperImpl getDbHelper() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.notesapp.ui.repository.AddNotesRepository getRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.notesapp.room.model.NotesModel>> getAll() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getErrorLiveData() {
        return null;
    }
    
    public final void getAllNotes() {
    }
    
    public final void insert(@org.jetbrains.annotations.NotNull
    com.example.notesapp.room.model.NotesModel list) {
    }
    
    public final void update(int id, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String content) {
    }
    
    public final void deleteAll() {
    }
    
    public final void singleDelete(int id) {
    }
}