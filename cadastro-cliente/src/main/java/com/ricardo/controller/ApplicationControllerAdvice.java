package com.ricardo.controller;

import com.ricardo.exception.ExcecaoRegistroNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(ExcecaoRegistroNaoEncontrado.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String excecaoNaoEcontrada(ExcecaoRegistroNaoEncontrado ex) {
        return ex.getMessage();
    }
}
