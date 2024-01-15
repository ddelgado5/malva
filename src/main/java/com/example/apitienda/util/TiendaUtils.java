package com.example.apitienda.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class TiendaUtils {

    private TiendaUtils(){

    }

    public static ResponseEntity<String> getResponseEntity(String message, HttpStatus httpStatus){
        return new ResponseEntity<String>("mensaje: " + message, httpStatus);
    }
}
