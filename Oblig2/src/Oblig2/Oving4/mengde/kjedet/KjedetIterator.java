package Oblig2.Oving4.mengde.kjedet;

//****************************************************************

//    Representerer en iterator for en kjedet struktur av noder 
//    kjedet line�rt. 
//****************************************************************
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author ole olsen
 * 
 */

public class KjedetIterator<T> implements Iterator<T> {
	private LinearNode<T> aktuell; // den aktuelle posisjonen.

	public KjedetIterator(LinearNode<T> samling) {
		aktuell = samling;
	}

	/************************************************************
	 * Returnerer sann hvis iteratoren har minst ett element igjen.
	 *************************************************************/

	@Override
	public boolean hasNext() {
		return (aktuell != null);
	}

	/*************************************************************
	 * Returnerer neste element hvis det fins.
	 *************************************************************/

	@Override
	public T next() {
		T resultat = null;
		if (!hasNext())
			throw new NoSuchElementException();
		resultat = aktuell.getElement();
		aktuell = aktuell.getNeste();

		return resultat;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Denne er ikke implementert");
	}

}
