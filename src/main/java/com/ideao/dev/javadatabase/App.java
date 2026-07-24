package com.ideao.dev.javadatabase;

import com.ideao.dev.javadatabase.util.JdbcConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
	public static void main(String[] args) {
		try (Connection connection = JdbcConnection.getConnection()) {
			System.out.println("Hello World, Java database project");
		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
