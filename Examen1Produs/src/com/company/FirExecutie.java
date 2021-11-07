package com.company;

import java.util.List;
import java.util.Random;

public class FirExecutie extends Thread{
    List<ProdusAlimentar> produseAlimentar;
    public FirExecutie(List<ProdusAlimentar> produseAlimentar) {
        this.produseAlimentar = produseAlimentar;
    }

    @Override
    public void run() {
        Random r = new Random();
        int listSize = produseAlimentar.size() > 10 ? 10 : produseAlimentar.size();
        for(int i = 0; i < listSize; i++){
            int randomCantitate = r.nextInt(100 - 10) + 10;
            produseAlimentar.get(i).vinde(randomCantitate);
        }
    }
}
