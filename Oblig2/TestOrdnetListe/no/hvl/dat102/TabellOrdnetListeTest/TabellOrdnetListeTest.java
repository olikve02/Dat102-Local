package no.hvl.dat102.TabellOrdnetListeTest;

import Oblig2.KjedetListe.adt.OrdnetListeADT;
import Oblig2.KjedetListe.tabell.TabellOrdnetListe;
import no.hvl.dat102.adt.OrdnetListeADTTest;

public class TabellOrdnetListeTest extends OrdnetListeADTTest {
	@Override
	protected OrdnetListeADT<Integer> reset() {
		return new TabellOrdnetListe<Integer>();
	}
}
