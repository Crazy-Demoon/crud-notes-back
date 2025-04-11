package com.salomon.prueba.curd.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private String mensaje;
    private int estado;
    private LocalDateTime fecha;
}
