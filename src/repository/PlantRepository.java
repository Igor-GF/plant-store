package repository;

import model.Plant;

import java.util.ArrayList;
import java.util.List;

public final class PlantRepository extends Repository<Plant> {
    private static final String query = "select * from planten";

    public void setRepository() {
        if(this.lijst.size() != 0) this.lijst.clear();
        ArrayList<Plant> list = setList(query);
        this.lijst.addAll(list);
    }

    public Plant getPlant(int artCode) {
        if (this.lijst.size() == 0) this.setRepository();

        for (Plant p: this.lijst) {
            if (p.getArtCode() == artCode) return p;
        }
        return null;
    }

    public Plant mapToModel(String[] rij) {
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
