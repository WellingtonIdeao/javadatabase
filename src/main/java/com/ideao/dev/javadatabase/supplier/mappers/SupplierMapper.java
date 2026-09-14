package com.ideao.dev.javadatabase.supplier.mappers;

import com.ideao.dev.javadatabase.supplier.Supplier;
import com.ideao.dev.javadatabase.supplier.dtos.CreateSupplierDTO;
import com.ideao.dev.javadatabase.supplier.dtos.SupplierDTO;
import com.ideao.dev.javadatabase.supplier.dtos.UpdateSupplierDTO;

public class SupplierMapper {

    public static SupplierDTO toDTO(Supplier supplier) {
        if (supplier == null) {
           return null;
        }
        return new SupplierDTO(
                supplier.getId(), supplier.getName(), supplier.getStreet(),
                supplier.getCity(), supplier.getState(), supplier.getZip()
        );
    }

    public static Supplier toEntity(CreateSupplierDTO dto) {
        if (dto == null) {
            return null;
        }
        Supplier supplier = new Supplier(null, dto.getName(), dto.getStreet(), dto.getCity(), dto.getState(), dto.getZip());
        supplier.setActive(true);
        return supplier;
    }

    public static Supplier updateEntityFromDTO(UpdateSupplierDTO dto, Supplier supplier) {
        if(dto == null || supplier == null) {
            return supplier;
        }

        supplier.setName(dto.getName());
        supplier.setStreet(dto.getStreet());
        supplier.setCity(dto.getCity());
        supplier.setState(dto.getState());
        supplier.setZip(dto.getZip());
        supplier.setActive(true);
        return supplier;
    }
}