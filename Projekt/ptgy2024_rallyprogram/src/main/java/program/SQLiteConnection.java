package program;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class SQLiteConnection {
    private static final String CONNECTION_STRING = "jdbc:sqlite:DB.sqlite";

    private static final Logger log = LogManager.getLogger(SQLiteConnection.class);
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            return connection;
        }
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            log.info("Sikeres csatlakozás az adatbázishoz");
        } catch (SQLException ex) {
            log.error("Nem sikerült csatlakozni az adatbázishoz!", ex);
            throw ex;
        }

        return connection;
    }
}
