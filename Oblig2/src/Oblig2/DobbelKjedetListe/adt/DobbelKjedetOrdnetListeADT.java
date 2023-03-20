package Oblig2.DobbelKjedetListe.adt;

public interface DobbelKjedetOrdnetListeADT<T> {

	/**
	 * 
	 * @param el er elementet som skal legges til
	 */
	void leggTil(T el);

	T fjern(T el);

	/**
	 * 
	 * @return returner true hvis listen er tom ellers false
	 */
	boolean erTom();

	/**
	 * 
	 * @return returnerer antall elementer
	 */
	int antall();

}
