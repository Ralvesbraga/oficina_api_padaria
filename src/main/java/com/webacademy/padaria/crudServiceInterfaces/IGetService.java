package com.webacademy.padaria.crudServiceInterfaces;

import java.util.List;

public interface IGetService<T> {
    T get(Long id);
    List<T> get(String termoBusca);
}
