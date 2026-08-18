package com.ideao.dev.javadatabase.model.service;

import com.ideao.dev.javadatabase.model.dao.GenericRepository;
import com.ideao.dev.javadatabase.model.entity.Supplier;
import com.ideao.dev.javadatabase.model.dao.DAOFactory;

import java.util.List;

public class SupplierService {
    private final GenericRepository<Supplier, Long> repository;

    public SupplierService() {
        this.repository = DAOFactory.createSupplierDAO();
    }

    public List<Supplier> viewList() {
        return repository.viewList();
    }

    public void add(Supplier supplier) {
        repository.create(supplier);
    }
}