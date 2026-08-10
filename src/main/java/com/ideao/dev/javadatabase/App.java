package com.ideao.dev.javadatabase;

import com.ideao.dev.javadatabase.controller.CoffeeController;
import com.ideao.dev.javadatabase.controller.SupplierController;
import com.ideao.dev.javadatabase.migrations.DBMigration;
import com.ideao.dev.javadatabase.model.entity.Supplier;
import com.ideao.dev.javadatabase.util.JdbcConnection;


public class App {
	public static void main(String[] args) {
		DBMigration.apply();
		SupplierController supController = new SupplierController();
        CoffeeController coffeeController = new CoffeeController();

//      supController.viewList();
//      supController.add(new Supplier("Guga Ltda.","projetada", "joão pessoa", "PB", "58000" ));
        supController.viewList();

        coffeeController.viewList();
        JdbcConnection.closePool();
    }
}