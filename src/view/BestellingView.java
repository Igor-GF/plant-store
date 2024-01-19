package view;

import model.Bestelling;
import repository.BestellingRepository;
import repository.LeverancierRepository;

import java.util.List;

public class BestellingView {
    private static final BestellingRepository repo = new BestellingRepository();

    public static void toonBestellingenVanLeverancier(int levCode) {
        List<Bestelling> bestellingen = repo.getBestellingenByLevCode(levCode);

        if (bestellingen == null) {
            System.out.println("LEVERANCIER CODE " + levCode + " HEEFT GEEN BESTELLINGEN.");
        } else {
            System.out.println();
            System.out.println("OVERZICHT: Bestellingen van leverancier: " + levCode);
            System.out.println("---------------------------------------------------");
            toonHoofding();

            for (Bestelling b: bestellingen) {
                toonBestelling(b);
            }
        }
    }

    public static void toonBestelling(Bestelling b) {
        LeverancierRepository leverancierRepo = new LeverancierRepository();
        System.out.printf(
                "\n%1$-8s  %2$-8d  %3$-18s  %4$2td-%4$2tm-%4$4tY   %5$2td-%5$2tm-%5$4tY  %6$10.2f  %7$6s",
                b.getBestelNr(),
                b.getLevCode(),
                leverancierRepo.getLeverancierNaamByCode(b.getLevCode()),
                b.getBesteldat(),
                b.getLeverdat(),
                b.getBedrag(),
                b.getStatus()
        );
    }
    public static void toonHoofding() {
        System.out.printf("%1$-8s  %2$-8s  %3$-18s  %4$-10s   %5$-10s  %6$-10s  %7$-6s", "BESTELNR", "LEVCODE", "LEVNAAM", "BESTELDAT", "LEVERDAT", "BEDRAG", "STATUS");
        System.out.printf("\n%1$-8s  %2$-8s  %3$-18s  %4$-10s   %5$-10s  %6$-10s  %7$-6s", "--------", "--------", "----------", "----------", "----------", "----------", "------");
    }
}
