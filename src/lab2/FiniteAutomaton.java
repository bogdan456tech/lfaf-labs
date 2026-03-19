package lab2;

import java.util.*;

public class FiniteAutomaton {
    Set<State> states;
    Set<Character> alphabet;
    Map<State, Map<Character, Set<State>>> transitions;
    State startState;
    Set<State> finalStates;

    public FiniteAutomaton() {
        states = new HashSet<>();
        alphabet = new HashSet<>();
        transitions = new HashMap<>();
        finalStates = new HashSet<>();
    }

    public void addTransition(State from, char symbol, State to) {
        transitions
                .computeIfAbsent(from, k -> new HashMap<>())
                .computeIfAbsent(symbol, k -> new HashSet<>())
                .add(to);
    }

    public boolean isDeterministic() {
        for (State state : transitions.keySet()) {
            for (char symbol : transitions.get(state).keySet()) {
                if (transitions.get(state).get(symbol).size() > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public Grammar toGrammar() {
        Grammar grammar = new Grammar();

        for (State from : transitions.keySet()) {
            for (char symbol : transitions.get(from).keySet()) {
                for (State to : transitions.get(from).get(symbol)) {

                    grammar.addProduction(from.toString(), symbol + to.toString());

                    if (finalStates.contains(to)) {
                        grammar.addProduction(from.toString(), String.valueOf(symbol));
                    }
                }
            }
        }

        return grammar;
    }

    public FiniteAutomaton convertToDFA() {
        FiniteAutomaton dfa = new FiniteAutomaton();

        Queue<Set<State>> queue = new LinkedList<>();
        Set<Set<State>> visited = new HashSet<>();

        Set<State> start = new HashSet<>();
        start.add(startState);

        queue.add(start);
        visited.add(start);

        dfa.startState = new State(start.toString());
        dfa.alphabet = this.alphabet;

        while (!queue.isEmpty()) {
            Set<State> current = queue.poll();
            State currentState = new State(current.toString());

            dfa.states.add(currentState);

            for (char symbol : alphabet) {
                Set<State> next = new HashSet<>();

                for (State s : current) {
                    if (transitions.containsKey(s) &&
                            transitions.get(s).containsKey(symbol)) {

                        next.addAll(transitions.get(s).get(symbol));
                    }
                }

                if (!next.isEmpty()) {
                    State nextState = new State(next.toString());
                    dfa.addTransition(currentState, symbol, nextState);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
        }

        for (Set<State> set : visited) {
            for (State s : set) {
                if (finalStates.contains(s)) {
                    dfa.finalStates.add(new State(set.toString()));
                }
            }
        }

        return dfa;
    }

    public void printTransitions() {
        for (State from : transitions.keySet()) {
            for (char symbol : transitions.get(from).keySet()) {
                System.out.println(from + " --" + symbol + "--> " +
                        transitions.get(from).get(symbol));
            }
        }
    }
}