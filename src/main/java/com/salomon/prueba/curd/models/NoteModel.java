package com.salomon.prueba.curd.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "notes")
public class NoteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @Column(length = 50, nullable = false, unique = true)
    @NotBlank(message = "El título es obligatorio")
    @Size(max = 50, message = "El título no debe superar los 50 caracteres")
    private String title;

    @Column(length = 255, nullable = true)
    @Size(max = 255, message = "El contenido no debe exceder los 255 caracteres")
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @PrePersist
    protected void onCreate() {
        this.created_at = new Date(System.currentTimeMillis());
    }
}
