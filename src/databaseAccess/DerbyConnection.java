package databaseAccess;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DerbyConnection implements Rows {

    private static final Statement stmt;

    static {
        stmt = DerbyDataSource.getStatement();
    }

    public static ArrayList<String[]> getRows(String query) {

        ArrayList<String[]> dataList = new ArrayList<>();

        try (ResultSet rSet = stmt.executeQuery(query)) {

            ResultSetMetaData metaData = rSet.getMetaData();

            while (rSet.next()) {
                String[] stringArr = new String[metaData.getColumnCount()];

                for (int col = 1; col <= metaData.getColumnCount(); col++) {
                    stringArr[col - 1] = rSet.getString(metaData.getColumnName(col));
                }

                dataList.add(stringArr);
            }

            return dataList;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
