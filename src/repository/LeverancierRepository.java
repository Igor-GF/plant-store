package repository;

import model.Leverancier;

import java.util.ArrayList;

public class LeverancierRepository extends Repository<Leverancier> {
    private static final String query = "select * from Leveranciers";

    public void setRepository() {
        if(this.lijst.size() != 0) this.lijst.clear();
        ArrayList<Leverancier> list = setList(query);
        this.lijst.addAll(list);
    }

    public String getLeverancierNaamByCode(int levCode) {
        if (this.lijst.size() == 0) setRepository();

        String levNaam = "";

        for (Leverancier l : this.lijst) {
            if (l.getLevCode() == levCode) {
                levNaam = l.getLevNaam();
                break;
            }
        }
        return levNaam;
    }

    public Leverancier mapToModel(String[] rij) {
        return new Leverancier(
                parseStringIntoInteger(rij[0]),
                rij[1],
                rij[2],
                rij[3]
        );
    }
}
