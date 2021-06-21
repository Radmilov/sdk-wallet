package com.metropolitan.service;


import com.metropolitan.model.Note;
import com.metropolitan.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noteService")
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;


    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note findById(Long id) {
        return noteRepository.findById(id).get();
    }

    @Override
    public void save(Note n) {
        noteRepository.save(n);

    }
}
