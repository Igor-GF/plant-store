package view;

import java.util.Scanner;

public final class MainMenuView {

    public static void toonMainMenu() {
        System.out.print("\n=======================================================");
        System.out.printf("\n%1$-15s %2$-20s %3$16s", "|", "WELKOM BIJ PLANTENLUST", "|");
        System.out.print("\n=======================================================");
        System.out.println("\nTyp 1 om alle LEVERANCIERS te tonen (druk dan op ENTER)");

        int keuze = getKeus();

        controleerKeuze(keuze);
    }

    private static void volgendeMenu(String volgendeOptie) {
        System.out.print("\n=======================================================");
        System.out.println("\n-> Typ " + volgendeOptie + ".");
        System.out.println("-> Typ 1 om de Leverancierslijst weer te tonen. ");

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

    private static void controleerKeuze(int keuze) {

        switch (keuze) {
            case 1 -> {
                LeverancierView.toonLeveranciers();
                volgendeMenu("2 om de Bestellingen van een Leverancier te tonen");
            }
            case 2 -> {
                System.out.println("TYP DE LEVERANCIER CODE (druk op enter): ");
                int levCode = getKeus();
                BestellingView.toonBestellingenVanLeverancier(levCode);
                volgendeMenu("3 om Bestelregels van een Bestelling te tonen");
            }
            case 3 -> {
                System.out.println("TYP DE BESTELNUMMER (druk op enter): ");
                int bestelNr = getKeus();
                BestelregelView.toonRegelsVanBestelling(bestelNr);
                volgendeMenu("4 om Producten te tonen");
            }
            case 4 -> {
                System.out.println("TYP DE ART. CODE (druk op enter): ");
                int artCode = getKeus();
                ProductView.toonProduct(artCode);
                volgendeMenu("5 om het programma af te sluiten");
            }
            case 5 -> System.out.println("PROGRAMMA IS BEËINDIGD!");
            default -> System.out.println("Ongeldige keuze. Kies een getal uit de lijst.");
        };
    }
}
