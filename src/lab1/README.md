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
2. Generate words from the grammar randomly, in a generalizable way.
3. Convert the regular grammar into a finite automaton.
4. Implement a finite automaton class that can check whether a word belongs to the language.
5. Display transitions, states, and check sample words.

---

## Implementation Description

### 1. Grammar Class

The `Grammar` class holds all elements of a regular grammar. It stores the variables (`vn`), which are the non-terminal symbols of the grammar, the terminals (`vt`), which represent the alphabet symbols, and the production rules (`production`), which map each non-terminal to a list of possible derivations.

The class provides two main methods. The `generateString()` method initially used a variant-specific and more complex approach that was hardcoded for my assignment variant. After reworking, I implemented a general approach capable of generating words from any regular grammar. The method works by starting from the initial symbol `"S"` and randomly choosing productions, following non-terminals until a terminal-only string is formed. The resulting string is then returned as output.

The `toFiniteAutomaton()` method was initially implemented using a 2D array to represent transitions between terminals and non-terminals, which proved cumbersome and less flexible. Later, I reworked it to use a combination of `HashMap` and lists of strings, resulting in cleaner and more maintainable code. This method creates a transition table, maps terminal-only productions to an accepting state `"X"`, and returns a `FiniteAutomaton` object corresponding to the grammar.

---

### 2. FiniteAutomaton Class

The `FiniteAutomaton` class represents the converted automaton. It includes all original grammar variables as states, plus a final accepting state `"X"`. The input alphabet consists of the terminals of the grammar. The initial state is `"S"` and the final state is `"X"`. Transitions are represented as a 2D table mapping each current state and input symbol to the next state.

The `checkWord(String word)` method was initially implemented using multiple loops and operations, which made it more complex and inefficient. After reworking, it became a more efficient implementation that iterates through the input string and follows transitions to determine whether a word is accepted. The `toString()` method provides a readable representation of the finite automaton, showing states, alphabet, initial and final states, and transitions.

---

### 3. Main Class

The `Main` class demonstrates the program. It creates a sample grammar with non-terminals `S, P, Q` and terminals `a, b, c, d, e, f`. It generates 5 random words from the grammar and prints them. Then, it converts the grammar to a finite automaton using `toFiniteAutomaton()` and prints its transitions. Finally, it checks whether a specific word (e.g., `"ae"`) is accepted by the automaton and prints the result.

---

## Conclusions

The project demonstrates the correspondence between regular grammars and finite automata. Initially, some methods were implemented in a variant-specific or more complex way, but after reworking, I achieved general solutions applicable to any regular grammar. The final implementation allows random word generation, conversion to a finite automaton, and efficient word acceptance checking. The exercise improved understanding of formal languages, automata theory, and practical Java programming. The project can be extended to handle more complex grammars or include visualization of the automaton.
