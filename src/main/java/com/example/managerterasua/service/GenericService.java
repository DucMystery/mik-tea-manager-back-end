package com.example.managerterasua.service;

public interface GenericService<T> {
    Iterable<T> findAll();
    T findById(Long id);
    T save(T t);
    void remove(Long id);
}
