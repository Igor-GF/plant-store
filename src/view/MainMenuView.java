package view;

import model.Bestelling;
import repository.BestellingRepository;

import java.util.Scanner;

public final class MainMenuView {

    public static void toonMainMenu() {
        System.out.print("\n=======================================================");
        System.out.printf("\n%1$-15s %2$-20s %3$16s", "|", "WELKOM BIJ PLANTENLUST", "|");
        System.out.print("\n=======================================================");
        System.out.print("\nTyp 1 om alle LEVERANCIERS te tonen (druk dan op ENTER): ");

        int keuze = getKeus();

        controleerKeuze(keuze);
    }

    private static void volgendeMenu(String volgendeOptie) {
        System.out.print("\n=======================================================");
        System.out.println("\n-> Typ 1 om de Leverancierslijst weer te tonen. \n" + volgendeOptie);

        int keuze = getKeus();

        if (keuze == 1) {
            toonMainMenu();
        } else {
            controleerKeuze(keuze);
        }
    }

    private static int getKeus() {
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

    private static String getStatusInvoer() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static void controleerKeuze(int keuze) {

        switch (keuze) {
            case 1 -> {
                LeverancierView.toonLeveranciers();
                volgendeMenu("-> Typ 2 om de Bestellingen van een Leverancier te tonen.");
            }
            case 2 -> {
                System.out.print("\nTYP DE LEVERANCIER CODE (druk op enter): ");
                BestellingView.toonBestellingenVanLeverancier(getKeus());
                volgendeMenu("-> Typ 3 om Bestelregels van een Bestelling te tonen. \n-> Typ 33 om een Bestellingsstatus aan te passen.");
            }
            case 3 -> {
                System.out.print("\nTYP DE BESTELNUMMER (druk op enter): ");
                BestelregelView.toonRegelsVanBestelling(getKeus());
                volgendeMenu("-> Typ 4 om een Product te tonen.");
            }
            case 33 -> {
                System.out.print("\nTYP DE BESTELNUMMER (druk op enter): ");
                int bestelNr = getKeus();
                System.out.print("\nTYP DE NIEUWE STATUS: ");
                String status = getStatusInvoer();
                BestellingRepository repo = new BestellingRepository();
                repo.updateBestelStatusByNr(bestelNr, status);
                Bestelling b = repo.getBestelling(bestelNr);
                BestellingView.toonHoofding();
                BestellingView.toonBestelling(b);
                volgendeMenu("-> Typ 5 om het programma af te sluiten.");
            }
            case 4 -> {
                System.out.println("\nTYP DE ART. CODE (druk op enter): ");
                ProductView.toonProduct(getKeus());
                volgendeMenu("-> Typ 5 om het programma af te sluiten.");
            }
            case 5 -> System.out.println("PROGRAMMA IS BEËINDIGD!");
            default -> System.out.println("Ongeldige keuze. Kies een getal uit de lijst.");
        };
    }
}
