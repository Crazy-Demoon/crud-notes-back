package com.salomon.prueba.curd.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salomon.prueba.curd.exceptions.DuplicateTitleException;
import com.salomon.prueba.curd.exceptions.NullException;
import com.salomon.prueba.curd.exceptions.ResourceNotFoundException;
import com.salomon.prueba.curd.exceptions.TooLongException;
import com.salomon.prueba.curd.models.NoteModel;
import com.salomon.prueba.curd.repositories.NoteRepository;

@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    public ArrayList<NoteModel> getAllNotes() {
        return (ArrayList<NoteModel>) noteRepository.findAll();

    }

    public NoteModel createNote(NoteModel note) {
        Optional<NoteModel> existente = noteRepository.findByTitle(note.getTitle());

        if (note.getTitle() == null || note.getTitle().isEmpty()) {
            throw new NullException("El título de la nota no puede ser nulo o vacío.");
        }

        if (note.getTitle().length() > 50) {
            throw new TooLongException("El título de la nota no puede exceder los 50 caracteres.");
        }

        if (note.getContent().length() > 255) {
            throw new TooLongException("El contenido de la nota no puede exceder los 255 caracteres.");
        }

        if (existente.isPresent()) {
            throw new DuplicateTitleException("Ya existe una nota con el título: " + note.getTitle());
        }
        return noteRepository.save(note);
    }

    public Optional<NoteModel> getNoteByID(Long id) {
        return noteRepository.findById(id);
    }

    public boolean deleteNote(Long id) {
        Optional<NoteModel> note = this.getNoteByID(id);

        try {
            if (!note.isPresent()) {
            throw new ResourceNotFoundException("Nota no encontrada con ID: " + id);
        }
            noteRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public NoteModel updateNote(Long id, NoteModel updatedNote) {
        NoteModel existingNote = noteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Nota no encontrada con ID: " + id));
    
        existingNote.setTitle(updatedNote.getTitle());
        existingNote.setContent(updatedNote.getContent());
    
    
        return noteRepository.save(existingNote);
    }
    
}
