package com.ideao.dev.javadatabase.supplier;

import com.ideao.dev.javadatabase.supplier.dtos.AddSupplierDTO;
import com.ideao.dev.javadatabase.supplier.dtos.SupplierDTO;
import com.ideao.dev.javadatabase.supplier.dtos.UpdateSupplierDTO;

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
        if ( updateSupplierDTO.getId() == null) {
            System.out.println("Supplier invalid.");
        } else {
            supplierService.update(updateSupplierDTO);
        }
    }

    public void delete(Long id) {
        supplierService.delete(id);
    }
}