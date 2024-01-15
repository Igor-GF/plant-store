package model;

public class Bestelregel {
    private int bestelNr;
    private int artCode;
    private int aantal;
    private double bestelPrijs;

    public Bestelregel(int bestelNr, int artCode, int aantal, double bestelPrijs) {
        setBestelNr(bestelNr);
        setArtCode(artCode);
        setAantal(aantal);
        setBestelPrijs(bestelPrijs);
    }

    public int getBestelNr() {
        return bestelNr;
    }

    public void setBestelNr(int bestelNr) {
        this.bestelNr = bestelNr;
    }

    public int getArtCode() {
        return artCode;
    }

    public void setArtCode(int artCode) {
        this.artCode = artCode;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public double getBestelPrijs() {
        return bestelPrijs;
    }

    public void setBestelPrijs(double bestelPrijs) {
        this.bestelPrijs = bestelPrijs;
    }
}
