package com.webacademy.padaria.infra;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    
    @ExceptionHandler(EntidadeNotFound.class)
    public ResponseEntity<MensagemErro> tratarEntidadeNotFound(EntidadeNotFound e) {
        var mensagemErro = new MensagemErro(e.getMessage(), Instant.now(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(mensagemErro.httpStatus()).body(mensagemErro);
    }
}