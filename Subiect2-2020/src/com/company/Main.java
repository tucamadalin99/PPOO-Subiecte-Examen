package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static float getPretMediuMasini(HashMap<String, Autoturism> colectieMap){
        int count = 0;
        float pretTotal = 0;
        for(Map.Entry<String, Autoturism> entry : colectieMap.entrySet()){
            pretTotal += entry.getValue().getPret();
            ++count;
        }
        return  pretTotal/count;
    }

    public static void main(String[] args) {
	// write your code here
        Map<String, Autoturism> map = new HashMap();
        Autoturism a1 = new Autoturism("Automobil", true, 4, "Dacia", 1400, 10000f, "Logan", "Rosu", "Berlina");
        Autoturism a2 = new Autoturism("Automobil", true, 4, "Kia", 2000, 15000f, "Ceed", "Negru", "Hatchback");
        Autoturism a3 = a1.clone();
        Autoturism a4 = new Autoturism("Automobil", true, 4, "Audi", 1800, 10000f, "A4", "Argintiu", "Berlina");
        Autoturism a5 = new Autoturism("Automobil", true, 4, "Dacia", 900, 10000f, "Sandero", "Rosu", "Hatchback");

        map.put("logan", a1);
        map.put("ceed", a2);
        map.put("loganCopie", a3);
        map.put("a4", a4);
        map.put("sandero", a5);

        System.out.println("PRET MEDIU: " + getPretMediuMasini((HashMap<String, Autoturism>) map));

        List<Vehicul> autoturismList = new ArrayList<>();
        Autoturism a6 = new Autoturism("Automobil", true, 4, "Dacia", 1100, 9000f, "Lodgy", "Maro", "Break");
        Autoturism a7 = new Autoturism("Automobil", true, 4, "Volkswagen", 1900, 19000f, "Golf", "Alb", "Hatchback");
        Autoturism a8 = new Autoturism("Transport", true, 6, "Opel", 1800, 20000f, "Sprinter", "Albastru", "Berlina");
        Autoturism a9 = new Autoturism("Curse", true, 4, "Opel", 1700, 8000f, "Astra", "Rosu", "Berlina");
        Autoturism a10 = a2.clone();

        autoturismList.add(a6);
        autoturismList.add(a7);
        autoturismList.add(a8);
        autoturismList.add(a9);
        autoturismList.add(a10);

        System.out.println("Lista nesortata: "+ autoturismList);
        System.out.println("---- SORTARE -----");
        autoturismList.sort(Vehicul::compareTo);
        System.out.println("Lista Sortata: " + autoturismList);
        System.out.println("--- APEL METODE ----");
        for(Vehicul v : autoturismList){
            v.porneste();
        }
        System.out.println(((Autoturism)autoturismList.get(0)).calculeazaViteza(100, 2.5f));
        System.out.println(((Autoturism)autoturismList.get(1)).calculeazaViteza(200, 2.5f));
        System.out.println(((Autoturism)autoturismList.get(2)).calculeazaViteza(300, 2.5f));
        System.out.println(((Autoturism)autoturismList.get(3)).calculeazaViteza(150, 2.5f));
        System.out.println(((Autoturism)autoturismList.get(4)).calculeazaViteza(180, 2.5f));

        File file = new File("masini.txt");
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Map.Entry<String, Autoturism> entry : map.entrySet()) {
                bw.write(entry.getValue().toString());
                bw.write("\n");
             }
            for(Vehicul v : autoturismList){
                bw.write(v.toString());
                bw.write("\n");
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("--- THREAD ---");
        new FirExecutie(autoturismList).start();
        new FirExecutie(autoturismList).start();
    }
}
