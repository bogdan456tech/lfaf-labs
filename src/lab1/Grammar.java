package lab1;

import java.util.*;

public class Grammar {

    private List<String> vn = new ArrayList<String>();
    private List<String> vt = new ArrayList<String>();
    private Map<String, List<String>> production = new HashMap<>();

    public Grammar(List<String> vn, List<String> vt, Map<String, List<String>> production) {
        this.vn.addAll(vn);
        this.vt.addAll(vt);
        this.production.putAll(production);
    }

    public String generateString() {

        Random random = new Random();
        String init = "S";
        int r = random.nextInt(0,getList(init).size());
        StringBuilder result = new StringBuilder(getList(init).get(r));
        init=getList(init).get(r).substring(1,2);

        while(true) {
            r = random.nextInt(0,getList(init).size());

            if(getList(init).get(r).length()==1) {
                result.replace(result.length()-1,result.length(),getList(init).get(r));
                break;
            } else {
                result.replace(result.length()-1,result.length()+1,getList(init).get(r));
            }
            init=getList(init).get(r).substring(1,2);
        }

        return result.toString();

    }

    public List<String> getList(String key) {
        return production.get(key);
    }

    public FiniteAutomaton toFiniteAutomaton() {

        Map<String,Integer> inputs = new HashMap<>(Map.of("a",0,"b",1,"c",2,"d",3,"e",4,"f",5));

        List<List<String>> transitions = new ArrayList<>();

        for(int i=0; i<vn.size()+1; i++) {
            List<String> row = new ArrayList<>();
            for(int j=0; j<vt.size(); j++) {
                row.add("-");
            }
            transitions.add(row);
        }

        List<List<String>> jason = new ArrayList<>(List.of(getList("S"),getList("P"),getList("Q")));

        for(int i=0; i<3;i++) {
            for(int j=0; j<jason.get(i).size(); j++) {
                if(jason.get(i).get(j).length()==2) {
                    transitions.get(i).set(inputs.get(jason.get(i).get(j).substring(0,1)),jason.get(i).get(j).substring(1,2));
                } else {
                    transitions.get(i).set(inputs.get(jason.get(i).get(j).substring(0,1)),"X");
                }
            }
        }

        List<String> copyVn = new ArrayList<>(vn);
        copyVn.add("X");

        FiniteAutomaton fa = new FiniteAutomaton(
                copyVn,
                vt,
                "S",
                "X",
                transitions
        );

        return fa;

    }

}