package com.ideao.dev.javadatabase.supplier;

import com.ideao.dev.javadatabase.common.exceptions.BusinessException;
import com.ideao.dev.javadatabase.supplier.dtos.CreateSupplierDTO;
import com.ideao.dev.javadatabase.supplier.dtos.SupplierDTO;
import com.ideao.dev.javadatabase.supplier.dtos.UpdateSupplierDTO;
import com.ideao.dev.javadatabase.supplier.exceptions.SupplierNotFoundException;

import java.util.List;

public class SupplierController {
    private final SupplierServiceJPA supplierService;
    private final SupplierView supplierView;

    public SupplierController() {
       supplierService = new SupplierServiceJPA();
       supplierView = new SupplierView();
    }

    public void list() {
        List<SupplierDTO> supplierDTOS = supplierService.list();
        supplierView.viewJson(supplierDTOS);
    }

    public void view(Long id) {
        try {
            SupplierDTO supplierDTO = supplierService.findById(id);
            supplierView.viewDetail(supplierDTO);
        } catch(SupplierNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void create(CreateSupplierDTO supplierDTO) {
        try {
            supplierService.create(supplierDTO);
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(UpdateSupplierDTO updateSupplierDTO) {
        try {
            supplierService.update(updateSupplierDTO);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            supplierService.delete(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}