package com.ideao.dev.javadatabase.model.service;

import com.ideao.dev.javadatabase.model.entity.Supplier;
import com.ideao.dev.javadatabase.model.dao.DAOFactory;
import com.ideao.dev.javadatabase.model.dao.SupplierDAO;

import java.util.List;

public class SupplierService {
    private final SupplierDAO supplierDAO;

    public SupplierService() {
        supplierDAO = DAOFactory.createSupplierDAO();
    }

    public List<Supplier> viewList() {
        return supplierDAO.viewList();
    }

    public void add(Supplier supplier) {
        supplierDAO.create(supplier);
    }
}