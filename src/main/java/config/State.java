package config;

import java.sql.SQLException;
import java.sql.Statement;

public class State {
    private static Statement statement;

    public static Statement getStatement() throws SQLException {
        if(statement==null){
            makeState();
        }
        return statement;
    }

    private static Statement makeState() throws SQLException {
        statement=new ConfigConnector().newConect().createStatement();
        return statement;
    }
}