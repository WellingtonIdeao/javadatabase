package com.ideao.dev.javadatabase.model.service;

import com.ideao.dev.javadatabase.model.dao.GenericRepository;
import com.ideao.dev.javadatabase.model.dto.AddSupplierDTO;
import com.ideao.dev.javadatabase.model.dto.SupplierDTO;
import com.ideao.dev.javadatabase.model.dto.UpdateSupplierDTO;
import com.ideao.dev.javadatabase.model.entity.Supplier;
import com.ideao.dev.javadatabase.model.dao.DAOFactory;

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
            supplierDTOs.add(
                    new SupplierDTO(
                            s.getId(), s.getName(), s.getStreet(), s.getCity(), s.getState(), s.getZip())
            );
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
        Supplier sup = repository.read(id);
        SupplierDTO supplierDTO = null;

        if(sup != null) {
            supplierDTO =
                    new SupplierDTO(
                            sup.getId(), sup.getName(),sup.getStreet(),
                            sup.getCity(), sup.getState(), sup.getZip()
                    );
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