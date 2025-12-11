package Types;

import java.util.HashMap;

public class Puzzle {
    private HashMap<Integer, Integer> bret;
    private UnusedPieceLists unusedPieceLists;

    public Puzzle(HashMap<Integer, Integer> bret, UnusedPieceLists unusedPieceLists) {
        this.bret = bret;
        this.unusedPieceLists = unusedPieceLists;
    }

    public HashMap<Integer, Integer> getBret() {
        return bret;
    }

    public UnusedPieceLists getUnusedPieceLists() {
        return unusedPieceLists;
    }

    public Puzzle copy() {
         HashMap<Integer, Integer> newBret = new HashMap<>();

         for (int i = 0; i < 256; i++) {
             newBret.put(i, this.bret.get(i));
        }

        return new Puzzle(newBret, unusedPieceLists.copy());
    }
}
