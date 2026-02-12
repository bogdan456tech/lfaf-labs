package lab1;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Grammar grammar = new Grammar(
                List.of("S", "P", "Q"),
                List.of("a", "b", "c", "d", "e", "f"),
                Map.of(
                        "S", List.of("aP", "bQ"),
                        "P", List.of("bP", "cP", "dQ", "e"),
                        "Q", List.of("eQ", "fQ", "a")
                )
        );

        System.out.println("5 words:");
        for(int i=0; i<5; i++) {
            System.out.println(grammar.generateString());
        }

        FiniteAutomaton fa = grammar.toFiniteAutomaton();

        System.out.println(fa);

        if(fa.checkWord("ae")) {
            System.out.println("The word is eligible");
        } else {
            System.out.println("The word is not eligible");
        }

    }
}