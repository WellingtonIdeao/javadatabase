package com.ideao.dev.javadatabase.db;

import org.flywaydb.core.Flyway;

public class DBMigration {

    public static void apply() {
        Flyway flyway = Flyway.configure().dataSource("jdbc:sqlite:sample.db", null, null).load();
        flyway.migrate();
    }
}


