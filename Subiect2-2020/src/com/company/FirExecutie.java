package com.company;

import java.util.List;
import java.util.Random;

public class FirExecutie extends Thread {
    List<Vehicul> vehicule;


    public FirExecutie(List<Vehicul> vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public void run() {
        Random r = new Random();
        int listSize = vehicule.size() > 10 ? 10 : vehicule.size();
        for(int i = 0; i < listSize; i++){
            int randomRoti = r.nextInt(12 - 4) + 4;
            try {
                vehicule.get(i).setNrRoti(randomRoti);
                System.out.println("Roti setate");
            } catch (PreaMulteRotiExceptie e) {
                e.printStackTrace();
            }
        }
    }
}
