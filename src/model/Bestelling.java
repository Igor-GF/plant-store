package model;

import enums.BestelStatus;

import java.time.LocalDate;

public class Bestelling {
    private int bestelNr;
    private int levCode;
    private LocalDate besteldat;
    private LocalDate leverdat;
    private double bedrag;
    private BestelStatus status;

    public Bestelling(int bestelNr, int levCode, LocalDate besteldat, LocalDate leverdat, double bedrag, BestelStatus status) {
        setBestelNr(bestelNr);
        setLevCode(levCode);
        setBesteldat(besteldat);
        setLeverdat(leverdat);
        setBedrag(bedrag);
        setStatus(status);
    }

    public int getBestelNr() {
        return bestelNr;
    }

    private void setBestelNr(int bestelNr) {
        this.bestelNr = bestelNr;
    }

    public int getLevCode() {
        return levCode;
    }

    private void setLevCode(int levCode) {
        this.levCode = levCode;
    }

    public LocalDate getBesteldat() {
        return besteldat;
    }

    private void setBesteldat(LocalDate besteldat) {
        this.besteldat = besteldat;
    }

    public LocalDate getLeverdat() {
        return leverdat;
    }

    public void setLeverdat(LocalDate leverdat) {
        this.leverdat = leverdat;
    }

    public double getBedrag() {
        return bedrag;
    }

    private void setBedrag(double bedrag) {
        this.bedrag = bedrag;
    }

    public BestelStatus getStatus() {
        return status;
    }

    public void setStatus(BestelStatus status) {
        this.status = status;
    }
}
