package Oblig2.DobbelKjedetListe.Kjedet;

import Oblig2.DobbelKjedetListe.Exceptions.EmptyCollectionException;
import Oblig2.DobbelKjedetListe.adt.DobbelKjedetOrdnetListeADT;

public class DobbelKjedetOrdnetListe<T extends Comparable<T>> implements DobbelKjedetOrdnetListeADT<T> {
    private DobbelNode<T> foerste;
    private DobbelNode<T> siste;
    private int antall;

    public DobbelKjedetOrdnetListe(T minVerdi, T maksVerdi) {
        // F�rste node
        DobbelNode<T> firstNode = new DobbelNode(minVerdi);
        // Siste node
        DobbelNode<T> lastNode = new DobbelNode(maksVerdi);
        // Kjeding
        foerste = firstNode;
        siste = lastNode;
        antall = 0;

        foerste.setNeste(siste);
        siste.setForrige(foerste);
        //TODO
    }

    @Override
    public void leggTil(T el) {
        DobbelNode<T> nyNode = new DobbelNode<T>(el);
        DobbelNode<T> aktuell = foerste.getNeste();
        while ((el.compareTo(aktuell.getElement()) > 0)) {
            aktuell = aktuell.getNeste();
        }
        nyNode.setNeste(aktuell);
        nyNode.setForrige(aktuell.getForrige());
        aktuell.getForrige().setNeste(nyNode);
        aktuell.setForrige(nyNode);
        antall++;

    }

    @Override
    public T fjern(T el) {
        T resultat = null;
        if (erTom())
            throw new EmptyCollectionException("dobbelkjedet ordnet liste er tom");
        DobbelNode<T> aktuell = finn(el);
        if (aktuell != null) {// returner og slett
            resultat = aktuell.getElement();
            aktuell.getForrige().setNeste(aktuell.getNeste());
            aktuell.getNeste().setForrige(aktuell.getForrige());

        }

        return resultat;

    }

    /*
     * Returnerer referansen til noden hvis el fins, ellers returneres
     * null-referansen
     */
    public DobbelNode<T> finn(T el) {
        DobbelNode<T> aktuell = foerste;
        boolean funnet = false;

        if(erTom()){
            throw new EmptyCollectionException("Listen er tom");
        } else{
            try{
                while(el.compareTo(aktuell.getElement()) != 0){
                    aktuell = aktuell.getNeste();
                }
            } catch (NullPointerException e){
                return null;
            }
        }

        return aktuell;
    }

    @Override
    public boolean erTom() {
        return (antall == 0);
    }

    @Override
    public int antall() {
        return antall;
    }

    public String toString() {
        String resultat = "";
        DobbelNode<T> aktuell = foerste.getNeste();
        while (aktuell != siste) {

            resultat = resultat + aktuell.getElement().toString();
            aktuell = aktuell.getNeste();
        }

        return resultat;
    }

    public String tilStrengBaklengs() {
        String resultat = "";
        DobbelNode<T> aktuell = siste.getForrige();
        while (aktuell != foerste) {

            resultat = resultat + aktuell.getElement().toString();
            aktuell = aktuell.getForrige();
        }

        return resultat;

    }

    public void visListe(){
        DobbelNode<T> aktuell = foerste.getNeste();
        for (int i = 0; i < antall; i++) {
            System.out.println(aktuell.getElement());
            aktuell = aktuell.getNeste();
        }
    }

}
