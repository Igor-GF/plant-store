package repository;

import databaseAccess.DerbyConnection;
import model.Bestelregel;

import java.util.ArrayList;
import java.util.List;

public class BestelregelRepository implements ParseInterface {
    private static List<Bestelregel> regels = new ArrayList<>();
    private static final String query = "select * from bestelregels";

    private void setRepository() {
        List<String[]> dataSet = DerbyConnection.getRows(query);

        if (dataSet != null) {
            dataSet.forEach(data -> regels.add(mapToModel(data)));
        }
    }
    public List<Bestelregel> getRegelsByBestelNr(int bestelNr) {
        if (regels.size() == 0) setRepository();

        ArrayList<Bestelregel> regelsVanBestelling = new ArrayList<>();

        for (Bestelregel b: regels) {
            if (b.getBestelNr() == bestelNr) regelsVanBestelling.add(b);
        }

        return regelsVanBestelling.size() > 0 ? regelsVanBestelling : null;
    }

    private Bestelregel mapToModel(String[] rij) {
        return new Bestelregel(
                parseStringIntoInteger(rij[0]),
                parseStringIntoInteger(rij[1]),
                parseStringIntoInteger(rij[2]),
                parseStringIntoDouble(rij[3].replace(",", "."))
        );
    }
}
