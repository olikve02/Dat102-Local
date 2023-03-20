package Oblig1.Klient;


import Oblig1.Tabell.Filmarkiv;
import Oblig1.adt.FilmarkivADT;

public class KlientFilmarkiv {

    public static void main(String[] args) {
        FilmarkivADT filma = new Filmarkiv(100);
        Meny meny = new Meny(filma);
        meny.start();
    }

}
