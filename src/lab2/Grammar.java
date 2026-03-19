package lab2;

import java.util.*;

public class Grammar {
    Map<String, List<String>> productions;

    public Grammar() {
        productions = new HashMap<>();
    }

    public void addProduction(String left, String right) {
        productions
                .computeIfAbsent(left, k -> new ArrayList<>())
                .add(right);
    }

    public void printGrammar() {
        System.out.println("Regular Grammar:");
        for (String left : productions.keySet()) {
            System.out.println(left + " -> " + String.join(" | ", productions.get(left)));
        }
    }

    public String classify() {
        return "Type 3 - Regular Grammar";
    }
}