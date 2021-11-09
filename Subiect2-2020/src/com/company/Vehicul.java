package com.company;

import java.util.Comparator;

public abstract class Vehicul implements Comparable<Vehicul> {
    private String tip;
    private boolean areMotor;
    private int nrRoti;

    public Vehicul(String tip, boolean areMotor, int nrRoti) {
        this.tip = tip;
        this.areMotor = areMotor;
        this.nrRoti = nrRoti;
    }

    public abstract void porneste();

    @Override
    public String toString() {
        return "Vehicul{" +
                "tip='" + tip + '\'' +
                ", areMotor=" + areMotor +
                ", nrRoti=" + nrRoti +
                '}';
    }

    @Override
    public int compareTo(Vehicul v) {
        return Comparator.comparing(Vehicul::getTip)
                .thenComparing(Vehicul::getNrRoti)
                .compare(this, v);
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public boolean isAreMotor() {
        return areMotor;
    }

    public void setAreMotor(boolean areMotor) {
        this.areMotor = areMotor;
    }

    public int getNrRoti() {
        return nrRoti;
    }

    public void setNrRoti(int nrRoti) throws PreaMulteRotiExceptie {
        if(nrRoti <= 8)
        this.nrRoti = nrRoti;
        else
            throw new PreaMulteRotiExceptie("Masina nu poate sa aiba " + nrRoti + " roti");
    }
}
