package com.ideao.dev.javadatabase.supplier;

import com.ideao.dev.javadatabase.common.database.TransactionManager;
import com.ideao.dev.javadatabase.supplier.dtos.CreateSupplierDTO;
import com.ideao.dev.javadatabase.supplier.dtos.SupplierDTO;
import com.ideao.dev.javadatabase.supplier.dtos.UpdateSupplierDTO;
import com.ideao.dev.javadatabase.supplier.exceptions.SupplierNotFoundException;
import com.ideao.dev.javadatabase.supplier.mappers.SupplierMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SupplierServiceJPA {
    private final SupplierDaoJPA repository;

    public SupplierServiceJPA() {
        this.repository = new SupplierDaoJPA();
    }

    public List<SupplierDTO> list() {
        return TransactionManager.execute( em -> {
            List<SupplierDTO> dtos = new ArrayList<>();
            List<Supplier> suppliers = repository.list();
                for (Supplier supplier : suppliers) {
                    dtos.add(SupplierMapper.toDTO(supplier));
                }
            return dtos;
        });
    }

    public void create(CreateSupplierDTO supplierDTO) {
        TransactionManager.execute( em -> {
            Supplier supplier = SupplierMapper.toEntity(supplierDTO);
            supplier.setActive(true);
            repository.create(supplier);
        });
    }

    public SupplierDTO findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID fornecido não pode ser nulo.");
        }
        return TransactionManager.execute(em -> {
            Optional<Supplier> optSupplier = repository.findById(id);
            Supplier supplier =
                    optSupplier.orElseThrow(() ->
                            new SupplierNotFoundException("Supplier not found for id = " + id + ". Try again!"));
            return SupplierMapper.toDTO(supplier);
        });
    }

    public void update(UpdateSupplierDTO supplierDTO) {
        if (supplierDTO.getId() == null) {
            throw new IllegalArgumentException("O ID fornecido para atualização não pode ser nulo.");
        }
         TransactionManager.execute(em -> {
            Optional<Supplier> optSupplier = repository.findById(supplierDTO.getId());
            Supplier supplier =
                    optSupplier.orElseThrow(
                            () -> new SupplierNotFoundException(
                                    "Supplier not found for id = " + supplierDTO.getId() + "."));

            SupplierMapper.updateEntityFromDTO(supplierDTO, supplier);
            supplier.setActive(true);
        });
    }

    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID fornecido não pode ser nulo.");
        }
       TransactionManager.execute(em -> {
           Optional<Supplier> optSupplier = repository.findById(id);
           Supplier supplier =
                   optSupplier.orElseThrow(
                           () -> new SupplierNotFoundException("Supplier not found for id = " + id + "."));
           em.remove(supplier);
       });
    }
}