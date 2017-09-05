package com.example.demo.DAO;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Transactional
public interface BaseDAO <T>  {
    void insert(T t);
    void insert(ArrayList<T> t);
    T select(Long id);
    void delete(Long id);
    void update(T t);
    List<T> selectAll();
}
