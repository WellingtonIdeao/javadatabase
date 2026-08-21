package com.ideao.dev.javadatabase;

import com.ideao.dev.javadatabase.controller.CoffeeController;
import com.ideao.dev.javadatabase.controller.SupplierController;
import com.ideao.dev.javadatabase.model.entity.Supplier;


public class App {
	public static void main(String[] args) {
		SupplierController supController = new SupplierController();
        CoffeeController coffeeController = new CoffeeController();

//        supController.add(new Supplier("Teste Ltda.","projetada", "joão pessoa", "PB", "58000" ));
//        supController.view();
        supController.viewList();
//        supController.update();
//        supController.delete();

//        coffeeController.add();
        coffeeController.viewList();
//        coffeeController.view();
//        coffeeController.update();
//        coffeeController.delete();
    }
}