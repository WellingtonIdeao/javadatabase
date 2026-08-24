package com.ideao.dev.javadatabase.supplier;

import com.ideao.dev.javadatabase.common.repository.GenericRepository;
import com.ideao.dev.javadatabase.supplier.dto.AddSupplierDTO;
import com.ideao.dev.javadatabase.supplier.dto.SupplierDTO;
import com.ideao.dev.javadatabase.supplier.dto.UpdateSupplierDTO;
import com.ideao.dev.javadatabase.common.database.DAOFactory;

import java.util.ArrayList;
import java.util.List;

public class SupplierService {
    private final GenericRepository<Supplier, Long> repository;

    public SupplierService() {
        this.repository = DAOFactory.createSupplierDAO();
    }

    public List<SupplierDTO> viewList() {
        List<Supplier> suppliers = repository.viewList();
        List<SupplierDTO> supplierDTOs = new ArrayList<>();
        for (Supplier s: suppliers) {
            supplierDTOs.add(new SupplierDTO(s));
        }
        return supplierDTOs;
    }

    public void add(AddSupplierDTO supplierDTO) {
        Supplier supplier =
                new Supplier(
                        null, supplierDTO.getName(), supplierDTO.getStreet(),
                        supplierDTO.getCity(), supplierDTO.getState(), supplierDTO.getZip()
                );
        repository.create(supplier);
    }

    public SupplierDTO read(Long id) {
        Supplier supplier = repository.read(id);
        SupplierDTO supplierDTO = null;

        if(supplier != null) {
            supplierDTO = new SupplierDTO(supplier);
        }
        return supplierDTO;
    }

    public void update(UpdateSupplierDTO supplierDTO) {
        Supplier supplier =
                new Supplier(
                        supplierDTO.getId(), supplierDTO.getName(), supplierDTO.getStreet(),
                        supplierDTO.getCity(), supplierDTO.getState(), supplierDTO.getZip()
                );
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