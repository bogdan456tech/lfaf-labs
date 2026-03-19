package lab2;

public class Main {
    public static void main(String[] args) {

        FiniteAutomaton fa = new FiniteAutomaton();

        // Create states
        State q0 = new State("q0");
        State q1 = new State("q1");
        State q2 = new State("q2");
        State q3 = new State("q3");

        // Add states
        fa.states.add(q0);
        fa.states.add(q1);
        fa.states.add(q2);
        fa.states.add(q3);

        // Alphabet
        fa.alphabet.add('a');
        fa.alphabet.add('b');
        fa.alphabet.add('c');

        // Start & final states
        fa.startState = q0;
        fa.finalStates.add(q2);

        // Transitions
        fa.addTransition(q0, 'a', q0);
        fa.addTransition(q0, 'a', q1); // NDFA
        fa.addTransition(q1, 'c', q1);
        fa.addTransition(q1, 'b', q2);
        fa.addTransition(q2, 'b', q3);
        fa.addTransition(q3, 'a', q1);

        // Check determinism
        System.out.println("Is deterministic: " + fa.isDeterministic());

        // Convert to grammar
        Grammar grammar = fa.toGrammar();
        grammar.printGrammar();
        System.out.println("Grammar type: " + grammar.classify());

        // Convert NDFA → DFA
        FiniteAutomaton dfa = fa.convertToDFA();
        System.out.println("\nDFA Transitions:");
        dfa.printTransitions();
        System.out.println("DFA Final States: " + dfa.finalStates);
    }
}