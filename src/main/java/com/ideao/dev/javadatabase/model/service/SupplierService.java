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

    public Supplier read(Long id) {
        return repository.read(id);
    }

    public void update(Supplier supplier) {
       if (repository.existsById(supplier.getId())) {
            repository.update(supplier);
       } else {
           System.out.println("Supplier not found.");
       }
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.delete(id);
        }
    }
}