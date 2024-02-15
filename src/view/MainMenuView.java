package view;

import excepition.WaardeNietGevondenException;
import repository.BestellingRepository;
import repository.BestelregelRepository;

import java.util.ArrayList;
import java.util.Scanner;

public final class MainMenuView {

    private static int stateScherm = 1;
    private static int stateChoice = 0;
    private static int stateSecChoice = 0;

    public static void toonWelkomScherm() {
        System.out.print("\n=======================================================");
        System.out.printf("\n%1$-15s %2$-20s %3$16s", "|", "WELKOM BIJ PLANTENLUST", "|");
        System.out.print("\n=======================================================");
        System.out.println();

        toonSchermContent(stateScherm);
    }

    private static int getKeus() {
        Scanner sc = new Scanner(System.in);
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.printf(e.getMessage() + " terug naar Leveranciers ... \n");
        }
        return stateScherm;
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

    private static void toonSchermContent(int keuze) {

        switch (keuze) {
            case 0 -> System.out.println("\nPROGRAMMA IS BEËINDIGD!");
            case 1 -> {
                LeverancierView.toonLeveranciers();
                toonBottomMenu(keuze);
            }
            case 2 -> {
                System.out.print("\nTYP DE LEVERANCIER CODE (druk op enter): ");
                stateChoice = getInt();
                BestellingView.toonBestellingenVanLeverancier(stateChoice);
                toonBottomMenu(keuze);
            }
            case 3 -> {
                System.out.print("\nTYP DE BESTELNUMMER (druk op enter): ");
                stateChoice = getInt();
                BestelregelView.toonRegelsVanBestelling(stateChoice);
                toonBottomMenu(keuze);
            }
            case 33 -> {
                System.out.print("\nTYP DE BESTELNUMMER (druk op enter): ");
                int bestelNr = getInt();
                System.out.print("\nTYP DE NIEUWE STATUS: ");
                String status = getText();
                BestellingRepository repo = new BestellingRepository();
                repo.updateStatus(bestelNr, status);
                BestellingView.toonBestellingenVanLeverancier(stateChoice);
                toonBottomMenu(keuze);
            }
            case 4 -> {
                System.out.println("\nTYP DE ART. CODE (druk op enter): ");
                ProductView.toonProduct(getInt());
                toonBottomMenu(keuze);
            }
            case 44 -> {
                System.out.print("\nTYP DE ART. CODE (druk op enter): ");
                int artCode = getInt();
                System.out.print("\nPAS HET AANTAL AAN: ");
                int aantal = getInt();
                BestelregelRepository repo = new BestelregelRepository();
                repo.updateAantal(stateChoice, artCode, aantal);
                BestelregelView.toonRegelsVanBestelling(stateChoice);
                toonBottomMenu(keuze);
            }
            default -> System.out.println("Ongeldige keuze. Kies een getal uit de lijst.");
        };
    }

    private static void toonBottomMenu(int keuze) {
        System.out.print("\n=======================================================");
        stateScherm = keuze;
        ArrayList<Integer> opties = new ArrayList<>();
        opties.add(0);

        if (keuze != 1) {
            System.out.print("\nTyp 1 -> Terug naar Leverancierslijst.");
            opties.add(1);
        };
        switch (keuze) {
            case 1 -> {
                System.out.print("\nTyp 2 -> Bestellingen van een Leverancier.");
                opties.add(2);
            }
            case 2 -> {
                System.out.print("\nTyp 3 -> Bestelregels van een Bestelling. \nTyp 33 -> Bestellingsstatus aanpassen.");
                opties.add(3);
                opties.add(33);
            }
            case 3 -> {
                System.out.print("\nTyp 2 -> Bestellingen van een Leverancier. \nTyp 4 -> Product te tonen.\nTyp 44 -> Aantal aanpassen.");
                opties.add(2);
                opties.add(4);
                opties.add(44);
            }
            case 33 -> {
                System.out.print("\nTyp 3 -> Bestelregels van een Bestelling. \nTyp 33 -> Bestellingsstatus aanpassen.");
                opties.add(3);
            }
            case 4 -> {
                System.out.print("\nTyp 3 -> Bestelregels van een Bestelling. \nTyp 44 -> Aantal aanpassen bij de bestelregel " + stateChoice);
                opties.add(3);
                opties.add(44);
            }
            case 44 -> {
                System.out.print("\nTyp 4 -> Product tonen.\nTyp 44 -> Het aantal aanpassen.");
                opties.add(4);
                opties.add(44);
            }
        }
        System.out.print("\nTyp 0 -> Het programma afsluiten.");

        System.out.print("\n-> ");
        try {
            int tempKeuze = getKeus();
            if (controleerSubMenuOpties(tempKeuze, opties)) toonSchermContent(stateScherm = tempKeuze);
        } catch(WaardeNietGevondenException e) {
            System.out.println(e.getMessage() + "U moet een getal uit de lijst kiezen. Probeer opnieuw:");
            toonSchermContent(stateScherm);
        }

        opties.clear();
    }

    private static boolean controleerSubMenuOpties(int keuze, ArrayList<Integer> opties) throws WaardeNietGevondenException {
        if (opties.stream().anyMatch(k -> k == keuze)) return true;
        else throw new WaardeNietGevondenException("Ongeldige waarde! ");
    }
}
