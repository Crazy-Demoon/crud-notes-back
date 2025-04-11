package com.salomon.prueba.curd.exceptions;

public class TooLongException extends RuntimeException{
    public TooLongException(String message){
        super(message);
    }
}
