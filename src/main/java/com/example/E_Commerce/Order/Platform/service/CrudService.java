package com.example.E_Commerce.Order.Platform.service;

import java.util.List;

public interface CrudService<T> {

    T create(T d);

    List<T> getAll();

    T getById(Long id);

    T update(Long id, T d);

    void delete(Long id);
}