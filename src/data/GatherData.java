package data;

import model.Klant;
import model.Plant;

import java.util.ArrayList;

public class GatherData {
    private static ArrayList<Klant> klanten = new ArrayList<>();
    private static ArrayList<Plant> producten = new ArrayList<>();

    public static void addDBData() {
        DBData.addDBData();
    }
    public static ArrayList<Klant> getKlanten() {
        return klanten;
    }

    public static ArrayList<Plant> getProducten() {
        return producten;
    }
}
