package com.ideao.dev.javadatabase.view;

import com.ideao.dev.javadatabase.model.entity.Supplier;

import java.util.List;

public class SupplierView {

    public void viewList(String out) {
        System.out.println(out);
    }

    public void viewJson(List<Supplier> suppliers) {
        for (Supplier sup: suppliers) {
            System.out.println("{");
            System.out.println("\t\"id\": " + sup.getId());
            System.out.println("\t\"name\": \"" +sup.getName() + "\"");
            System.out.println("\t\"street\": \"" + sup.getStreet() + "\"");
            System.out.println("\t\"city\": \""+ sup.getCity() + "\"");
            System.out.println("\t\"city\": \"" + sup.getState() + "\"");
            System.out.println("\t\"zip\": \"" + sup.getZip() + "\"");
            System.out.println("}");
        }
    }

    public void viewDetail(Supplier supplier) {
        System.out.println(supplier);
    }
}
