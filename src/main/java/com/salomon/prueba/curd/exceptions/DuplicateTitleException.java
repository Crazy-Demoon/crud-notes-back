package com.salomon.prueba.curd.exceptions;

public class DuplicateTitleException extends RuntimeException{
    public DuplicateTitleException(String message){
        super(message);
    }
}
