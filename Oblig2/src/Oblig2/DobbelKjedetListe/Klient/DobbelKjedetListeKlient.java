package Oblig2.DobbelKjedetListe.Klient;

import Oblig2.DobbelKjedetListe.Kjedet.DobbelKjedetOrdnetListe;

public class DobbelKjedetListeKlient {
    public static void main(String[] args) {
        DobbelKjedetOrdnetListe liste = new DobbelKjedetOrdnetListe(-1, 10);

        liste.leggTil(2);
        liste.leggTil(10);
        liste.leggTil(4);
        liste.leggTil(1);
        liste.leggTil(6);

        System.out.print("Soek etter tall: ");
        System.out.println(liste.finn(6).getElement());
        System.out.print("Søk etter tall som ikke er i listen: ");
        System.out.println(liste.finn(3));
        System.out.println("Vis alle tallene i listen: ");
        liste.visListe();
        liste.fjern(6);
        System.out.println("Fjerner 6 fra listen");
        liste.visListe();
    }
}
