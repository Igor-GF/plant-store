package model;

import enums.BestelStatus;
import excepition.WaardeNietGevondenException;
import repository.BestelregelRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bestelling {
    private int bestelNr;
    private int levCode;
    private LocalDate besteldat;
    private LocalDate leverdat;
    private double bedrag;
    private BestelStatus status;

    private final ArrayList<Bestelregel> regels = new ArrayList<>();

    public Bestelling(int bestelNr, int levCode, LocalDate besteldat, LocalDate leverdat, BestelStatus status) {
        setBestelNr(bestelNr);
        setLevCode(levCode);
        setBesteldat(besteldat);
        setLeverdat(leverdat);
        setStatus(status);
        setRegels();
        calcBedrag();
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

    public void calcBedrag() {
        this.bedrag = this.regels.stream()
                .mapToDouble(r -> r.getAantal() * r.getBestelPrijs())
                .sum();
    }

    public BestelStatus getStatus() {
        return status;
    }

    public void setStatus(BestelStatus status) {
        this.status = status;
    }

    public ArrayList<Bestelregel> getRegels() {
        return regels;
    }

    public void setRegels() {
        BestelregelRepository regelsRepo = new BestelregelRepository();
        List<Bestelregel> regelsUitRepo = new ArrayList<>();
        try {
            regelsUitRepo = regelsRepo.getRegelsByBestelNr(this.bestelNr);
        } catch(WaardeNietGevondenException e) {
            System.out.println(e.getMessage());
        }
        if (regelsUitRepo.size() > 0) this.regels.addAll(regelsUitRepo);
    }

    public void addRegel(Bestelregel regel) {
        this.regels.add(regel);
    }
}
