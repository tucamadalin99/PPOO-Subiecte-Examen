package com.company;

import java.util.Comparator;

public abstract class Produs implements Comparable<Produs> {

    private String tipProdus;
    private String unitateMasura;
    private int cantitate;

    public Produs(String tipProdus, String unitateMasura, int cantitate) {
        this.tipProdus = tipProdus;
        this.unitateMasura = unitateMasura;
        this.cantitate = cantitate;
    }

    public String getTipProdus() {
        return tipProdus;
    }

    public void setTipProdus(String tipProdus) {
        this.tipProdus = tipProdus;
    }

    public String getUnitateMasura() {
        return unitateMasura;
    }

    public void setUnitateMasura(String unitateMasura) {
        this.unitateMasura = unitateMasura;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public abstract String genereazaDescriere();

    @Override
    public int compareTo(Produs p) {
        return Comparator.comparing(Produs::getUnitateMasura)
                .thenComparing(Produs::getCantitate)
                .compare(this, p);
    }
}
