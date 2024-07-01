package com.example.notesapp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.example.notesapp.R;
import com.example.notesapp.room.model.NotesModel;
import com.example.notesapp.ui.view.AddNotesActivity;
import com.example.notesapp.utils.ItemListner;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/notesapp/ui/adapter/NotesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/notesapp/ui/adapter/NotesAdapter$NoteViewHolder;", "notes", "", "Lcom/example/notesapp/room/model/NotesModel;", "itemlistner", "Lcom/example/notesapp/utils/ItemListner;", "context", "Landroid/content/Context;", "(Ljava/util/List;Lcom/example/notesapp/utils/ItemListner;Landroid/content/Context;)V", "addItem", "", "position", "", "deleteItem", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "NoteViewHolder", "app_debug"})
public final class NotesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.notesapp.ui.adapter.NotesAdapter.NoteViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.notesapp.room.model.NotesModel> notes = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.notesapp.utils.ItemListner itemlistner = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    
    public NotesAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.notesapp.room.model.NotesModel> notes, @org.jetbrains.annotations.NotNull
    com.example.notesapp.utils.ItemListner itemlistner, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.notesapp.ui.adapter.NotesAdapter.NoteViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.notesapp.ui.adapter.NotesAdapter.NoteViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void deleteItem(int position) {
    }
    
    public final void addItem(int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/example/notesapp/ui/adapter/NotesAdapter$NoteViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "noteContent", "Landroid/widget/TextView;", "getNoteContent", "()Landroid/widget/TextView;", "noteTitle", "getNoteTitle", "app_debug"})
    public static final class NoteViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView noteTitle = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView noteContent = null;
        
        public NoteViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getNoteTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getNoteContent() {
            return null;
        }
    }
}