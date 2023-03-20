package Oblig2.Stack.klient;

import Oblig2.Stack.kjedet.KjedetStabel;

public class Main {
    public static void main(String[] args) {
        KjedetStabel stack = new KjedetStabel();
        String string1 = "((Hei} jeg heter Oliv}er))";
        String string2 = "Hei (jeg}";
        String string3 = "Hei (jeg heter) {Oliver}";


        System.out.println(stack.erBalansert(string2));
        System.out.println(stack.erBalansert(string3));
        System.out.println(stack.erBalansert(string1));

    }
}
