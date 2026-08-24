package com.ideao.dev.javadatabase.supplier;

import com.ideao.dev.javadatabase.supplier.dto.SupplierDTO;

import java.util.List;

public class SupplierView {

    public void viewJson(List<SupplierDTO> suppliersDTOs) {
        for (SupplierDTO sup : suppliersDTOs) {
            System.out.println("{");
            System.out.println("\t\"id\": " + sup.getId());
            System.out.println("\t\"name\": \"" + sup.getName() + "\"");
            System.out.println("\t\"street\": \"" + sup.getStreet() + "\"");
            System.out.println("\t\"city\": \"" + sup.getCity() + "\"");
            System.out.println("\t\"state\": \"" + sup.getState() + "\"");
            System.out.println("\t\"zip\": \"" + sup.getZip() + "\"");
            System.out.println("}");
        }
    }

    public void viewDetail(SupplierDTO supplierDTO) {
        if (supplierDTO != null) {
            System.out.println(supplierDTO);
        } else {
            System.out.println("Supplier não encontrado! Tente com outro id.");
        }
    }
}
