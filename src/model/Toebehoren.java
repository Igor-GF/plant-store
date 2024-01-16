package model;

import enums.SoortProduct;

public class Toebehoren extends Product {
    private String omschrijving; // 		varchar(50) not null,
    private char btwtype; // 			char(1) ,
    private String afmeting; // 			varchar(100),
    private double gewicht; // 			decimal(8,3),
    private String gewicht_eenheid; // 	varchar(20),
    private String verpakking; 		//	varchar(50),
    private double garantie; 		//	decimal(4,2),
    private String materiaal;		//	varchar(50),

    public Toebehoren(int artCode, String omschrijving, String kleur, double prijs, char btwtype, String afmeting,
                      double gewicht, String gewicht_eenheid, String verpakking, double garantie,
                      String materiaal, int vrrAantal, int vrrMin) {
        super(artCode, kleur, prijs, vrrAantal, vrrMin, SoortProduct.TOEBEHOREN);
        this.omschrijving = omschrijving;
        this.btwtype = btwtype;
        this.afmeting = afmeting;
        this.gewicht = gewicht;
        this.gewicht_eenheid = gewicht_eenheid;
        this.verpakking = verpakking;
        this.garantie = garantie;
        this.materiaal = materiaal;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public char getBtwtype() {
        return btwtype;
    }

    public void setBtwtype(char btwtype) {
        this.btwtype = btwtype;
    }

    public String getAfmeting() {
        return afmeting;
    }

    public void setAfmeting(String afmeting) {
        this.afmeting = afmeting;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public String getGewicht_eenheid() {
        return gewicht_eenheid;
    }

    public void setGewicht_eenheid(String gewicht_eenheid) {
        this.gewicht_eenheid = gewicht_eenheid;
    }

    public String getVerpakking() {
        return verpakking;
    }

    public void setVerpakking(String verpakking) {
        this.verpakking = verpakking;
    }

    public double getGarantie() {
        return garantie;
    }

    public void setGarantie(double garantie) {
        this.garantie = garantie;
    }

    public String getMateriaal() {
        return materiaal;
    }

    public void setMateriaal(String materiaal) {
        this.materiaal = materiaal;
    }
}
