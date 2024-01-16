package repository;

import databaseAccess.DerbyConnection;
import model.Leverancier;
import model.Toebehoren;

import java.util.ArrayList;
import java.util.List;

public final class ToebehorenRepository implements ParseInterface {
    private static final ArrayList<Toebehoren> toebehorenLijst = new ArrayList<>();
    private static final String query = "select * from toebehoren";

    private void setRepository() {
        List<String[]> dataSet = DerbyConnection.getRows(query);

        if (dataSet != null) {
            dataSet.forEach(data -> toebehorenLijst.add(mapToModel(data)));
        }
    }

    public List<Toebehoren> getAlleToebehoren() {
        if (toebehorenLijst.size() == 0) setRepository();
        return toebehorenLijst;
    }

    public Toebehoren getToebehoren(int artCode) {
        if (toebehorenLijst.size() == 0) setRepository();

        for (Toebehoren t: toebehorenLijst) {
            if (t.getArtCode() == artCode) return t;
        }
        return null;
    }

    private Toebehoren mapToModel(String[] rij) {
        return new Toebehoren(
                parseStringIntoInteger(rij[0]),
                rij[1],
                rij[2],
                parseStringIntoDouble(rij[3]),
                parseStringIntoChar(rij[4]),
                rij[5],
                parseStringIntoDouble(rij[6]),
                rij[7],
                rij[8],
                parseStringIntoDouble(rij[9]),
                rij[10],
                parseStringIntoInteger(rij[11]),
                parseStringIntoInteger(rij[12])
        );
    }
}
