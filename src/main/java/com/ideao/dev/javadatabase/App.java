package com.ideao.dev.javadatabase;

import com.ideao.dev.javadatabase.coffee.CoffeeController;
import com.ideao.dev.javadatabase.coffee.dtos.AddCoffeeDTO;
import com.ideao.dev.javadatabase.coffee.dtos.UpdateCoffeeDTO;
import com.ideao.dev.javadatabase.supplier.SupplierController;
import com.ideao.dev.javadatabase.supplier.dtos.AddSupplierDTO;
import com.ideao.dev.javadatabase.supplier.dtos.UpdateSupplierDTO;


public class App {
	public static void main(String[] args) {
		SupplierController supController = new SupplierController();
        CoffeeController coffeeController = new CoffeeController();
//
//        AddSupplierDTO newSupplier =
//                new AddSupplierDTO("São Braz", "projetada", "joão pessoa", "PB", "58000");
//        supController.add(newSupplier);
//         supController.view(5L);
//        supController.viewList();
//
//        UpdateSupplierDTO updateSupplier =
//                new UpdateSupplierDTO(
//                        5L, "Santa Clara","rua 1",
//                        "nomeada", "BR", "70000"
//                );
//        supController.update(updateSupplier);
//        supController.delete(5L);
//
//        AddCoffeeDTO newCoffee = new AddCoffeeDTO("Família", 0L, 13.99, 0, 0);
//        coffeeController.add(newCoffee);
//
//
//        coffeeController.view("Família");
//        coffeeController.viewList();
//        UpdateCoffeeDTO updateCoffee = new UpdateCoffeeDTO("Família", 8L, 19.99, 0, 0 );
//        coffeeController.update(updateCoffee);
//        coffeeController.view("Família");
//        coffeeController.delete("Família");
    }
}