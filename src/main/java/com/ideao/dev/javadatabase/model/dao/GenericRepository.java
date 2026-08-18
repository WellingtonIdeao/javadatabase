package com.ideao.dev.javadatabase.model.dao;

import com.ideao.dev.javadatabase.model.entity.Supplier;

import java.util.List;

public interface GenericRepository<T, ID> {
    List<T> viewList();
    void create(T t);
    void update(T t);
    void read(ID id);
    void delete(ID id);
}