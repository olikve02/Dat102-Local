package Oblig2.Stack.kjedet;

import Oblig2.Stack.adt.Parantesskjekker;
import Oblig2.Stack.adt.StabelADT;
import Oblig2.Stack.exception.EmptyCollectionException;

public class KjedetStabel<T> implements StabelADT<T>, Parantesskjekker {
	private LinearNode<T> topp;
	private int antall;
	public KjedetStabel() {
		topp = null;
		antall = 0;
	}

	@Override
	public void push(T el) {
		LinearNode<T> nynode = new LinearNode<T>(el);
		nynode.setNeste(topp);
		topp = nynode;
		antall++;
	}

	@Override
	public T pop() {
		if (erTom())
			throw new EmptyCollectionException("stabel");
		T resultat = topp.getElement();
		topp = topp.getNeste();
		antall--;
		return resultat;
	}

	@Override
	public T peek() {
		if (erTom())
			throw new EmptyCollectionException("stabel");

		return topp.getElement();
	}

	@Override
	public boolean erTom() {
		return (topp == null);
	}

	@Override
	public boolean erVenstreparentes(char p) {
		return p == '(' || p == '[' || p == '{';
	}

	@Override
	public boolean erHogreparentes(char p) {
		return p == ')' || p == ']' || p == '}';
	}

	@Override
	public boolean erParentes(char p) {
		return erVenstreparentes(p) || erHogreparentes(p);
	}

	@Override
	public boolean erPar(char venstre, char hogre) {
		if(erVenstreparentes(venstre)){
			if(erHogreparentes(hogre)){
				if(venstre == '(') {
					if (hogre == ')') {
						return true;
					}
				}
				if(venstre == '['){
					if(hogre == ']'){
						return true;
					}
				}
				if(venstre == '{'){
					if(hogre == '}'){
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean erBalansert(String s) {
		boolean balanced = true;
		for (int i = 0; i < s.length(); i++) {
			if(erVenstreparentes(s.charAt(i))){
				push((T)(Character)s.charAt(i));
			} else if (erHogreparentes(s.charAt(i))) {
				if(!erPar((char)pop(), s.charAt(i))){
					balanced = false;
				}
			}
		}

		return balanced;
	}

	public int getAntall(){
		return antall;
	}

	public void printStabel(){
		for (int i = 0; i < antall; i++) {
			System.out.println(pop());
		}
	}

}