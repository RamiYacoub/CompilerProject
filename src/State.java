

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class State {
    private String letter;
    private HashMap<String, Set<State>> paths;
    public boolean isFinalState = false;
    public boolean isEndState = false;
    public boolean isReachable = false;
    public String represents = "";

    State(String letter) {
        this.letter = letter;
        paths = new HashMap<>() {
            @Override
            public String toString() {
                return keySet().toString();
            }
        };
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }

    public void setPaths(HashMap<String, Set<State>> paths) {
        this.paths = paths;
    }

    void addPath(String edge) {
        paths.put(edge, new HashSet<>());
    }

    Set<State> getPath(String edge) {
        return paths.getOrDefault(edge, null);
    }

    void addToPath(String edge, State value) {
        paths.get(edge).add(value);
    }

    public HashMap<String, Set<State>> getPaths() {
        return paths;
    }

    void removePath(String edge) {
        paths.remove(edge);
    }

    @Override
    public boolean equals(Object obj) {
        return ((State) obj).getLetter().equals(this.letter);
    }

    @Override
    public String toString() {
        return "[" + letter + ",e:" + isFinalState + "," + paths.keySet() + "]";
    }
}
