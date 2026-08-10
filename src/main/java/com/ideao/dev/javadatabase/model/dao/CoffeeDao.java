package com.ideao.dev.javadatabase.model.dao;

import com.ideao.dev.javadatabase.model.entity.Coffee;

import java.util.List;

public interface CoffeeDao {
    List<Coffee> viewList();
    void create(Coffee coffee);
    void update(Coffee coffee);
    void read(long id);
    void delete(long id);
}
