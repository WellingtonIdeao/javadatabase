package com.ideao.dev.javadatabase.migrations;

import org.flywaydb.core.Flyway;

public class DBMigration {

    public static void apply() {
        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:./sample;AUTO_SERVER=TRUE", null, null).load();
        flyway.migrate();
    }
}


