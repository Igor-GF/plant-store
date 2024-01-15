package repository;

import databaseAccess.DerbyConnection;
import model.Toebehoren;

import java.util.ArrayList;
import java.util.List;

public final class ToebehorenRepository extends Repository {
    private static final ArrayList<Toebehoren> toebehorenList = new ArrayList<>();
    private static final String query = "select * from toebehoren";

    private static void setRepository() {
        List<String[]> dataSet = DerbyConnection.getRows(query);

        if (dataSet != null) {
            dataSet.forEach(data -> toebehorenList.add(mapToModel(data)));
        }
    }

    public static Toebehoren getToebehoren(int artCode) {
        if (toebehorenList.size() == 0) setRepository();

        for (Toebehoren t: toebehorenList) {
            if (t.getArtCode() == artCode) return t;
        }
        return null;
    }

    private static Toebehoren mapToModel(String[] rij) {
        return new Toebehoren(
                parseStringIntoInteger(rij[0]),
                rij[1],
                rij[2],
                parseStringIntoChar(rij[3]),
                rij[4],
                parseStringIntoDouble(rij[5]),
                rij[6],
                rij[7],
                parseStringIntoDouble(rij[8]),
                rij[9],
                parseStringIntoDouble(rij[10]),
                parseStringIntoInteger(rij[11]),
                parseStringIntoInteger(rij[12])
        );
    }
}
