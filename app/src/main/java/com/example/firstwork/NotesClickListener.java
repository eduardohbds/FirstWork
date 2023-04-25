package com.example.firstwork;

import androidx.cardview.widget.CardView;

import com.example.firstwork.Models.Notes;

public interface NotesClickListener {
    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);
}
