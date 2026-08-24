package com.ideao.dev.javadatabase.coffee.mappers;

import com.ideao.dev.javadatabase.coffee.Coffee;
import com.ideao.dev.javadatabase.coffee.dtos.CoffeeDTO;

public class CoffeeMapper {

    public static CoffeeDTO toDTO(Coffee coffee) {
        return new CoffeeDTO(
                coffee.getName(), coffee.getSupId(), coffee.getPrice(),
                coffee.getSales(), coffee.getTotal()
        );
    }
}
