package com.ideao.dev.javadatabase.model.dao;

import com.ideao.dev.javadatabase.config.DatabaseConfig;
import com.ideao.dev.javadatabase.model.entity.Coffee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoffeeDaoJdbc implements GenericRepository<Coffee, String> {

    @Override
    public List<Coffee> viewList() {
        String sql = "SELECT name, sup_id, price, sales, total FROM coffee";
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

    }

    @Override
    public void update(Coffee coffee) {

    }

    @Override
    public Coffee read(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}