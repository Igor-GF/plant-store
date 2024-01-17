package repository;

import databaseAccess.DerbyConnection;
import enums.BestelStatus;
import model.Bestelling;

import java.util.ArrayList;
import java.util.List;

public class BestellingRepository implements ParseInterface {

    private static final List<Bestelling> bestellingen = new ArrayList<>();
    private static final String query = "select * from bestellingen";
    private static final String queryUpdate = "UPDATE bestellingen SET status= ? WHERE bestelnr= ";

    private void setRepository() {
        List<String[]> dataSet = DerbyConnection.getRows(query);

        if (dataSet != null) {
            dataSet.forEach(data -> bestellingen.add(mapToModel(data)));
        }
    }
    public List<Bestelling> getBestellingenByLevCode(int levCode) {
        if (bestellingen.size() == 0) setRepository();

        ArrayList<Bestelling> bestellingenVanLeverancier = new ArrayList<>();

        for (Bestelling b: bestellingen) {
            if (levCode == b.getLevCode()) bestellingenVanLeverancier.add(b);
        }

        return bestellingenVanLeverancier.size() > 0 ? bestellingenVanLeverancier : null;
    }

    public Bestelling getBestelling(int bestelNr) {
        if (bestellingen.size() == 0) setRepository();
        return bestellingen.stream()
                .filter(b -> b.getBestelNr() == bestelNr)
                .findFirst()
                .orElse(null);
    }

    public void updateBestelStatusByNr(int bestelNr, String status) {
        BestelStatus bestelStatus = parseStringIntoBestelStatus(status);
        if (DerbyConnection.update(queryUpdate + bestelNr, bestelStatus.name()) > 0) {
            bestellingen.clear();
            setRepository(); // sets de repo met de nieuwe update uit de DB
            getBestelling(bestelNr);
        }
    }

    private Bestelling mapToModel(String[] rij) {
        return new Bestelling(
                parseStringIntoInteger(rij[0]),
                parseStringIntoInteger(rij[1]),
                parseStringIntoDate(rij[2]),
                parseStringIntoDate(rij[3]),
                parseStringIntoDouble(rij[4].replace(",", ".")),
                parseStringIntoBestelStatus(rij[5])
        );
    }
}
