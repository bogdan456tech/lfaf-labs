package lab1;

import java.util.*;

public class FiniteAutomaton {
    private List<String> states = new ArrayList<>();
    private List<String> inputs = new ArrayList<>();
    private String initState;
    private String finalState;
    private List<List<String>> transitions = new ArrayList<>(4);

    public FiniteAutomaton(List<String> states, List<String> inputs, String initState, String finalState, List<List<String>> transitions ) {
        this.states.addAll(states);
        this.inputs.addAll(inputs);
        this.initState = initState;
        this.finalState = finalState;
        this.transitions.addAll(transitions);
    }

    public List<String> getStates() {
        return Collections.unmodifiableList(states);
    }

    public List<String> getInputs() {
        return Collections.unmodifiableList(inputs);
    }

    public String getInitState() {
        return initState;
    }

    public String getFinalState() {
        return finalState;
    }

    public List<List<String>> getTransitions() {
        return Collections.unmodifiableList(transitions);
    }

    public boolean checkWord(String word) {
        Map<String,Integer> inputs = new HashMap<>(Map.of("a",0,"b",1,"c",2,"d",3,"e",4,"f",5));
        Map<String,Integer> states = new HashMap<>(Map.of("S",0,"P",1,"Q",2,"X",3));

        String j = "S";

        for(int i=0; i<word.length(); i++) {
            j = transitions.get(states.get(j)).get(inputs.get(word.substring(i,i+1)));
            if(i<word.length()-1) {
                if(j.equals("-")) {
                    return false;
                }
            } else {
                if(!j.equals("X")) {
                    return false;
                }
            }
        }

        return true;

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Finite Automaton\n");
        sb.append("------------------\n");

        // States
        sb.append("Q = ").append(states).append("\n");

        // Alphabet
        sb.append("Σ = ").append(inputs).append("\n");

        // Initial state
        sb.append("q0 = ").append(initState).append("\n");

        // Final states
        sb.append("F = {").append(finalState).append("}\n");

        // Transitions
        sb.append("δ:\n");

        for (int i = 0; i < states.size(); i++) {
            for (int j = 0; j < inputs.size(); j++) {

                String next = transitions.get(i).get(j);

                if (!next.equals("-")) {
                    sb.append("δ(")
                            .append(states.get(i))
                            .append(", ")
                            .append(inputs.get(j))
                            .append(") = ")
                            .append(next)
                            .append("\n");
                }
            }
        }

        return sb.toString();
    }


}