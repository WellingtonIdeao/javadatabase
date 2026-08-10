package com.ideao.dev.javadatabase.controller;

import com.ideao.dev.javadatabase.model.entity.Supplier;
import com.ideao.dev.javadatabase.model.service.SupplierService;
import com.ideao.dev.javadatabase.view.SupplierView;

import java.util.List;

public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController() {
       supplierService = new SupplierService();
    }

    public void viewList() {
        List<Supplier> suppliers = supplierService.viewList();

        SupplierView view = new SupplierView();
        view.viewJson(suppliers);
    }

    public void add(Supplier supplier) {
        supplierService.add(supplier);
    }
}