package model;

public class Plant extends Product {
    private String plantenNaam;
    private String soort;
    private int hoogte;
    private int bloeiBeg;
    private int bloeiEind;

    public Plant(int artCode, String plantenNaam, String soort, String kleur, int hoogte, int bloeiBeg, int bloeiEind, double prijs, int vrrAantal, int vrrMin) {
        super(artCode, kleur, prijs, vrrAantal, vrrMin);
        this.setPlantenNaam(plantenNaam);
        this.setSoort(soort);
        this.setHoogte(hoogte);
        this.setBloeiBeg(bloeiBeg);
        this.setBloeiEind(bloeiEind);
    }

    public String getPlantenNaam() {
        return plantenNaam;
    }

    public void setPlantenNaam(String plantenNaam) {
        this.plantenNaam = plantenNaam;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

     public int getHoogte() {
        return hoogte;
    }

    public void setHoogte(int hoogte) {
        this.hoogte = hoogte;
    }

    public int getBloeiBeg() {
        return bloeiBeg;
    }

    public void setBloeiBeg(int bloeiBeg) {
        this.bloeiBeg = bloeiBeg;
    }

    public int getBloeiEind() {
        return bloeiEind;
    }

    public void setBloeiEind(int bloeiEind) {
        this.bloeiEind = bloeiEind;
    }

}
