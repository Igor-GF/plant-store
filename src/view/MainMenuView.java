package view;

import repository.BestellingRepository;
import repository.BestelregelRepository;

import java.util.Scanner;

public final class MainMenuView {

    private static int stateMenu = 1;
    private static int stateChoice = 1;

    public static void toonMainMenu() {
        System.out.print("\n=======================================================");
        System.out.printf("\n%1$-15s %2$-20s %3$16s", "|", "WELKOM BIJ PLANTENLUST", "|");
        System.out.print("\n=======================================================");
        System.out.println();

        controleerKeuze(stateChoice);
    }

    private static int getKeus() {
        Scanner sc = new Scanner(System.in);
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.printf(e.getMessage() + " terug naar Leveranciers ... \n");
        }
        return stateMenu;
    }

    private static int getInt() {
        Scanner sc = new Scanner(System.in);
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.printf(e.getMessage());
        }
        return stateChoice;
    }

    private static String getText() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static void controleerKeuze(int keuze) {

        switch (keuze) {
            case 0 -> System.out.println("\nPROGRAMMA IS BEËINDIGD!");
            case 1 -> {
                LeverancierView.toonLeveranciers();
                keuzeMenu(keuze);
            }
            case 2 -> {
                System.out.print("\nTYP DE LEVERANCIER CODE (druk op enter): ");
                stateChoice = getInt();
                BestellingView.toonBestellingenVanLeverancier(stateChoice);
                keuzeMenu(keuze);
            }
            case 3 -> {
                System.out.print("\nTYP DE BESTELNUMMER (druk op enter): ");
                stateChoice = getInt();
                BestelregelView.toonRegelsVanBestelling(stateChoice);
                keuzeMenu(keuze);
            }
            case 33 -> {
                System.out.print("\nTYP DE BESTELNUMMER (druk op enter): ");
                int bestelNr = getInt();
                System.out.print("\nTYP DE NIEUWE STATUS: ");
                String status = getText();
                BestellingRepository repo = new BestellingRepository();
                repo.updateStatus(bestelNr, status);
                BestellingView.toonBestellingenVanLeverancier(stateChoice);
                keuzeMenu(keuze);
            }
            case 4 -> {
                System.out.println("\nTYP DE ART. CODE (druk op enter): ");
                ProductView.toonProduct(getInt());
                keuzeMenu(keuze);
            }
            case 44 -> {
                System.out.print("\nTYP DE ART. CODE (druk op enter): ");
                int artCode = getInt();
                System.out.print("\nPAS HET AANTAL AAN: ");
                int aantal = getInt();
                BestelregelRepository repo = new BestelregelRepository();
                repo.updateAantal(stateChoice, artCode, aantal);
                BestelregelView.toonRegelsVanBestelling(stateChoice);
                keuzeMenu(keuze);
            }
            default -> System.out.println("Ongeldige keuze. Kies een getal uit de lijst.");
        };
    }

    private static void keuzeMenu(int keuze) {
        System.out.print("\n=======================================================");

        if (keuze != 1) System.out.print("\nTyp 1 -> Terug naar Leverancierslijst.");
        stateMenu = keuze;
        switch (keuze) {
            case 1 -> System.out.print("\nTyp 2 -> Bestellingen van een Leverancier.");
            case 2 -> System.out.print("\nTyp 3 -> Bestelregels van een Bestelling.\nTyp 33 -> Bestellingsstatus aanpassen.");
            case 3 -> System.out.print("\nTyp 4 -> Product te tonen.\nTyp 44 -> Aantal aanpassen.");
            case 33 -> System.out.print("\nTyp 3 -> Bestelregels van een Bestelling. \nTyp 33 -> Bestellingsstatus aanpassen.");
            case 4 -> System.out.print("\nTyp 44 -> Aantal aanpassen bij de bestelregel " + stateChoice);
            case 44 -> System.out.print("\nTyp 4 -> Product tonen.\nTyp 44 -> Het aantal aanpassen.");
        }
        System.out.print("\nTyp 0 -> Het programma afsluiten.");

        System.out.print("\n-> ");
        controleerKeuze(getKeus());
    }
}
