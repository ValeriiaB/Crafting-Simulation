package com.example.demo.service;


import java.util.List;

public interface IService <T>{
    List<T> selectAll();
    T select(Long id);
    void insert(T t);
    void update(T t);
    void delete(Long id);
}
