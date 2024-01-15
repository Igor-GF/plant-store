package view;

import model.Plant;
import repository.PlantRepository;

public final class PlantView {
    public static void toonPlant(int artCode) {
        Plant plantUitRepo = PlantRepository.getPlant(artCode);

        if (plantUitRepo == null) {
            System.out.println("ART. CODE " + artCode + " IS NIET GEVONDEN.");
        } else {
            System.out.println();
            toonHoofding();
            System.out.printf(
                    "\n%1$-8d  %2$-12s  %3$-12s  %4$-12s  %5$-12d  %6$-12d  %7$-12d  %8$-12.2f  %9$-12d  %10$-12d",
                    plantUitRepo.getArtCode(),
                    plantUitRepo.getPlantenNaam(),
                    plantUitRepo.getSoort(),
                    plantUitRepo.getKleur(),
                    plantUitRepo.getHoogte(),
                    plantUitRepo.getBloeiBeg(),
                    plantUitRepo.getBloeiEind(),
                    plantUitRepo.getPrijs(),
                    plantUitRepo.getVrrAantal(),
                    plantUitRepo.getVrrMin()
            );
        }
    }

    private static void toonHoofding() {
        System.out.printf(
            "%1$-8s  %2$-12s  %3$-12s  %4$-12s  %5$-12s  %6$-12s  %7$-12s  %8$-12s  %9$-12s  %10$-12s",
            "ARTCODE", "PLANTENNAAM", "SOORT", "KLEUR", "HOOGTE", "BLOEIBEG", "BLOEIEIND", "PRIJS", "VRR_AANTAL", "VRR_MIN"
        );
        System.out.printf(
            "\n%1$-8s  %2$-12s  %3$-12s  %4$-12s  %5$-12s  %6$-12s  %7$-12s  %8$-12s  %9$-12s  %10$-12s",
            "-------", "-------", "-------", "-------", "-------", "-------", "-------", "-------", "-------", "-------");
    }
}
