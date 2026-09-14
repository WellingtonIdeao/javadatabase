package com.ideao.dev.javadatabase;

import com.ideao.dev.javadatabase.coffee.CoffeeController;
import com.ideao.dev.javadatabase.coffee.dtos.CreateCoffeeDTO;
import com.ideao.dev.javadatabase.coffee.dtos.UpdateCoffeeDTO;
import com.ideao.dev.javadatabase.common.handler.GlobalExceptionHandler;
import com.ideao.dev.javadatabase.supplier.SupplierController;
import com.ideao.dev.javadatabase.supplier.Uf;
import com.ideao.dev.javadatabase.supplier.dtos.CreateSupplierDTO;
import com.ideao.dev.javadatabase.supplier.dtos.UpdateSupplierDTO;

import java.math.BigDecimal;


public class App {
	public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());

		SupplierController supController = new SupplierController();
        CoffeeController coffeeController = new CoffeeController();

        coffeeController.list();
        coffeeController.view(1L);
        CreateCoffeeDTO newCoffee =
                new CreateCoffeeDTO(
                        "Novissimo cafe fornecedor 2",
                        2L, new BigDecimal("20.99"),
                        1,
                        3);
        coffeeController.create(newCoffee);
        UpdateCoffeeDTO updateCoffee =
                new UpdateCoffeeDTO(
                        1L,
                        "Café atualizado 3",
                        1L,
                        new BigDecimal("20.99"),
                        1,
                        1);
        coffeeController.update(updateCoffee);
        coffeeController.delete(1L);

        supController.list();
        supController.view(1L);
        CreateSupplierDTO newSupplier =
                new CreateSupplierDTO("Transaction Manager errado", "projetada", "joão pessoa", Uf.BA, "58000");
        supController.create(newSupplier);
        UpdateSupplierDTO updateSupplier =
                new UpdateSupplierDTO(
                        2L, "Transaction Manager 2","projetada",
                        "Salvador", Uf.BA, "50000"
                );
        supController.update(updateSupplier);
        supController.delete(1L);
    }
}