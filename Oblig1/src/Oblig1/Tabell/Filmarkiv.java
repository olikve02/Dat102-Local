package Oblig1.Tabell;

import Oblig1.Enum.Sjanger;
import Oblig1.Film;
import Oblig1.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
    Film[] filmer;
    private int antall;

    public Filmarkiv(int antall){
        filmer = new Film[antall];
        antall = 0;
    }

    @Override
    public Film finnFilm(int nr) {
        Film resultat = null;
        for(Film film : filmer){
            if(film.getFilmnr() == nr){
                resultat = film;
            }
        }
        return resultat;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if(antall == 0){
            filmer[0] = nyFilm;
        }else if(filmer.length == antall){
            utvid();
            filmer[antall] = nyFilm;
            trim();
        }else{
            filmer[antall] = nyFilm;
        }
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        boolean slettet = false;
        if(antall == 0){
            System.out.println("Listen er allerede tom");
        }else{
            for (int i = 0; i < filmer.length; i++) {
                if(filmer[i].getFilmnr() == filmnr){
                    filmer[i] = null;
                    slettet = true;
                    antall--;
                    trim();
                }
            }
        }
        return slettet;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] funnetFilmer = null;
        int antallFilmer = 0;
        int filmerLagtTil = 0;
        //Finn hvor mange filmer som har delstreng i tittelen
        for(Film film : filmer){
            if(film.getTittel().contains(delstreng)){
                antallFilmer++;
            }
        }
        //Hvis det er funnet filmer med delstreng i tittelen blir det lagt til i en ny tabell
        if(antallFilmer > 0){
            //Lager ny tabell med antall filmer
            funnetFilmer = new Film[antallFilmer];
            //Går igjennom alle filmene i filmarkivet og finner filmene med delstreng i tittelen og legger til i ny tabell
            for(Film film : filmer){
                if(film.getTittel().contains(delstreng)){
                    funnetFilmer[filmerLagtTil] = film;
                    filmerLagtTil++;
                }
            }
        }

        return funnetFilmer;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] funnetFilmer = null;
        int antallFilmer = 0;
        int filmerLagtTil = 0;
        //Finn hvor mange filmer som har delstreng i tittelen
        for(Film film : filmer){
            if(film.getProdusent().contains(delstreng)){
                antallFilmer++;
            }
        }
        //Hvis det er funnet filmer med delstreng i tittelen blir det lagt til i en ny tabell
        if(antallFilmer > 0){
            //Lager ny tabell med antall filmer
            funnetFilmer = new Film[antallFilmer];
            //Går igjennom alle filmene i filmarkivet og finner filmene med delstreng i tittelen og legger til i ny tabell
            for(Film film : filmer){
                if(film.getProdusent().contains(delstreng)){
                    funnetFilmer[filmerLagtTil] = film;
                    filmerLagtTil++;
                }
            }
        }

        return funnetFilmer;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int antallFilmer = 0;
        for(Film film : filmer){
            if(film.getSjanger().equals(sjanger)){
                antallFilmer++;
            }
        }
        return antallFilmer;
    }

    @Override
    public int antall() {
        return antall;
    }

    public void utvid(){
        Film[] nyFilmer = new Film[filmer.length * 2];
        for (int i = 0; i < filmer.length; i++) {
            nyFilmer[i] = filmer[i];
        }
        filmer = nyFilmer;
    }

    public void trim(){
        int antallNull = 0;
        for (int i = 0; i < filmer.length; i++) {
            if(filmer[i] == null){
                antallNull++;
            }
        }

        Film[] nyFilmer = new Film[filmer.length-antallNull];
        int teller = 0;

        for (int i = 0; i < filmer.length; i++) {
            if(filmer[i] == null){
                teller++;
            }else{
                nyFilmer[i-teller] = filmer[i];
            }
        }
        filmer = nyFilmer;
    }

    public void skrivUt(){
        for(Film film : filmer){
            System.out.println(film.getTittel());
        }
    }
    public void skrivUt(Film[] filmer){
        for(Film film : filmer){
            System.out.println(film.getTittel());
        }
    }
}
