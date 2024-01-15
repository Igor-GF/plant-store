package view;

import model.Bestelregel;
import repository.BestelregelRepository;
import repository.PlantRepository;

import java.util.List;

public class BestelregelView {
    public static void toonRegelsVanBestelling(int bestelNr) {
        List<Bestelregel> bestelregels = BestelregelRepository.getRegelsByBestelNr(bestelNr);

        if (bestelregels == null) {
            System.out.println("BESTELLING NUMMER " + bestelNr + " HEEFT GEEN BESTELLINGREGELS.");
        } else {
            System.out.println();
            System.out.println("OVERZICHT: Bestelregels van bestelling: " + bestelNr);
            System.out.println("---------------------------------------------------");
            toonHoofding();

            for (Bestelregel r: bestelregels) {
                toonRegel(r);
            }
        }
    }

    private static void toonRegel(Bestelregel r) {
        System.out.printf(
                "\n%1$-8s  %2$-8d  %3$-12s  %4$8d  %5$8.2f",
                r.getBestelNr(),
                r.getArtCode(),
                PlantRepository.getPlant(r.getArtCode()).getPlantenNaam(),
                r.getAantal(),
                r.getBestelPrijs()
        );
    }
    private static void toonHoofding() {
        System.out.printf("%1$-8s  %2$-8s  %3$-12s  %4$-8s  %5$-8s", "BESTELNR", "ARTCODE", "PLANTENNAAM", "AANTAL", "PRIJS");
        System.out.printf("\n%1$-8s  %2$-8s  %3$-12s  %4$-8s  %5$-8s", "--------", "--------", "--------", "--------", "---------");
    }
}
