package objects;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    public String id;

    public User(String id, String name, String family, String cityName, String date) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.cityName = cityName;
        this.date = date;
    }

    public String name, family, cityName, date;

    public User(ResultSet resultSet) {
        try {
            this.id = resultSet.getString("id");
            this.name = resultSet.getString("name");
            this.family = resultSet.getString("family");
            this.cityName = resultSet.getString("city");
            this.date = resultSet.getString("date");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}