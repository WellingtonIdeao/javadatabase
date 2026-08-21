package com.ideao.dev.javadatabase.controller;

import com.ideao.dev.javadatabase.model.entity.Supplier;
import com.ideao.dev.javadatabase.model.service.SupplierService;
import com.ideao.dev.javadatabase.view.SupplierView;

import java.util.List;

public class SupplierController {
    private final SupplierService supplierService;
    private final SupplierView supplierView;

    public SupplierController() {
       supplierService = new SupplierService();
       supplierView = new SupplierView();
    }

    public void viewList() {
        List<Supplier> suppliers = supplierService.viewList();

        supplierView.viewJson(suppliers);
    }

    public void add(Supplier supplier) {
        supplierService.add(supplier);
    }

    public void view() {
        Long id = 5L;
        Supplier supplier = supplierService.read(id);
        supplierView.viewDetail(supplier);
    }

    public void update() {
        Long id = 5L;
        Supplier supplier = supplierService.read(id);
        if (supplier != null) {
            supplier.setName("Modificado Ltda.");
            supplierService.update(supplier);
        } else {
            System.out.println("Supplier invalid.");
        }
    }

    public void delete() {
        Long id = 5L;
        supplierService.delete(id);
    }

}