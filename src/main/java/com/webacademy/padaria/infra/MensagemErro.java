package com.webacademy.padaria.infra;

import java.time.Instant;

import org.springframework.http.HttpStatus;

public record MensagemErro(String mensagem, Instant momento, HttpStatus httpStatus) {
}
