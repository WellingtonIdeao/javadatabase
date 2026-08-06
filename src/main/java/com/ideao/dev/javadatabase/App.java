package com.ideao.dev.javadatabase;

import com.ideao.dev.javadatabase.db.DBMigration;
import com.ideao.dev.javadatabase.util.CoffeeTable;
import com.ideao.dev.javadatabase.util.JdbcConnection;
import com.ideao.dev.javadatabase.util.SupplierTable;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
	public static void main(String[] args) {
		try (Connection con = JdbcConnection.getConnection()) {
			System.out.println("Hello World, Java database project");
			DBMigration.apply();

			SupplierTable st = new SupplierTable(con);
			CoffeeTable ct = new CoffeeTable(con);

//			st.populateTable();
//			ct.populateTable();

			st.viewTable();
			ct.viewTable();
//			ct.batchUpdate();

		} catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcConnection.closePool();
        }
    }
}
