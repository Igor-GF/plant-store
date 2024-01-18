package view;

import model.Bestelling;
import repository.BestellingRepository;
import repository.BestelregelRepository;

import java.util.Scanner;

public final class MainMenuView {

    private static int state;

    public static void toonMainMenu() {
        System.out.print("\n=======================================================");
        System.out.printf("\n%1$-15s %2$-20s %3$16s", "|", "WELKOM BIJ PLANTENLUST", "|");
        System.out.print("\n=======================================================");
        System.out.print("\nTyp 1 om alle LEVERANCIERS te tonen (druk dan op ENTER): ");

        int keuze = getKeus();

        controleerKeuze(keuze);
    }

    private static void keuzeMenu(String volgendeOptie) {
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
                keuzeMenu("-> Typ 2 om de Bestellingen van een Leverancier te tonen.");
            }
            case 2 -> {
                System.out.print("\nTYP DE LEVERANCIER CODE (druk op enter): ");
                state = getKeus();
                BestellingView.toonBestellingenVanLeverancier(state);
                keuzeMenu("-> Typ 3 om Bestelregels van een Bestelling te tonen. \n-> Typ 33 om een Bestellingsstatus aan te passen.");
            }
            case 3 -> {
                System.out.print("\nTYP DE BESTELNUMMER (druk op enter): ");
                state = getKeus();
                BestelregelView.toonRegelsVanBestelling(state);
                keuzeMenu("-> Typ 4 om een Product te tonen.\n-> Typ 44 om het aantal aan te passen.");
            }
            case 33 -> {
                System.out.print("\nTYP DE BESTELNUMMER (druk op enter): ");
                int bestelNr = getKeus();
                System.out.print("\nTYP DE NIEUWE STATUS: ");
                String status = getStatusInvoer();
                BestellingRepository repo = new BestellingRepository();
                repo.updateBestelStatusByNr(bestelNr, status);
                Bestelling b = repo.getBestelling(bestelNr);
                BestellingView.toonBestellingenVanLeverancier(state);
                keuzeMenu("-> Typ 3 om Bestelregels van een Bestelling te tonen. \n-> Typ 33 om een Bestellingsstatus aan te passen.");
            }
            case 4 -> {
                System.out.println("\nTYP DE ART. CODE (druk op enter): ");
                ProductView.toonProduct(getKeus());
                keuzeMenu("-> Typ 5 om het programma af te sluiten.");
            }
            case 44 -> {
                System.out.print("\nTYP DE ART. CODE (druk op enter): ");
                int artCode = getKeus();
                System.out.print("\nPAS HET AANTAL AAN: ");
                int aantal = getKeus();
                BestelregelRepository repo = new BestelregelRepository();
                repo.updateRegelAantalBy(state, artCode, aantal);
                BestelregelView.toonRegelsVanBestelling(state);
                keuzeMenu("-> Typ 4 om een Product te tonen.\n-> Typ 44 om het aantal aan te passen.");
            }
            case 5 -> System.out.println("PROGRAMMA IS BEËINDIGD!");
            default -> System.out.println("Ongeldige keuze. Kies een getal uit de lijst.");
        };
    }
}
