package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ProdusAlimentar pa = new ProdusAlimentar("Carne", "UM", 30, "Carne Matache", "11.19.2021");
        ProdusAlimentar pa2 = new ProdusAlimentar("Pateu", "UM", 3, "Pateu Ardealu", "11.19.2021");
        ProdusAlimentar pa3 = new ProdusAlimentar("Parizer", "UM", 20, "Cristim", "11.19.2021");
        pa.getProducatori().add(new Producator("Carrefour", "Bucuresti",30.50f, 2232));
        pa.getProducatori().add(new Producator("Penny", "Filiasi",30.50f, 2232));
        pa.getProducatori().add(new Producator("Selgros", "Craiova",30.50f, 2232));
        pa.getProducatori().add(new Producator("Mega Image", "Bucuresti",30.50f, 2232));

        pa2.getProducatori().add(new Producator("Producator Mata", "Bucuresti", 50f, 231));
        pa2.getProducatori().add(new Producator("Producator Mata2", "Bucuresti", 30f, 231));
        pa2.getProducatori().add(new Producator("Producator Mata3", "Bucuresti", 20f, 231));

        pa3.getProducatori().add(new Producator("Producator Tactu", "Bucuresti", 120f, 124));
        pa3.getProducatori().add(new Producator("Producator Tactu2", "Bucuresti", 110f, 124));
        pa3.getProducatori().add(new Producator("Producator Tactu3", "Bucuresti", 100f, 124));

        List<ProdusAlimentar> produseList = new ArrayList<>();
        produseList.add(pa);
        produseList.add(pa2);
        produseList.add(pa3);

        produseList.sort(Produs::compareTo);
        System.out.println(produseList);

        System.out.println("--- PRETURI ---");
        for(ProdusAlimentar p : produseList){
            System.out.println(p.calculPretMediu("Bucuresti"));
            System.out.println("-------");
            System.out.println(p.genereazaDescriere());
        }

        try{
            File file = new File("date.txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for(ProdusAlimentar p : produseList){
               bw.write(p.toString() + "\n");
            }
            bw.close();
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        new FirExecutie(produseList).start();
        new FirExecutie(produseList).start();
    }
}
