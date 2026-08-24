package com.ideao.dev.javadatabase.supplier;

import com.ideao.dev.javadatabase.common.repository.GenericRepository;
import com.ideao.dev.javadatabase.common.database.DatabaseConfig;

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

                long id = rs.getInt("id");
                String name = rs.getString("name");
                String street = rs.getString("street");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String zip = rs.getString("zip");

                Supplier supplier = new Supplier(id, name, street, city, state, zip);
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

        try (Connection connection = DatabaseConfig.getConnection();
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
        String sql = "UPDATE supplier SET name = ?, street = ?, city = ?, state = ?, zip = ? WHERE id = ?";
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
        Supplier supplier = null;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql) ) {
            pstmt.setLong(1, id);

           try (ResultSet rs = pstmt.executeQuery()) {
               while (rs.next()) {
                   supplier = new Supplier();
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
        String updateSql = "UPDATE supplier SET is_active = ? WHERE id = ?";
        String updateCoffeeSql = "UPDATE coffee SET is_active = ? WHERE sup_id = ?";

        try (Connection connection = DatabaseConfig.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement updateActive = connection.prepareStatement(updateSql);
                 PreparedStatement updateCoffee = connection.prepareStatement(updateCoffeeSql)) {


                updateActive.setBoolean(1, false);
                updateActive.setLong(2, id);
                updateActive.executeUpdate();

                updateCoffee.setBoolean(1, false);
                updateCoffee.setLong(2, id);
                updateCoffee.executeUpdate();

                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException(e);
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean existsById(Long id) {
        String sql = "SELECT COUNT(*) FROM supplier WHERE id = ? AND is_active";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
           pstmt.setLong(1, id);

           try (ResultSet rs = pstmt.executeQuery()) {
               if(rs.next()) {
                   int total = rs.getInt(1);
                   return total > 0;
               }
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}