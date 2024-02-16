package repository;

import databaseAccess.DerbyConnection;
import enums.BestelStatus;
import excepition.WaardeNietGevondenException;
import model.Bestelling;

import java.util.ArrayList;
import java.util.List;

public class BestellingRepository extends Repository<Bestelling> {

    private static final String query = "select * from bestellingen";

    public void setRepository() {
        if(this.lijst.size() != 0) this.lijst.clear();
        ArrayList<Bestelling> list = setList(query);
        this.lijst.addAll(list);
    }

    public List<Bestelling> getBestellingenByLevCode(int levCode) throws WaardeNietGevondenException {
        ArrayList<Bestelling> bestellingenVanLeverancier = new ArrayList<>();

        setRepository();
        if (this.lijst.stream().noneMatch(lev -> lev.getLevCode() == levCode)) {
            throw new WaardeNietGevondenException("Leverancier " + levCode + " bestaat niet of heeft GEEN bestellingen. ");
        }

        for (Bestelling b : this.lijst) {
            if (levCode == b.getLevCode()) bestellingenVanLeverancier.add(b);
        }
        return bestellingenVanLeverancier;
    }

    public Bestelling getBestelling(int bestelNr) {
        setRepository();
        return this.lijst.stream()
                        .filter(b -> b.getBestelNr() == bestelNr)
                        .findFirst()
                        .orElse(null);
    }

    public void updateStatus(int bestelNr, String status) {
        String queryUpdate = "UPDATE bestellingen SET status= ? WHERE bestelnr= ";
        BestelStatus bestelStatus = parseStringIntoBestelStatus(status);
        if (DerbyConnection.update(queryUpdate + bestelNr, bestelStatus.name()) > 0) {
            setRepository(); // sets de repo met de nieuwe update uit de DB
        }
    }

    public void updateBedrag(int bestelNr) {
        String queryUpdate = "UPDATE bestellingen SET bedrag= ? WHERE bestelnr= ";
        Bestelling bestelling = getBestelling(bestelNr);
        bestelling.calcBedrag();
        int update = DerbyConnection.update(queryUpdate + bestelNr, String.valueOf(bestelling.getBedrag()));
        System.out.println(update);
        if (DerbyConnection.update(queryUpdate + bestelNr, String.valueOf(bestelling.getBedrag())) > 0) {
            setRepository(); // sets de repo met de nieuwe update uit de DB
        }
    }

    public Bestelling mapToModel(String[] rij) {
        return new Bestelling(
                parseStringIntoInteger(rij[0]),
                parseStringIntoInteger(rij[1]),
                parseStringIntoDate(rij[2]),
                parseStringIntoDate(rij[3]),
                parseStringIntoBestelStatus(rij[5])
        );
    }
}
