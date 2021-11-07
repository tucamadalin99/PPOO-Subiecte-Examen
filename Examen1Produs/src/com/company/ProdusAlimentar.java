package com.company;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Parameter;

public class ProdusAlimentar extends Produs implements ICalcul{
    private final String denumireProdus;
    private String dataExpirare;
    private List<Producator> producatori;

    public ProdusAlimentar(String tipProdus, String unitateMasura, int cantitate, String denumireProdus, String dataExpirare) {
        super(tipProdus, unitateMasura, cantitate);
        this.denumireProdus = denumireProdus;
        this.dataExpirare = dataExpirare;
        this.producatori = new ArrayList<>();
    }

    public String getDenumireProdus() {
        return denumireProdus;
    }

    public String getDataExpirare() {
        return dataExpirare;
    }

    public void setDataExpirare(String dataExpirare) {
        this.dataExpirare = dataExpirare;
    }

    public List<Producator> getProducatori() {
        return producatori;
    }

    public void setProducatori(List<Producator> producatori) {
        this.producatori = producatori;
    }

    @Override
    public String genereazaDescriere() {
        String result = "";
        if(this.producatori != null && this.producatori.size() > 0)
        for(Producator p : this.producatori){
            result += p.toString();
            result += ", ";
        }
        result += " - ";
        result += this.getDenumireProdus() + " " + this.calculPretMediu(null);
        return result;
    }

    @Override
    public float calculPretMediu(String localitate) {
        float total = 0;
        if(localitate != null){
            if(this.producatori != null && this.producatori.size() > 0){
                for(Producator p : this.producatori){
                    if(p.getLocalitate().equalsIgnoreCase(localitate)){
                        total += p.getPretVanzare();
                    }
                }
            }
        }else{
            if(this.producatori != null && this.producatori.size() > 0){
                for(Producator p : this.producatori){
                    total += p.getPretVanzare();
                }
            }
        }

        return total/this.producatori.size();
    }

    @Override
    public String toString() {
        return "ProdusAlimentar{" +
                "denumireProdus='" + denumireProdus + '\'' +
                ", dataExpirare='" + dataExpirare + '\'' +
                ", producatori=" + producatori +
                '}';
    }

    public void vinde(int cantitate){
        if(cantitate < this.getCantitate()){
            this.setCantitate(this.getCantitate() - cantitate);
            System.out.println("Vandut");
        }else{
            System.out.println("Cantitate indisponibila");
        }
    }
}
