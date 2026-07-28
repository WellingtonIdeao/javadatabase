package com.ideao.dev.javadatabase;

import com.ideao.dev.javadatabase.util.JdbcConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
	public static void main(String[] args) {
		try (Connection con = JdbcConnection.getConnection();
			 Statement stmt = con.createStatement()) {
			System.out.println("Hello World, Java database project");
			stmt.executeUpdate("drop table if exists person");
			stmt.executeUpdate("create table person (id integer, name string)");
			stmt.executeUpdate("insert into person values (1, 'Guga')");
			stmt.executeUpdate("insert into person values (2, 'José')");
			ResultSet rs = stmt.executeQuery("select * from person");

			while (rs.next()) {
				System.out.print("id = " + rs.getInt("id"));
				System.out.println(", name = " + rs.getString("name"));
			}
		} catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcConnection.closePool();
        }
    }
}
