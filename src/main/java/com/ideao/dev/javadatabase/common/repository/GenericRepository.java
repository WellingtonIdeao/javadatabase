package com.ideao.dev.javadatabase.common.repository;

import java.util.List;

public interface GenericRepository<T, ID> {
    List<T> viewList();
    void create(T t);
    void update(T t);
    T read(ID id);
    void delete(ID id);
    Boolean existsById(ID id);
}