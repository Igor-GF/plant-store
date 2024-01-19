package view;

import model.Leverancier;
import repository.LeverancierRepository;

import java.util.List;

public final class LeverancierView {
    private static final LeverancierRepository repo = new LeverancierRepository();
    public static void toonLeveranciers() {
        List<Leverancier> leveranciers = repo.getAll();

        System.out.println();
        System.out.println("OVERZICHT: Lijst van alle leveranciers");
        System.out.println("--------------------------------------");
        toonHoofding();

        for (Leverancier l: leveranciers) {
            toonLeverancier(l);
        }
    }

    private static void toonLeverancier(Leverancier l) {
        System.out.printf("\n%1$-8s  %2$-20s  %3$-12s  %4$-40s", l.getLevCode(), l.getLevNaam(), l.getWoonplaats(), l.getAdres());
    }
    private static void toonHoofding() {
        System.out.printf("%1$-8s  %2$-20s  %3$-12s  %4$-40s", "LEVCODE", "LEVNAAM", "WOONPLAATS", "ADRES");
        System.out.printf("\n%1$-8s  %2$-20s  %3$-12s  %4$-40s", "-------", "-----------", "-----------", "-----------");
    }
}
