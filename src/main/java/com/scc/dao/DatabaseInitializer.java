package com.scc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/** Ensures the application's required tables exist before the UI starts. */
public final class DatabaseInitializer {
    private DatabaseInitializer() { }

    public static void initialize() {
        String createUsers = """
                CREATE TABLE IF NOT EXISTS users (
                    id       INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT NOT NULL UNIQUE,
                    password TEXT NOT NULL,
                    roles    TEXT NOT NULL,
                    status   TEXT NOT NULL DEFAULT 'PENDING'
                )
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(createUsers);
        } catch (SQLException exception) {
            throw new IllegalStateException("Database initialization failed: " + exception.getMessage(), exception);
        }
    }
}
