package api;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.*;

public class DatabaseConnection {

    private OracleDataSource ods;
    private Connection conn;

    public DatabaseConnection(String url, String username, String password) {
        try {
            ods = new OracleDataSource();
            ods.setURL(url);
            conn = ods.getConnection(username, password);
            if (conn != null) {
                System.out.println("Successfully connected to the DB.");
            } else {
                System.out.println("Failed to connect to DB.");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e
                    .getMessage());

        }
    }

    public Connection getConnection() {
        return conn;
    }
}
