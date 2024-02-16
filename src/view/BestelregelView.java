package view;

import excepition.WaardeNietGevondenException;
import model.Bestelregel;
import repository.BestelregelRepository;
import repository.ProductRepository;

import java.util.List;

public final class BestelregelView {
    private static final BestelregelRepository repo = new BestelregelRepository();

    public static void toonRegelsVanBestelling(int bestelNr) throws WaardeNietGevondenException {
        List<Bestelregel> bestelregels = repo.getRegelsByBestelNr(bestelNr);

        System.out.println();
        System.out.println("OVERZICHT: Bestelregels van bestelling: " + bestelNr);
        System.out.println("---------------------------------------------------");
        toonHoofding();

        for (Bestelregel r: bestelregels) toonRegel(r);
    }

    private static void toonRegel(Bestelregel r) {
        ProductRepository productRepo = new ProductRepository();
        System.out.printf(
                "\n%1$-8s  %2$-8d  %3$-12s  %4$8d  %5$8.2f",
                r.getBestelNr(),
                r.getArtCode(),
                productRepo.getProduct(r.getArtCode()).getProduct(),
                r.getAantal(),
                r.getBestelPrijs()
        );
    }
    private static void toonHoofding() {
        System.out.printf("%1$-8s  %2$-8s  %3$-12s  %4$-8s  %5$-8s", "BESTELNR", "ARTCODE", "PRODUCT", "AANTAL", "PRIJS");
        System.out.printf("\n%1$-8s  %2$-8s  %3$-12s  %4$-8s  %5$-8s", "--------", "--------", "--------", "--------", "---------");
    }
}
