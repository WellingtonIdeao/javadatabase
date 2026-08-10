package com.ideao.dev.javadatabase.model.dao;

import com.ideao.dev.javadatabase.model.entity.Supplier;
import com.ideao.dev.javadatabase.util.JdbcConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoJdbc implements SupplierDAO {

    public List<Supplier> viewList() {
        String sql = "SELECT id, name, street, city, state, zip FROM supplier";
        List<Supplier> suppliers = new ArrayList<>();

        try (Connection con = JdbcConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String street = rs.getString("street");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String zip = rs.getString("zip");

                Supplier supplier = new Supplier(name, street, city, state, zip);
                supplier.setId(id);
                suppliers.add(supplier);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return suppliers;
    }

    @Override
    public void create(Supplier supplier) {
        String sql = "INSERT INTO supplier (name, street, city, state, zip) VALUES(?, ?, ?, ?, ?)";

        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, supplier.getName());
            pstmt.setString(2, supplier.getStreet());
            pstmt.setString(3, supplier.getCity());
            pstmt.setString(4, supplier.getState());
            pstmt.setString(5, supplier.getZip());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Supplier supplier) {

    }

    @Override
    public void read(long id) {

    }

    @Override
    public void delete(long id) {

    }
}