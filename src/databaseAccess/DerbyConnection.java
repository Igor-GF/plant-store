package databaseAccess;

import java.sql.*;
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

    public static int update(String queryUpdate, String kolom) {
        try ( PreparedStatement pstmt = DerbyDataSource.getPreparedStatement(queryUpdate) ) {
            assert pstmt != null;
            pstmt.setString(1, kolom);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }
}
