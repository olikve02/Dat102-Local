package Oblig1.kjedet;

import Oblig1.Enum.Sjanger;
import Oblig1.Film;
import Oblig1.adt.FilmarkivADT;

public class FIlmarkiv2 implements FilmarkivADT {
    private int antall;
    LinearNode<Film> start;

    public FIlmarkiv2(){
        start = null;
        antall = 0;
    }

    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> aktuell = start;
        Film funnetFilm = null;
            for (int i = 0; i < antall; i++) {
                if(aktuell.getElement().getFilmnr() == nr){
                    funnetFilm = aktuell.getElement();
                }
                aktuell = aktuell.getNeste();
            }
        return funnetFilm;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> node = new LinearNode(nyFilm);
        node.setNeste(start);
        start = node;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode<Film> før = null;
        LinearNode<Film> etter = null;
        LinearNode<Film> aktuell = start;

        for (int i = 0; i < antall; i++) {
            if(aktuell.getNeste().getElement().getFilmnr() == filmnr){
                før = aktuell;
                etter = aktuell.getNeste();
            }
            aktuell = aktuell.getNeste();
        }
        før.setNeste(etter);
        aktuell.setNeste(null);


        return true;
    }
    /**
     * Søker og henter Filmer med en gitt delstreng i tittelen.
     * @param delstreng som må være i tittel
     * @return tabell med filmer som har delstreng i tittel
     */
    @Override
    public Film[] soekTittel(String delstreng) {
        LinearNode<Film> aktuell = start;
        int antallFilmer = 0;
        int filmerLagtTil = 0;
        for (int i = 0; i < antall; i++) {
            if(aktuell.getElement().getTittel().contains(delstreng)){
                antallFilmer++;
            }
            aktuell = aktuell.getNeste();
        }
        aktuell = start;
        Film[] nyFilmer = new Film[antallFilmer];

        for (int i = 0; i < antall; i++) {
            if(aktuell.getElement().getTittel().contains(delstreng)){
                nyFilmer[filmerLagtTil] = aktuell.getElement();
                filmerLagtTil++;
            }
            aktuell = aktuell.getNeste();
        }
        return nyFilmer;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        LinearNode<Film> aktuell = start;
        int antallFilmer = 0;
        int filmerLagtTil = 0;
        for (int i = 0; i < antall; i++) {
            if(aktuell.getElement().getProdusent().contains(delstreng)){
                antallFilmer++;
            }
            aktuell = aktuell.getNeste();
        }
        aktuell = start;
        Film[] nyFilmer = new Film[antallFilmer];

        for (int i = 0; i < antall; i++) {
            if(aktuell.getElement().getProdusent().contains(delstreng)){
                nyFilmer[filmerLagtTil] = aktuell.getElement();
                filmerLagtTil++;
            }
            aktuell = aktuell.getNeste();
        }
        return nyFilmer;
    }

    @Override
    public int antall(Sjanger sjanger) {
        LinearNode<Film> aktuell = start;
        int antallSjanger = 0;
        for (int i = 0; i < antall; i++) {
            if(aktuell.getElement().getSjanger().equals(sjanger)){
                antallSjanger++;
            }
            aktuell = aktuell.getNeste();
        }
        return antallSjanger;
    }

    @Override
    public int antall() {
        return antall;
    }
}
