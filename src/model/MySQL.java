package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQL {

    private static Connection connection;
    private static final String db = "hotelsystem";
    private static final String password = "VDD@frashmanvt21";
    private static final String host = "localhost";
    private static final String port = "3306";

    static {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db, "root", password);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ResultSet execute(String query) throws Exception {

        Statement statement = connection.createStatement();

        if (query.startsWith("SELECT")) {
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } else {
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            if (query.startsWith("INSERT")) {
                ResultSet resultSet = statement.getGeneratedKeys();
                return resultSet;
            } else {
                return null;
            }

        }

    }

    public static ResultSet search(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void iud(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}