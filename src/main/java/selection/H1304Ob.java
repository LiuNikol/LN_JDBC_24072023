package selection;

import config.State;
import objects.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class H1304Ob extends State {

    public static void printInfo() throws SQLException {
        ResultSet resultSet=getStatement().executeQuery("SELECT * FROM sys.h1303;");
        while (resultSet.next()){
            System.out.println(resultSet.getString("name") + " "+resultSet.getString("date"));
        }
    }

    public static void getUser(String name) throws SQLException {
        ResultSet resultSet=getStatement().executeQuery("SELECT * FROM sys.h1303 where name=\""+name+"\";");
        while (resultSet.next()){
            System.out.println(resultSet.getString("family") + " "+resultSet.getString("date"));
        }
    }
    public static boolean addUser(String name, String family, String cityName) throws SQLException {
        return getStatement().execute("INSERT INTO `sys`.`h1303` (`name`, `family`, `city`) VALUES ('"+name+"', '"+family+"', '"+cityName+"');");
    }
    public static List<User> getUserObjects(String name)  {
        ResultSet resultSet= null;
        List<User> list=new ArrayList<>();
        try {
            resultSet = getStatement().executeQuery("SELECT * FROM sys.h1303 where name=\""+name+"\";");


            while (resultSet.next()){
                list.add(new User(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static String getNameFamilyDateById(String userId) {
        String result = "";
        try {
            ResultSet resultSet = getStatement().executeQuery("SELECT name, family, date FROM sys.h1303 WHERE id = '" + userId + "';");
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String family = resultSet.getString("family");
                String date = resultSet.getString("date");
                result = name + " " + family + " " + date;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<String> getNamesAndFamiliesWithSameCity(String cityName) {
        List<String> namesAndFamilies = new ArrayList<>();
        try {
            ResultSet resultSet = getStatement().executeQuery("SELECT name, family FROM sys.h1303 WHERE city = '" + cityName + "';");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String family = resultSet.getString("family");
                namesAndFamilies.add(name + " " + family);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return namesAndFamilies;
    }
}