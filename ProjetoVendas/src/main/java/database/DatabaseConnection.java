package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection getConnection() throws SQLException{
        String url     = "jdbc:postgresql://localhost:5433/postgres";
        String usuario = "postgres";
        String senha   = "123";
        
        return DriverManager.getConnection(url, usuario, senha);
    }
}