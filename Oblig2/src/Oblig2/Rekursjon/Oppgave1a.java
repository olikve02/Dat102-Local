package Oblig2.Rekursjon;

public class Oppgave1a {
    public static int Sum(int n){
      int  sum = (n-1) + n;

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Sum(3));
    }
}
