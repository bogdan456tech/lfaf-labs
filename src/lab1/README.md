# Regular Grammar to Finite Automaton Conversion

**Course:** Formal Languages & Finite Automata  
**Author:** Bogdan Arama

---

## Theory

This project demonstrates the conversion of a **regular grammar** into a **finite automaton**.  
A regular grammar consists of a set of variables (non-terminals), terminals, a start symbol, and production rules.  
Finite automata are abstract machines used to recognize regular languages, which can be derived from regular grammars.  
The program generates random words from the grammar and constructs the equivalent finite automaton to validate strings.

---

## Objectives

1. Implement a class to represent a regular grammar.
2. Generate words from the grammar randomly.
3. Convert the regular grammar into a finite automaton.
4. Implement a finite automaton class that can check whether a word belongs to the language.
5. Display transitions, states, and check sample words.

---

## Implementation Description

1. **Grammar Class**
    - Holds the variables (`vn`), terminals (`vt`), and production rules.
    - Method `generateString()` randomly generates a string based on the productions.
    - Method `toFiniteAutomaton()` converts the grammar into a `FiniteAutomaton` object.

2. **FiniteAutomaton Class**
    - Holds states, input alphabet, initial and final states, and transitions.
    - Method `checkWord()` validates if a string belongs to the language.
    - Overrides `toString()` to print the automaton's details in readable format.

3. **Main Class**
    - Creates a sample grammar.
    - Generates and prints 5 random words.
    - Converts the grammar to a finite automaton and prints it.
    - Checks whether a specific word is accepted by the automaton.

---

## Code Snippets

```java
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
    System.out.println(fa.checkWord("ae"));
}
