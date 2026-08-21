package com.ideao.dev.javadatabase.model.dao;

import com.ideao.dev.javadatabase.config.DatabaseConfig;
import com.ideao.dev.javadatabase.model.entity.Coffee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoffeeDaoJdbc implements GenericRepository<Coffee, String> {

    @Override
    public List<Coffee> viewList() {
        String sql = "SELECT c.name AS name, c.sup_id AS sup_id, c.price AS price, c.sales AS sales, c.total AS total " +
                "FROM coffee c INNER JOIN supplier s ON c.sup_id = s.id WHERE c.is_active AND s.is_active";

        List<Coffee> coffees = new ArrayList<>();
        try (PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("name");
                long supId = rs.getInt("sup_id");
                double price = rs.getDouble("price");
                int sales = rs.getInt("sales");
                int total = rs.getInt("total");
                coffees.add(new Coffee(name, supId, price, sales, total));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return coffees;
    }

    @Override
    public void create(Coffee coffee) {
        String sql = "INSERT INTO coffee (name, sup_id, price, sales, total) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, coffee.getName());
            pstmt.setLong(2, coffee.getSupId());
            pstmt.setDouble(3, coffee.getPrice());
            pstmt.setInt(4, coffee.getSales());
            pstmt.setInt(5, coffee.getTotal());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Coffee coffee) {
        String sql = "UPDATE coffee SET sup_id = ?, price = ?, sales = ?, total = ? WHERE name = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
           pstmt.setLong(1, coffee.getSupId());
           pstmt.setDouble(2, coffee.getPrice());
           pstmt.setInt(3, coffee.getSales());
           pstmt.setInt(4, coffee.getTotal());
           pstmt.setString(5, coffee.getName());
           pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Coffee read(String id) {
        String sql = "SELECT * FROM coffee WHERE name = ? AND is_active";
        Coffee coffee = null;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement psmt = connection.prepareStatement(sql)) {
            psmt.setString(1, id);
            try (ResultSet rs = psmt.executeQuery()) {

                while (rs.next()) {
                    String name = rs.getString(1);
                    long supId = rs.getLong(2);
                    double price = rs.getDouble(3);
                    int sales = rs.getInt(4);
                    int total = rs.getInt(5);

                    coffee = new Coffee(name, supId, price, sales, total);
                }
                return coffee;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {
        String sql = "UPDATE coffee SET is_active = ? WHERE name = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setBoolean(1, false);
            pstmt.setString(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean existsById(String id) {
        String sql = "SELECT COUNT(*) FROM coffee WHERE name = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
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