package com.company;

public class Producator implements Cloneable {
    private String denumire;
    private String localitate;
    private float pretVanzare;
    private final int codFiscal;

    public Producator(String denumire, String localitate, float pretVanzare, int codFiscal) {
        this.denumire = denumire;
        this.localitate = localitate;
        this.pretVanzare = pretVanzare;
        this.codFiscal = codFiscal;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getLocalitate() {
        return localitate;
    }

    public void setLocalitate(String localitate) {
        this.localitate = localitate;
    }

    public float getPretVanzare() {
        return pretVanzare;
    }

    public void setPretVanzare(float pretVanzare) {
        this.pretVanzare = pretVanzare;
    }

    public int getCodFiscal() {
        return codFiscal;
    }

    @Override
    protected Producator clone() throws CloneNotSupportedException {
        Producator p = new Producator(this.clone().denumire, this.clone().localitate, this.clone().pretVanzare, this.clone().codFiscal);
        return p;
    }

    @Override
    public String toString() {
        return "Producator{" +
                "denumire='" + denumire + '\'' +
                ", localitate='" + localitate + '\'' +
                ", pretVanzare=" + pretVanzare +
                ", codFiscal=" + codFiscal +
                '}';
    }
}
