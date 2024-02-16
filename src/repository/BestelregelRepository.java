package repository;

import databaseAccess.DerbyConnection;
import excepition.WaardeNietGevondenException;
import model.Bestelregel;

import java.util.ArrayList;
import java.util.List;

public class BestelregelRepository extends Repository<Bestelregel> {
    private static final String query = "select * from bestelregels";

    public void setRepository() {
        if(this.lijst.size() != 0) this.lijst.clear();
        ArrayList<Bestelregel> list = setList(query);
        this.lijst.addAll(list);
    }

    public List<Bestelregel> getRegelsByBestelNr(int bestelNr) throws WaardeNietGevondenException {
        ArrayList<Bestelregel> regelsVanBestelling = new ArrayList<>();

        setRepository();
        if (this.lijst.stream().noneMatch(br -> br.getBestelNr() == bestelNr)) {
            throw new WaardeNietGevondenException("Bestel nummer " + bestelNr + " bestaat niet of heeft GEEN bestelregels. ");
        }

        for (Bestelregel b: this.lijst) {
            if (b.getBestelNr() == bestelNr) regelsVanBestelling.add(b);
        }
        return regelsVanBestelling;
    }

    public Bestelregel getRegel(int bestelNr, int artCode) throws WaardeNietGevondenException {
        setRepository();
        List<Bestelregel> regelsByBestelNr = getRegelsByBestelNr(bestelNr);
        return regelsByBestelNr.stream()
                .filter(r -> r.getArtCode() == artCode)
                .findFirst()
                .orElse(null);
    }

    public void updateAantal(int bestelNr, int artCode, int aantal) {
        String queryUpdate = "UPDATE bestelregels SET aantal= ? WHERE bestelnr=" + bestelNr + " AND artcode=" + artCode;
        BestellingRepository bestellingRepo = new BestellingRepository();
        if (DerbyConnection.update(queryUpdate, String.valueOf(aantal)) > 0) {
            bestellingRepo.updateBedrag(bestelNr);
            setRepository(); // sets de repo met de nieuwe update uit de DB
        }
    }

    public Bestelregel mapToModel(String[] rij) {
        return new Bestelregel(
            parseStringIntoInteger(rij[0]),
            parseStringIntoInteger(rij[1]),
            parseStringIntoInteger(rij[2]),
            parseStringIntoDouble(rij[3].replace(",", "."))
        );
    }
}
