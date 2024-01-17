package view;

import model.Toebehoren;
import repository.ToebehorenRepository;

public final class ToebehorenView {
   private static final ToebehorenRepository repo = new ToebehorenRepository();

   public static void toonToebeheren(int artCode) {
       Toebehoren toebUitRepo = repo.getToebehoren(artCode);

       if (toebUitRepo == null) {
           System.out.println("ART. CODE " + artCode + " IS NIET GEVONDEN.");
       } else {
           System.out.println();
           toonHoofding();
           System.out.printf(
                   "\n%1$-8d  %2$-12s  %3$-12s  %4$-12.2f  %5$-12s  %6$-12s  %7$-12.2f  %8$-12.2f  %9$-12s  %10$-12.2f  %11$-12s  %12$-12d  %13$-12d",
                   toebUitRepo.getArtCode(),
                   toebUitRepo.getOmschrijving(),
                   toebUitRepo.getKleur(),
                   toebUitRepo.getPrijs(),
                   toebUitRepo.getBtwtype(),
                   toebUitRepo.getAfmeting(),
                   toebUitRepo.getGewicht(),
                   toebUitRepo.getVerpakking(),
                   toebUitRepo.getGarantie(),
                   toebUitRepo.getMateriaal(),
                   toebUitRepo.getVrrAantal(),
                   toebUitRepo.getVrrMin()
           );
       }
   }

    private static void toonHoofding() {
        System.out.printf(
                "%1$-8s  %2$-12s  %3$-12s  %4$-12s  %5$-12s  %6$-12s  %7$-12s  %8$-12s  %9$-12s  %10$-12s  %10$-12s  %10$-12s  %10$-12s",
                "ARTCODE", "OMSCHRIJVING", "KLEUR", "PRIJS", "BTW", "AFMETING", "GEWICHT", "GEW.EENHEID", "VERPAKKING", "GARANTIE", "MATERIAAL", "VRR_AANTAL", "VRR_MIN"
        );
        System.out.printf(
                "\n%1$-8s  %2$-12s  %3$-12s  %4$-12s  %5$-12s  %6$-12s  %7$-12s  %8$-12s  %9$-12s  %10$-12s  %10$-12s  %10$-12s  %10$-12s",
                "-------", "-------", "-------", "-------", "-------", "-------", "-------", "-------", "-------", "-------", "-------", "-------", "-------");
    }
}
