package com.ideao.dev.javadatabase.model.dao;

import com.ideao.dev.javadatabase.model.entity.Supplier;

import java.util.List;

public interface SupplierDAO {
    List<Supplier> viewList();
    void create(Supplier supplier);
    void update(Supplier supplier);
    void read(long id);
    void delete(long id);
}
