package databaseAccess;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DerbyDataSource {
    private static Connection getConnection() {
        Properties props = new Properties();
        InputStream fis;
        Connection con = null;

        try {
            fis = DerbyDataSource.class.getClassLoader().getResourceAsStream("databaseaccess/db.properties");
            props.load(fis);

            con = DriverManager.getConnection(
                    props.getProperty("DERBY_DB_DBNAME"),
                    props.getProperty("DERBY_DB_USERNAME"),
                    props.getProperty("DERBY_DB_PASSWORD")
            );

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return con;
    }

    public static Statement getStatement() {
        try {
            return getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PreparedStatement getPreparedStatement(String query) {
        try {
            return getConnection().prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
