package com.company;

public class Autoturism extends Masina implements Cloneable,IMasina {
    private String model;
    private String culoare;
    private String caroserie;

    public Autoturism(String tip, boolean areMotor, int nrRoti, String marca, int capacitate, float pret, String model, String culoare, String caroserie) {
        super(tip, areMotor, nrRoti, marca, capacitate, pret);
        this.model = model;
        this.culoare = culoare;
        this.caroserie = caroserie;
    }

    @Override
    protected Autoturism clone() {
        Autoturism copie = null;
        try{
            Autoturism autoCopie = (Autoturism) super.clone();
            copie = new Autoturism(autoCopie.getTip(),
                    autoCopie.isAreMotor(), autoCopie.getNrRoti(),
                    autoCopie.getMarca(), autoCopie.getCapacitate(),
                    autoCopie.getPret(), autoCopie.model,
                    autoCopie.culoare, autoCopie.caroserie);

        }catch (Exception e){
            e.printStackTrace();
        }
        return copie;
    }

    @Override
    public String toString() {
        return "Autoturism{" +
                "model='" + model + '\'' +
                ", culoare='" + culoare + '\'' +
                ", caroserie='" + caroserie + '\'' +
                "} " + super.toString();
    }

    @Override
    public void porneste() {
        System.out.println("Vehiculul de tip: " + this.getTip() + " " + this.getMarca() + " " + this.model + " a pornit");
    }

    @Override
    public float calculeazaViteza(int km, float ore) {
        return km/ore;
    }
}
