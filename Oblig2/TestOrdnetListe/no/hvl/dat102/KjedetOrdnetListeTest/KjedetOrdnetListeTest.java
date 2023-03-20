package no.hvl.dat102.KjedetOrdnetListeTest;

import Oblig2.KjedetListe.Kjedet.KjedetOrdnetListe;
import Oblig2.KjedetListe.adt.OrdnetListeADT;
import no.hvl.dat102.adt.OrdnetListeADTTest;



public class KjedetOrdnetListeTest extends  OrdnetListeADTTest{
	   @Override
		protected OrdnetListeADT<Integer> reset() {
			return new KjedetOrdnetListe<Integer>();
		}		
}

