package Oblig2.KjedetListe.Exceptions;

public class EmptyCollectionException extends RuntimeException{

    public EmptyCollectionException (String collection){
        super (" Denne " + collection + " er tom.");
    }
}
