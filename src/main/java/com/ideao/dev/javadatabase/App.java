package com.ideao.dev.javadatabase;

import com.ideao.dev.javadatabase.controller.CoffeeController;
import com.ideao.dev.javadatabase.controller.SupplierController;
import com.ideao.dev.javadatabase.model.entity.Supplier;


public class App {
	public static void main(String[] args) {
		SupplierController supController = new SupplierController();
        CoffeeController coffeeController = new CoffeeController();

//      supController.viewList();
//      supController.add(new Supplier("Teste Ltda.","projetada", "joão pessoa", "PB", "58000" ));
        supController.delete();
        supController.viewList();

//        coffeeController.viewList();
//        supController.view();
//        supController.update();
        supController.view();
    }
}