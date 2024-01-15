package repository;

import databaseAccess.DerbyConnection;
import model.Plant;

import java.util.ArrayList;
import java.util.List;

public final class PlantRepository extends Repository {
    private static ArrayList<Plant> planten = new ArrayList<>();
    private static final String query = "select * from planten";

    private static void setRepository() {
        List<String[]> dataSet = DerbyConnection.getRows(query);

        if (dataSet != null) {
            dataSet.forEach(data -> planten.add(mapToModel(data)));
        }
    }

    public static Plant getPlant(int artCode) {
        if (planten.size() == 0) setRepository();

        for (Plant p: planten) {
            if (p.getArtCode() == artCode) return p;
        }
        return null;
    }

    private static Plant mapToModel(String[] rij) {
        return new Plant(
                parseStringIntoInteger(rij[0]),
                rij[1],
                rij[2],
                rij[3],
                parseStringIntoInteger(rij[4]),
                parseStringIntoInteger(rij[5]),
                parseStringIntoInteger(rij[6]),
                parseStringIntoDouble(rij[7]),
                parseStringIntoInteger(rij[8]),
                parseStringIntoInteger(rij[9])
        );
    }
}
