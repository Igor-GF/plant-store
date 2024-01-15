package model;

public class Leverancier {
    private int levCode;
    private String levNaam;
    private String adres;
    private String woonplaats;

    public Leverancier() {}

    public Leverancier(int levCode, String levNaam, String adres, String woonplaats) {
        setLevCode(levCode);
        setLevNaam(levNaam);
        setAdres(adres);
        setWoonplaats(woonplaats);
    }

    public int getLevCode() {
        return levCode;
    }

    private void setLevCode(int levCode) {
        this.levCode = levCode;
    }

    public String getLevNaam() {
        return levNaam;
    }

    private void setLevNaam(String levNaam) {
        this.levNaam = levNaam;
    }

    public String getAdres() {
        return adres;
    }

    private void setAdres(String adres) {
        this.adres = adres;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    private void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }
}

