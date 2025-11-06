package com.webacademy.padaria.infra;

public class EntidadeNotFound extends RuntimeException {
    public EntidadeNotFound(String mensagem) {
        super(mensagem);
    }
}
