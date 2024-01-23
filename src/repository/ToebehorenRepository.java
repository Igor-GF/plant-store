package repository;

import model.Toebehoren;

import java.util.ArrayList;

public final class ToebehorenRepository extends Repository<Toebehoren> {

    private static final String query = "select * from toebehoren";

    public void setRepository() {
        if(this.lijst.size() != 0) this.lijst.clear();
        ArrayList<Toebehoren> list = setList(query);
        this.lijst.addAll(list);
    }

    public Toebehoren getToebehoren(int artCode) {
        if (this.lijst.size() == 0) setRepository();

        for (Toebehoren t: this.lijst) {
            if (t.getArtCode() == artCode) return t;
        }
        return null;
    }

    public Toebehoren mapToModel(String[] rij) {
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
