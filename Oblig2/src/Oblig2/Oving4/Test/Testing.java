package Oblig2.Oving4.Test;

import Oblig2.Oving4.mengde.adt.MengdeADT;
import Oblig2.Oving4.mengde.kjedet.KjedetMengde;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class  Testing {

    KjedetMengde kjedetMengde1;
    KjedetMengde kjedetMengde2;
    int[] union;
    @BeforeEach
    public void setUp(){
        KjedetMengde kjedetMengde1 = new KjedetMengde();
        KjedetMengde kjedetMengde2 = new KjedetMengde();
        kjedetMengde1 = addNumbers(kjedetMengde1, 1, 3);
        kjedetMengde2 = addNumbers(kjedetMengde2, 4, 6);

        kjedetMengde1 = (KjedetMengde) kjedetMengde1.union(kjedetMengde2);
        union = kjedetMengde1.toArray();
        for (int i = 0; i < union.length; i++) {
            System.out.println(union[i]);
        }

    }
    @Test
    @DisplayName("Test av Union")
    public void testUnion(){
        Assertions.assertArrayEquals(new int[]{1,2,3,4,5,6}, union);
    }

    @Test
    @DisplayName("Test av toArray")
    public void testToArray(){
        KjedetMengde toArrayTest = new KjedetMengde();
        toArrayTest = addNumbers(toArrayTest, 1, 10);
        Assertions.assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10}, toArrayTest.toArray());
    }



    public static KjedetMengde addNumbers(KjedetMengde mengde, int start, int end){
        for (int i = start; i <= end; i++) {
            mengde.leggTil(i);
        }
        return mengde;
    }
}
