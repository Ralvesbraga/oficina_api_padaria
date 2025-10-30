package com.webacademy.padaria.crudControllerInterfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface IGetController<T> {
    ResponseEntity<T> get(Long id);
    ResponseEntity<List<T>> get(String termoBusca);
}