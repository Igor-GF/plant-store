package databaseAccess;

import java.util.List;

public interface Rows {
    static List<String[]> getRows(String query) {
        List<String[]> rows = DerbyConnection.getRows(query);
        return (rows);
    };
}
