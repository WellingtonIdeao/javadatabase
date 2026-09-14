package com.ideao.dev.javadatabase.coffee.mappers;

import com.ideao.dev.javadatabase.coffee.Coffee;
import com.ideao.dev.javadatabase.coffee.dtos.CreateCoffeeDTO;
import com.ideao.dev.javadatabase.coffee.dtos.UpdateCoffeeDTO;
import com.ideao.dev.javadatabase.coffee.dtos.CoffeeDTO;
import com.ideao.dev.javadatabase.supplier.Supplier;
import com.ideao.dev.javadatabase.supplier.dtos.SupplierDTO;

public class CoffeeMapper {

    public static CoffeeDTO toDTO(Coffee coffee) {
        if (coffee == null) {
            return null;
        }
        CoffeeDTO coffeeDTO =
                new CoffeeDTO(
                        coffee.getId(),
                        coffee.getName(),
                        coffee.getPrice(),
                        coffee.getSales(),
                        coffee.getTotal());

        if (coffee.getSupplier() != null) {
            Supplier supplier = coffee.getSupplier();
            SupplierDTO supplierDTO =
                    new SupplierDTO(
                            supplier.getId(),
                            supplier.getName(),
                            supplier.getStreet(),
                            supplier.getCity(),
                            supplier.getState(),
                            supplier.getZip()
                    );
            coffeeDTO.setSupplierDTO(supplierDTO);
        }
        return coffeeDTO;
    }
    public static Coffee toEntity(CreateCoffeeDTO dto) {
        if (dto == null) {
            return null;
        }
        Coffee coffee = new Coffee(null, dto.getName(), dto.getPrice(), dto.getSales(), dto.getTotal());
        coffee.setActive(true);
        return coffee;
    }

    public static Coffee updateEntityFromDTO(UpdateCoffeeDTO dto, Coffee coffee) {
        if (dto == null || coffee == null) {
            return coffee;
        }
        coffee.setName(dto.getName());
        coffee.setPrice(dto.getPrice());
        coffee.setSales(dto.getSales());
        coffee.setTotal(dto.getTotal());
        coffee.setActive(true);
        return coffee;
    }
}