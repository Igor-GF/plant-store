package repository;

import databaseAccess.DerbyConnection;
import model.Bestelling;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public final class BestellingRepository extends Repository {

    private static final List<Bestelling> bestellingen = new ArrayList<>();
    private static final String query = "select * from bestellingen";

    private static void setRepository() {
        List<String[]> dataSet = DerbyConnection.getRows(query);

        if (dataSet != null) {
            dataSet.forEach(data -> bestellingen.add(mapToModel(data)));
        }
    }
    public static List<Bestelling> getBestellingenByLevCode(int levCode) {
        if (bestellingen.size() == 0) setRepository();

        ArrayList<Bestelling> bestellingenVanLeverancier = new ArrayList<>();

        for (Bestelling b: bestellingen) {
            if (levCode == b.getLevCode()) bestellingenVanLeverancier.add(b);
        }

        return bestellingenVanLeverancier.size() > 0 ? bestellingenVanLeverancier : null;
    }

    private static Bestelling mapToModel(String[] rij) {

        return new Bestelling(
                parseStringIntoInteger(rij[0]),
                parseStringIntoInteger(rij[1]),
                parseStringIntoDate(rij[2]),
                parseStringIntoDate(rij[3]),
                parseStringIntoDouble(rij[4].replace(",", ".")),
                parseStringIntoChar(rij[5])
        );
    }
}
