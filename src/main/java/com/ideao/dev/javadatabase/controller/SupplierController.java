package com.ideao.dev.javadatabase.controller;

import com.ideao.dev.javadatabase.model.dto.AddSupplierDTO;
import com.ideao.dev.javadatabase.model.dto.SupplierDTO;
import com.ideao.dev.javadatabase.model.dto.UpdateSupplierDTO;
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
        List<SupplierDTO> supplierDTOS = supplierService.viewList();

        supplierView.viewJson(supplierDTOS);
    }

    public void view(Long id) {
        SupplierDTO supplierDTO = supplierService.read(id);
        supplierView.viewDetail(supplierDTO);
    }

    public void add(AddSupplierDTO supplierDTO) {
        supplierService.add(supplierDTO);
    }

    public void update(UpdateSupplierDTO updateSupplierDTO) {
        supplierService.update(updateSupplierDTO);
    }

    public void delete(Long id) {
        supplierService.delete(id);
    }
}