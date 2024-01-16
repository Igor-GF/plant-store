package repository;

import model.Leverancier;
import databaseAccess.DerbyConnection;

import java.util.ArrayList;
import java.util.List;

public class LeverancierRepository implements ParseInterface {
    private static final List<Leverancier> leveranciers = new ArrayList<>();
    private static final String query = "select * from Leveranciers";

    public void setRepository() {

        List<String[]> dataSet = DerbyConnection.getRows(query);

        if (dataSet != null) {
            dataSet.forEach(rij -> leveranciers.add(mapToModel(rij)));
        }
    }

    public List<Leverancier> getAlleLeveranciers() {
        if (leveranciers.size() == 0) setRepository();
        return leveranciers;
    }

    public String getLeverancierNaamByCode(int levCode) {
        if (leveranciers.size() == 0) setRepository();

        String levNaam = "";

        for (Leverancier l : leveranciers) {
            if (l.getLevCode() == levCode) {
                levNaam = l.getLevNaam();
                break;
            }
        }
        return levNaam;
    }

    private Leverancier mapToModel(String[] rij) {
        return new Leverancier(
                parseStringIntoInteger(rij[0]),
                rij[1],
                rij[2],
                rij[3]
        );
    }
}
