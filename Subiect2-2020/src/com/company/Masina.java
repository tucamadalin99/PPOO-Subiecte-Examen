package com.company;

public abstract class Masina extends Vehicul {
    private String marca;
    private int capacitate;
    private float pret;

    public Masina(String tip, boolean areMotor, int nrRoti, String marca, int capacitate, float pret) {
        super(tip, areMotor, nrRoti);
        this.marca = marca;
        this.capacitate = capacitate;
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "marca='" + marca + '\'' +
                ", capacitate=" + capacitate +
                ", pret=" + pret +
                "} " + super.toString();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

}
