package com.salomon.prueba.curd.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.salomon.prueba.curd.models.NoteModel;



@Repository
public interface NoteRepository extends CrudRepository<NoteModel, Long>{
    Optional<NoteModel> findByTitle(String title);
}
