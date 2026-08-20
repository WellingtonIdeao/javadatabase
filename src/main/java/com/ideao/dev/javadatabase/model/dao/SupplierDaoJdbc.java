package com.ideao.dev.javadatabase.model.dao;

import com.ideao.dev.javadatabase.model.entity.Supplier;
import com.ideao.dev.javadatabase.config.DatabaseConfig;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoJdbc implements GenericRepository<Supplier, Long> {

    public List<Supplier> viewList() {
        String sql = "SELECT id, name, street, city, state, zip FROM supplier WHERE is_active = TRUE";
        List<Supplier> suppliers = new ArrayList<>();

        try (Connection con = DatabaseConfig.getConnection();
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
        String sql = "INSERT INTO supplier (name, street, city, state, zip) VALUES(?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, supplier.getName());
            pstmt.setString(2, supplier.getStreet());
            pstmt.setString(3, supplier.getCity());
            pstmt.setString(4, supplier.getState());
            pstmt.setString(5, supplier.getZip());
            pstmt.setBoolean(6, true);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Supplier supplier) {
        String sql = "UPDATE supplier SET name = ?, street = ?, city = ?, state = ?, zip = ? WHERE id = ? AND is_active";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, supplier.getName());
            pstmt.setString(2, supplier.getStreet());
            pstmt.setString(3, supplier.getCity());
            pstmt.setString(4, supplier.getState());
            pstmt.setString(5, supplier.getZip());
            pstmt.setLong(6, supplier.getId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Supplier read(Long id) {
        String sql = "SELECT * FROM supplier WHERE id = ? AND is_active";
        Supplier supplier = new Supplier();

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql) ) {
            pstmt.setLong(1, id);

           try (ResultSet rs = pstmt.executeQuery()) {
               while (rs.next()) {
                   supplier.setId(rs.getLong(1));
                   supplier.setName(rs.getString(2));
                   supplier.setStreet(rs.getString(3));
                   supplier.setCity(rs.getString(4));
                   supplier.setState(rs.getString(5));
                   supplier.setZip(rs.getString(6));
                   supplier.setActive(rs.getBoolean(7));
               }
           }
           return supplier;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "UPDATE supplier SET is_active = ? WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setBoolean(1, false);
            pstmt.setLong(2, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}