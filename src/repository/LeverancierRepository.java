package repository;

import model.Leverancier;
import databaseAccess.DerbyConnection;

import java.util.ArrayList;
import java.util.List;

public final class LeverancierRepository extends Repository {
    private static final List<Leverancier> leveranciers = new ArrayList<>();
    private static final String query = "select * from Leveranciers";

    public static void setRepository() {

        List<String[]> dataSet = DerbyConnection.getRows(query);

        if (dataSet != null) {
            dataSet.forEach(data -> leveranciers.add(mapToModel(data)));
        }
    }

    public static List<Leverancier> getAlleLeveranciers() {
        if (leveranciers.size() == 0) setRepository();
        return leveranciers;
    }

    public static String getLeverancierNaamByCode(int levCode) {
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

    private static Leverancier mapToModel(String[] data) {
        return new Leverancier(
                parseStringIntoInteger(data[0]),
                data[1],
                data[2],
                data[3]
        );
    }
}
