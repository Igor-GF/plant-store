package model;

import java.util.ArrayList;

public class Klant {
    private int klCode;
    private String naam;

    public Klant(int klCode, String naam) {
        setKlCode(klCode);
        setNaam(naam);
    }

    private void setKlCode(int klCode) {
        this.klCode = klCode;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getKlCode() {
        return klCode;
    }

    public String getNaam() {
        return naam;
    }
}
