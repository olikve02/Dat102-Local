package Oblig2.KjedetListe.Kjedet;

import Oblig2.KjedetListe.adt.OrdnetListeADT;
import Oblig2.KjedetListe.Exceptions.EmptyCollectionException;
import Oblig2.Person;

/**
 * 
 * @param <T> elementypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		T resultat = null;



		return resultat;
	}

	@Override
	public T fjernSiste() {
		LinearNode<T> denne = foerste, forrige = null;
		T resultat;
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		else{
			while(denne!= null && siste.getElement().compareTo(denne.getElement()) > 0){
				forrige = denne;
				denne = denne.getNeste();
			}

			resultat = siste.getElement();
			if(antall == 1){
				foerste = null;
				siste = null;
			}else{
				forrige.setNeste(null);
				siste = forrige;
			}
			antall--;
		}
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T svar = foerste.getElement();

		return svar;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		return siste.getElement();
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {

		LinearNode<T> ny = new LinearNode(element);

		LinearNode<T> denne = foerste, forrige = null;

		while(denne != null && element.compareTo(denne.getElement()) > 0){
			forrige = denne;
			denne = denne.getNeste();
		}
		if(antall == 0){
			foerste = ny;
			siste = ny;
		} else if (forrige == null){
			foerste = ny;
			ny.setNeste(denne);
		}else{
			forrige.setNeste(ny);
			ny.setNeste(denne);
		}

		if(denne == null){
			siste = ny;
		}
		antall++;
	}

	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // F�rste element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}
	public void skrivUt(){
		LinearNode<T> aktuell = foerste;
		while(aktuell != null){
			System.out.println(aktuell.getElement().toString());
			aktuell = aktuell.getNeste();
		}
	}

}// class
