package com.ideao.dev.javadatabase.supplier.mappers;

import com.ideao.dev.javadatabase.supplier.Supplier;
import com.ideao.dev.javadatabase.supplier.dtos.SupplierDTO;

public class SupplierMapper {

    public static SupplierDTO toDTO(Supplier supplier) {
        return new SupplierDTO(
                supplier.getId(), supplier.getName(), supplier.getStreet(),
                supplier.getCity(), supplier.getState(), supplier.getZip()
        );
    }
}
