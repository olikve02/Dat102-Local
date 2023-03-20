package Oblig1.Klient;

import Oblig1.Enum.Sjanger;
import Oblig1.Film;
import Oblig1.adt.FilmarkivADT;

import java.util.Scanner;

public class Tekstgrensesnitt {
    Scanner scanner = new Scanner(System.in);

    // lese opplysningene om en FILM fra tastatur
    public Film lesFilm(FilmarkivADT filmer){
        String tittel = scanner.nextLine();
        return filmer.soekTittel(tittel)[0];
    }

    // vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void visFilm(Film film) {
        String resultat = "";
        resultat += "Film nr: " + film.getFilmnr() + "\n";
        resultat += "Tittel: " + film.getTittel() + "\n";
        resultat += "Produsent: " + film.getProdusent() + "\n";
        resultat += "Lanseringsår: " + film.getLanseringsår() + "\n";
        resultat += "Sjanger: " + film.getSjanger() + "\n";
        resultat += "Filmselskap: " + film.getFilmselskap() + "\n";
        System.out.println(resultat);
    }

    // Skrive ut alle Filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String tittel) {
        Film[] filmer = filma.soekTittel(tittel);
        for(Film film : filmer){
            System.out.println(film.getTittel());
        }

    }

    // Skriver ut alle Filmer av en produsent / en gruppe
    public void skrivUtFilmProdusent(FilmarkivADT filma, String produsent) {
        Film[] filmer = filma.soekProdusent(produsent);
        for(Film film : filmer){
            System.out.println(film.getProdusent());
        }
    }

    // Skrive ut en enkel statistikk som inneholder antall Filmer totalt
    // og hvor mange det er i hver sjanger
    public void skrivUtStatistikk(FilmarkivADT filma) {
        System.out.println("Antall filmer: " + filma.antall());
        System.out.println("Krim: " + filma.antall(Sjanger.KRIM));
        System.out.println("Komedie: " + filma.antall(Sjanger.KOMEDIE));
        System.out.println("Action: " + filma.antall(Sjanger.ACTION));
        System.out.println("Porno: " + filma.antall(Sjanger.PORNO));
    }
    // ... Ev. andre metoder

}