package com.salomon.prueba.curd.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salomon.prueba.curd.models.NoteModel;
import com.salomon.prueba.curd.services.NoteService;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    NoteService noteService;

    @GetMapping()
    public ArrayList<NoteModel> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping(path = "/{id}")
    public Optional<NoteModel> getNoteByID(@PathVariable("id") Long id) {
        return noteService.getNoteByID(id);
    }

    @PostMapping()
    public NoteModel createNote(@RequestBody NoteModel noteModel) {
        return this.noteService.createNote(noteModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteModel> updateNote(@PathVariable Long id, @RequestBody NoteModel note) {
        NoteModel updated = noteService.updateNote(id, note);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteByID(@PathVariable("id") long id) {
        boolean ok = this.noteService.deleteNote(id);
        return ok ? "Se elimino la nota " + id : "No se pudo eliminar la nota " + id;
    }

}
