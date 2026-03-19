# Regular Grammar and Finite Automaton Conversion

**Course:** Formal Languages & Finite Automata
**Author:** Bogdan Arama

---

## Theory

This project demonstrates the conversion of a finite automaton into a regular grammar and explains the handling of determinism in finite automata. A finite automaton consists of a set of states, an input alphabet, a transition function, a start state, and a set of final states. Non-deterministic finite automata (NDFA) may have multiple transitions for the same input symbol from a single state, whereas deterministic finite automata (DFA) have at most one transition per symbol from each state. Regular grammars are abstract representations of regular languages, and any regular grammar can be mapped to a finite automaton and vice versa. This project converts a given NDFA into a DFA, generates the equivalent regular grammar, and verifies the determinism of the automaton.

---

## Objectives

The main goal of this project is to implement a class that represents a finite automaton and to convert an NDFA into a DFA using the subset construction algorithm. The project also generates the equivalent regular grammar from the automaton and checks whether the automaton is deterministic. It displays all states, transitions, final states, and grammar rules for validation purposes. The implementation provides a solid foundation for further extensions, such as visualization or user input for automata definitions.

---

## Implementation Description

The `State` class represents an individual state in the automaton. Each state has a name and overrides the `equals()` and `hashCode()` methods to allow proper comparison and handling in collections, such as sets and maps. This ensures that sets of states, which are used in DFA construction, are treated correctly.

The `FiniteAutomaton` class represents either an NDFA or a DFA. It maintains a set of states, the input alphabet, a transition table mapping states and input symbols to a set of destination states, the initial state, and a set of final states. The `addTransition()` method allows adding transitions, while `isDeterministic()` checks whether any state has multiple transitions for the same symbol. The `toGrammar()` method converts the automaton into a Type 3 regular grammar by creating production rules for each transition, including rules that lead to a terminal if the destination state is final. The `convertToDFA()` method implements the subset construction algorithm to convert an NDFA into a DFA. The `printTransitions()` method outputs all transitions in a readable format.

The `Grammar` class stores the regular grammar derived from the automaton. It contains a map of production rules, mapping each non-terminal to a list of possible derivations. The `addProduction()` method allows adding new rules, while `printGrammar()` outputs all grammar rules in a readable format. The `classify()` method returns the grammar type according to Chomsky hierarchy, indicating that it is a Type 3 regular grammar.

The `Main` class demonstrates the program workflow. It creates the NDFA for the specific variant, with states q0, q1, q2, and q3, input alphabet consisting of the symbols a, b, and c, and the final state q2. The transitions include multiple possible states for the same input symbol, representing non-determinism. The program first checks whether the automaton is deterministic. Then it converts the NDFA into a regular grammar and prints the rules. Finally, it converts the NDFA into a DFA using the subset construction method, printing all DFA transitions and final states.

The DFA constructed by the program can be visualized as follows:

![DFA Diagram](src/lab2/images/diagram.jpg)

The program produces output indicating whether the automaton is deterministic, the list of regular grammar production rules, the transitions of the DFA, and the final states of the DFA. For example, the NDFA is non-deterministic because the transition δ(q0, a) has multiple possible destinations. The DFA is constructed correctly, with each state representing a set of NDFA states, and the regular grammar accurately reflects the NDFA transitions.

---

## Conclusions

This project successfully demonstrates the correspondence between regular grammars and finite automata. It implements conversion from NDFA to DFA, generates a regular grammar from the automaton, and checks determinism programmatically. The final implementation is generic and can handle any NDFA with a similar structure. This exercise improves understanding of formal languages, automata theory, and practical Java implementation of theoretical concepts. The solution can be extended to visualize automata, accept dynamic user input, handle epsilon transitions, or generate sample words to validate automaton behavior.

---

## Future Work

Future extensions could include visualization of NDFA and DFA graphs, accepting dynamic input definitions of automata, handling epsilon-NFA and epsilon transitions, and generating sample words from the regular grammar to test whether the automaton accepts them. These improvements would enhance both usability and understanding of finite automata and formal languages.
