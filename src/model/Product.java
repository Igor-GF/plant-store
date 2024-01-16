package model;

import enums.SoortProduct;

public abstract class Product {
    private int artCode;
    private String kleur;
    private double prijs;
    private int vrrAantal;
    private int vrrMin;

    private SoortProduct product;

    public Product(int artCode, String kleur, double prijs, int vrrAantal, int vrrMin, SoortProduct product) {
        this.setArtCode(artCode);
        this.setKleur(kleur);
        this.setPrijs(prijs);
        this.setVrrAantal(vrrAantal);
        this.setVrrMin(vrrMin);
        this.setProduct(product);
    }

    public int getArtCode() {
        return artCode;
    }

    public void setArtCode(int artCode) {
        this.artCode = artCode;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public int getVrrAantal() {
        return vrrAantal;
    }

    public void setVrrAantal(int vrrAantal) {
        this.vrrAantal = vrrAantal;
    }

    public int getVrrMin() {
        return vrrMin;
    }

    public void setVrrMin(int vrrMin) {
        this.vrrMin = vrrMin;
    }

    public SoortProduct getProduct() {
        return product;
    }

    public void setProduct(SoortProduct product) {
        this.product = product;
    }
}
