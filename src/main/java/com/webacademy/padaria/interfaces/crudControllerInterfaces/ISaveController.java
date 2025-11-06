package com.webacademy.padaria.interfaces.crudControllerInterfaces;

import org.springframework.http.ResponseEntity;

public interface ISaveController<T> {
    ResponseEntity<T> insert(T objeto);
    ResponseEntity<T> update(T objeto);
}
