package com.metropolitan.service;

import com.metropolitan.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> findAll();

    Note findById(Long id);

    void save(Note n);

    void delete(Note n);
}
