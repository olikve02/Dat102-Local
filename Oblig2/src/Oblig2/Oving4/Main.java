package Oblig2.Oving4;

import Oblig2.Oving4.Test.Testing;
import Oblig2.Oving4.mengde.kjedet.KjedetMengde;
import org.junit.jupiter.api.Test;

public class Main {
    public static void main(String[] args) {
        KjedetMengde kjedetMengde1 = new KjedetMengde();
        KjedetMengde kjedetMengde2 = new KjedetMengde();
        kjedetMengde1 = Testing.addNumbers(kjedetMengde1, 1, 5);
        kjedetMengde2 = Testing.addNumbers(kjedetMengde2, 3, 7);
        System.out.println(kjedetMengde1.toString());
        System.out.println(kjedetMengde2.toString());
        KjedetMengde snitt = (KjedetMengde) kjedetMengde1.snitt(kjedetMengde2);
    }
}
