package config;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigConnector {

    private Connection connection;
    public Connection newConect() throws SQLException {
        if(connection==null){
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
        }
        return connection;
    }
}