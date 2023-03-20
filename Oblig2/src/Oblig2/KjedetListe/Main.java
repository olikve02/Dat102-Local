package Oblig2.KjedetListe;

import Oblig2.KjedetListe.Kjedet.KjedetOrdnetListe;
import Oblig2.KjedetListe.adt.OrdnetListeADT;
import Oblig2.KjedetListe.tabell.TabellOrdnetListe;
import Oblig2.Person;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        KjedetOrdnetListe<Person> kjedetListe = new KjedetOrdnetListe<>();
        TabellOrdnetListe<Person> tabellListe = new TabellOrdnetListe<>(4);
        lesFraTastatur(tabellListe);
        lesFraTastatur(kjedetListe);

    }

    public static void lesFraTastatur(OrdnetListeADT listeType){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.print("Fornavn: ");
            String fornavn = scanner.nextLine();

            System.out.print("Etternavn: ");
            String etternavn = scanner.nextLine();

            System.out.print("Fødselsår: ");
            int fodselsår = Integer.parseInt(scanner.nextLine());
            listeType.leggTil(new Person(fornavn, etternavn, fodselsår));
        }
        listeType.skrivUt();
    }
}
